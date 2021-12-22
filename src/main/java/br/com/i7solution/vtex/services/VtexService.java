package br.com.i7solution.vtex.services;

import br.com.i7solution.vtex.apivtex.*;
import br.com.i7solution.vtex.apivtex.dtos.*;
import br.com.i7solution.vtex.clients.*;
import br.com.i7solution.vtex.clients.dtos.*;
import br.com.i7solution.vtex.tools.DadosException;
import br.com.i7solution.vtex.tools.Ferramentas;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Log4j2
@Service
public class VtexService {

    @Autowired
    private PriceClient precosVtex;
    @Autowired
    private CatalogClient produtosVtex;
    @Autowired
    private EstoqueClient estoqueWinthor;
    @Autowired
    private ProdutoClient produtoWinthor;
    @Autowired
    private TabelaPrecoClient precosWinthor;
    @Autowired
    private PedidoClient pedidoWinthor;
    @Autowired
    private InventoryClient inventoryVtex;
    @Autowired
    private OrderClient pedidosVtex;
    @Autowired
    private TabelaPrecoClient tabelaPrecoWinthorClient;
    @Autowired
    private BrandClient marcaVtex;
    @Autowired
    private MarcaClient marcaClient;
    @Autowired
    private SecaoClient secaoClient;
    @Autowired
    private CategoryClient secaoVtex;
    @Autowired
    private FilialClient filialClientService;
    @Autowired
    private WarehouseClient warehouseClientService;

    //@Async(value = "taskAtualizacoes")
    //@Scheduled(fixedRate = 1800000, initialDelay = 10000)
    public void atualizarPrecos() throws IOException {
        log.info("[atualizarPrecos] - Iniciando sincronização de preços");
        var existeProximo = true;
        var pagina = 1;
        while (existeProximo) {
            var precos = tabelaPrecoWinthorClient.getPrecos(pagina, 100);
            if (precos != null) {
                sincronizarPrecos(precos);
            }
            pagina++;

            existeProximo = !((precos != null ? precos.length : 0) < 100);
        }
        log.info("[atualizarPrecos] - Fim da atualização de preços");
    }

    //@Async(value = "taskAtualizacoes")
    //@Scheduled(fixedRate = 10000000, initialDelay = 10000)
    public void atualizarFiliais() throws IOException {
        log.info("[atualizarFiliais] - Inciando sincronização de filiais");
        var filiais = filialClientService.carregar();
        if(filiais != null) {
            var warehouse = new WarehouseDTO();
            for (int i = 0; i < filiais.length; i++) {
                var filial = filiais[i];
                warehouse.setId(filial.getId());
                warehouse.setName(filial.getNomeFantasia() == null ? filial.getRazaoSocial() : filial.getNomeFantasia());

                warehouseClientService.postWarehouse(warehouse);
            }
        }
        log.info("[atualizarFiliais] - Finalizando sincronização de filiais");
    }

    @Async(value = "taskAtualizacoes")
    @Scheduled(fixedDelay = 3600000, initialDelay = 10000)
    public void atualizarProdutos() throws IOException {
        log.info("[atualizarProdutos] - Iniciando sincronização de produtos");
        var temRegistros = true;
        var nrPag = 1L;
        while (temRegistros) {
            var listaProd = produtoWinthor.getProdutos(nrPag,100L);
            if (listaProd != null) {
                for (ProdutoDTO produto: listaProd) {
                    if (produto != null) {
                        log.info("[atualizarProdutos] - Sincronizando produto " + produto.getId());
                        sincronizarProdutos(produto);
                    }
                }
                if (listaProd.length >= 100) {
                    ++nrPag;
                } else {
                    temRegistros = false;
                }
            } else {
                temRegistros = false;
            }
        }
        log.info("[atualizarProdutos] - Fim da Atualização de Produtos");
    }

    @Async(value = "taskAtualizacoes")
    //@Scheduled(fixedRate = 2400000, initialDelay = 60000)
    public void atualizacaoEstoque() throws IOException {
        log.info("Iniciando sincronização de estoques");
        try {
            var temRegistros = true;
            var nrPag = 1L;
            while (temRegistros) {
                var listaEstoques = estoqueWinthor.getEstoques(100L, nrPag);
                for (EstoqueDTO estoque: listaEstoques) {
                    if (estoque != null) {
                        var skuVtex = produtosVtex.getSKURefId(estoque.getProduto().getId().toString());
                        if (skuVtex != null) {
                            log.info(
                                "[atualizacaoEstoque] - Atualizando estoque do produto " +
                                estoque.getProduto().getId() +
                                " - " +
                                estoque.getProduto().getDescricao() +
                                " para " + estoque.getQuantidadeDisponivel()
                            );
                            var itemEstoque = new InventoryPutDTO();
                            itemEstoque.setQuantity(estoque.getQuantidadeDisponivel().intValue());
                            itemEstoque.setUnlimitedQuantity(false);

                            inventoryVtex.putEstoquePorSku(
                                itemEstoque,
                                skuVtex.getId(),
                                estoque.getFilial().getId()
                            );
                        }
                    }
                }
                if (listaEstoques.length == 100) {
                    ++nrPag;
                } else {
                    temRegistros = false;
                }
            }
        } catch (Exception e) {
            log.warn("[atualizacaoEstoque] - Erro: " + e);
        }
        log.info("Finalizando sincronização de estoques");
    }

    //@Async(value = "taskPedidos")
    //@Scheduled(fixedDelay = 60000, initialDelay = 10000)
    public void sincronizarPedidos() throws Exception {
        try {
            log.info("Integrando pedidos de venda...");
            //ready-for-handling
            //payment-approved
            var listOrders = pedidosVtex.getPedidos("ready-for-handling", 10L);
            for (OrderDTO order: listOrders) {
                try {
                    var pedW = pedidoWinthor.getPedidoPorNumpedWeb(
                            Long.parseLong(Ferramentas.somenteNumeros(order.getOrderId()))
                    );
                    if (pedW == null) {
                        var resultPed = ped_vtex_winthor(order);
                        if (resultPed != null) {
                            log.info(
                                "Pedido VTEX nr." + resultPed.getId() + "\n" +
                                "...Importado: " + resultPed.getImportado() + "\n" +
                                "...Msg: " + resultPed.getObservacaoIntegracao() + "\n" +
                                "...Pedido Winthor: " + resultPed.getIdPedidoErp() + "\n"
                            );
                        }
                    }
                } catch (Exception e) {
                    log.warn("[sincronizarPedidos - loop] - Erro pedido: " + order.getOrderId() + " msg de erro ->" + e);
                }
            }
            log.info("Fim da integração dos pedidos de venda.");
        } catch (Exception e) {
            log.warn("[sincronizarPedidos] - Erro: " + e);
        }
    }

    @Async(value = "taskPedidos")
    public PedidoDTO ped_vtex_winthor(OrderDTO pedVtex) throws Exception {
        var pedWinthor = new PedidoDTO();
        String pontoErro = "";

        try {
            var pedV = pedidosVtex.getPedidoPorId(pedVtex.getOrderId());

            pontoErro = "dados cabeçalho";

            var clienteVtex = pedV.getClientProfileData();
            var clienteWinthor = new ClienteDTO();
            if (clienteVtex.getDocumentType().equalsIgnoreCase("cpf")) {
                clienteWinthor.setCpfCnpj(clienteVtex.getDocument());
                clienteWinthor.setEmail(clienteVtex.getEmail());
                clienteWinthor.setNome(clienteVtex.getFirstName() + " " + clienteVtex.getLastName());
                clienteWinthor.setTelefoneFixo(clienteVtex.getPhone());
                clienteWinthor.setTelefoneCelular(clienteVtex.getCorporatePhone());
            } else {
                throw new DadosException("Pedido: " + pedVtex.getOrderId() + "\n" +
                "O cliente precisa estar cadastrado com um CPF ou CNPJ para que o pedido seja faturado.");
            }

            var praca = new PracaDTO();
            praca.setId("1");
            clienteWinthor.setPraca(praca);

            var enderecoVtex = pedV.getShippingData().getAddress();
            var enderecoWinthor = new EnderecoDTO();
            enderecoWinthor.setBairro(enderecoVtex.getNeighborhood());
            enderecoWinthor.setCep(enderecoVtex.getPostalCode());
            enderecoWinthor.setComplemento(enderecoVtex.getComplement());
            enderecoWinthor.setCidade(enderecoVtex.getCity());
            var uf = getUF(enderecoVtex.getState());
            enderecoWinthor.setUf(uf);
            enderecoWinthor.setPais(enderecoVtex.getCountry());
            enderecoWinthor.setNumero(Ferramentas.stringToInt(enderecoVtex.getNumber()));
            enderecoWinthor.setRua(enderecoVtex.getStreet());

            pedWinthor.setId(Ferramentas.somenteNumeros(pedV.getOrderId()));
            pedWinthor.setEndereco(enderecoWinthor);
            pedWinthor.setIdPedidoCliente(Ferramentas.somenteNumeros(pedV.getOrderId()));
            var filial = new FilialDTO();
            filial.setId("1");
            pedWinthor.setFilial(filial);
            pedWinthor.setCliente(clienteWinthor);
            pedWinthor.setValorTotal(pedV.getValue() / 100);
            pedWinthor.setIdPedidoCliente(Ferramentas.somenteNumeros(pedV.getOrderId()));
            pedWinthor.setOrigemPedido("W");
            pedWinthor.setTipoIntegracao("W");
            pedWinthor.setTipoVenda("1");

            var vendedor = new VendedorDTO();
            switch (uf) {
                case "GO":
                    vendedor.setId("9994");
                    break;
                case "DF":
                    vendedor.setId("9995");
                    break;
                case "TO":
                    vendedor.setId("9996");
                    break;
                case "SP":
                    vendedor.setId("9997");
                    break;
                case "BA":
                    vendedor.setId("9998");
                    break;
                default:
                    vendedor.setId("9994");
            }
            pedWinthor.setVendedor(vendedor);

            pontoErro = "Definindo dados de pagamento...";
            var pagtos = pedV.getPaymentData().getTransactions()[0];
            var customData = pedV.getCustomData();
            var cob = new CobrancaDTO();
            var plPag = new PlanoDePagamentoDTO();
            if (pagtos.getPayments().length > 0) {
                if (pagtos.getPayments()[0].getGroup().equals("creditCard")) {
                    cob.setId("CAR");
                    plPag.setId("1");
                }

                if (pagtos.getPayments()[0].getGroup().equals("creditControl")) {
                    cob.setId("BK");

                    if (pagtos.getPayments()[0].getPaymentSystem().equals("64")) {
                        if (customData == null) {
                            plPag.setId("1");
                        } else {
                            if (customData.getCustomApps()[0].getFields().getQuantity().equals("1")) {
                                switch (customData.getCustomApps()[0].getFields().getDeadlines_1()) {
                                    case "7":
                                        plPag.setId("160");
                                        break;
                                    case "14":
                                        plPag.setId("161");
                                        break;
                                    case "21":
                                        plPag.setId("162");
                                        break;
                                    case "28":
                                        plPag.setId("163");
                                        break;
                                    default:
                                        plPag.setId("160");
                                }
                            } else {
                                if ( // 07/14/21
                                        customData.getCustomApps()[0].getFields().getDeadlines_1().equals("7") &&
                                                customData.getCustomApps()[0].getFields().getDeadlines_2().equals("14") &&
                                                customData.getCustomApps()[0].getFields().getDeadlines_3().equals("21")
                                ) {
                                    plPag.setId("164");
                                }
                                if ( // 14/21/28
                                        customData.getCustomApps()[0].getFields().getDeadlines_1().equals("14") &&
                                                customData.getCustomApps()[0].getFields().getDeadlines_2().equals("21") &&
                                                customData.getCustomApps()[0].getFields().getDeadlines_3().equals("28")
                                ) {
                                    plPag.setId("165");
                                }
                                if ( // 21/28/35
                                        customData.getCustomApps()[0].getFields().getDeadlines_1().equals("21") &&
                                                customData.getCustomApps()[0].getFields().getDeadlines_2().equals("28") &&
                                                customData.getCustomApps()[0].getFields().getDeadlines_3().equals("35")
                                ) {
                                    plPag.setId("166");
                                }
                            }
                        }
                    }
                }
            }
            if (plPag.getId() == null) {
                log.warn("[" + pontoErro + "] - Pedido nr. " + pedV.getOrderId() + " não possui um plano de pagto correspondente no ERP.");
//                throw new DadosException("Pedido: " + pedVtex.getOrderId() +
//                        " não possui um plano de pagto correspondente no ERP.");
                return null;
            }

            pedWinthor.setCobranca(cob);
            pedWinthor.setPlanoDePagamento(plPag);

            pontoErro = "Lendo itens...";
            var itensVtex = pedV.getItems();
            var listItens = new ItemPedidoDTO[itensVtex.length];
            for (var i = 0; i < itensVtex.length; i++) {
                var prodW = produtoWinthor.getProdutoPorId(itensVtex[i].getRefId());
                if (prodW != null) {
                    var item = new ItemPedidoDTO();
                    item.setProduto(prodW);
                    item.setPreco((double) itensVtex[i].getPrice() / 100);
                    item.setQuantidade((double) itensVtex[i].getQuantity());
                    item.setSequencial((long) i + 1);

                    listItens[i] = item;
                } else {
                    log.warn("[ped_vtex_winthor] Alerta! Pedido nr." + pedV.getOrderId() +
                             " o produto " + itensVtex[i].getRefId() + " não foi encontrado no Winthor.");
                }
            }

            pedWinthor.setItens(listItens);
            pedWinthor.setQuantidadeItens((long) listItens.length);
            pedWinthor.setIntegradora("28");

            log.info("Fim da leitura do itens.");
            return pedidoWinthor.postPedido(pedWinthor);

        } catch (DadosException e) {
            log.warn("[ped_vtex_winthor] " + pontoErro + " -> msg original: " + e.getMensagem());
        } catch (Exception e) {
            log.error("[ped_vtex_winthor] " + pontoErro + " -> msg original: " + e);
            throw new Exception(e.getMessage());
        }
        return null;
    }

    //@Async
    //@Scheduled(fixedRate = 20000, initialDelay = 10000)
    public void sincronizarMarcas() {
        log.info("Iniciando sincronização de Marcas...");
        try {
            var marcas = marcaClient.getMarcas();
            for (int i = 0; i < 1; i++) {
                var marca = marcas.get(i);
                if (marca.getIdVtex() == null) {
                    var brand = new BrandInclusaoDTO();
                    brand.setName(marca.getDescricao());
                    brand.setActive(true);
                    brand.setSiteTitle(marca.getDescricao());

                    var brandRetorno = marcaVtex.postBrand(brand);
                    if (brandRetorno != null) {
                        marca.setIdVtex(brandRetorno.getId().toString());
                        marcaClient.putMarca(marca);
                    }
                }
            }

            log.info("Finalizando sincronização de Marcas...");
        } catch (Exception e) {
            log.error(e.toString());
            e.printStackTrace();
        }


    }

    //@Async
    //@Scheduled(fixedRate = 20000, initialDelay = 10000)
    public void sincronizarSecao() {
        log.info("Iniciando sincronização de Seções...");
        try {
            var secoes = secaoClient.getSecoes();
            for (int i = 0; i < 1; i++) {
                var secao = secoes.get(i);
                if (secao.getIdVtex() != null) {
                    var category = new CategoryInclusaoDTO();
                    category.setName(secao.getDescricao());
                    category.setActive(true);

                    var secaoRetorno = secaoVtex.postCategory(category);
                    if (secaoRetorno != null) {
                        System.out.println(secaoRetorno.getId());
                        secao.setIdVtex(secaoRetorno.getId().toString());
                        secaoClient.putSecao(secao);
                    }
                }
            }
            log.info("Finalizando sincronização de Seções...");
        } catch (Exception e) {
            log.error(e.toString());
            e.printStackTrace();
        }
    }

    private void sincronizarProdutos(ProdutoDTO produto) {
        try {
            var produtoVtexRef = produtosVtex.getProdutoRefId(produto.getId().toString());
            var produtoInclusaoVtex = new ProductInclusaoDTO();

            if (produtoVtexRef == null) {
                log.info("Cadastrando produto " + produto.getId());
                produtoInclusaoVtex.setName(produto.getDescricao());
                produtoInclusaoVtex.setDepartmentId(1L);
                produtoInclusaoVtex.setCategoryId(1L);
                produtoInclusaoVtex.setBrandId(2000000L);

                var link = Ferramentas.removerAcentos(produto.getDescricao().toLowerCase(Locale.ROOT)) + "-" + produto.getId();
                produtoInclusaoVtex.setLinkId(link.replace(" ", "-"));

                produtoInclusaoVtex.setRefId(produto.getId().toString());
                produtoInclusaoVtex.setVisible(false);
                produtoInclusaoVtex.setDescription(Ferramentas.toRSCase(produto.getDescricao()));
                produtoInclusaoVtex.setDescriptionShort(Ferramentas.toRSCase(produto.getDescricao()));
                produtoInclusaoVtex.setReleaseDate(
                        Ferramentas.dataFormatada(Date.from(Instant.now()), "yyyy-MM-dd HH:mm:ss")
                );
                produtoInclusaoVtex.setKeyWords(Ferramentas.toRSCase(produto.getSubtituloecommerce()));
                produtoInclusaoVtex.setTitle(Ferramentas.toRSCase(produto.getNomeecommerce()));
                produtoInclusaoVtex.setActive(true);
                produtoInclusaoVtex.setTaxCode("");
                produtoInclusaoVtex.setMetaTagDescription("");
                produtoInclusaoVtex.setSupplierId(null);
                produtoInclusaoVtex.setShowWithoutStock(true);
                produtoInclusaoVtex.setAdWordsRemarketingCode("");
                produtoInclusaoVtex.setLomadeeCampaignCode("");
                produtoInclusaoVtex.setScore(1L);

                var produtoIncluido = produtosVtex.postProduto(produtoInclusaoVtex);
                if (produtoIncluido != null) {
                    if (produtoIncluido.getId() != null) {
                        log.info("Produto cadastrado no VTEX(productId VTEX: " + produtoIncluido.getId() + ")");
                    }
                }
            }

            var skuProduto = produtosVtex.getSKURefId(produto.getId().toString());
            var skuInclusaoVtex = new SkuInclusaoDTO();
            if ((produtoVtexRef != null) && (skuProduto == null)) {
                log.info("Cadastrando SKU para o produto " + produto.getId());
                skuInclusaoVtex.setProductId(produtoVtexRef.getId());
                skuInclusaoVtex.setIsActive(false);
                skuInclusaoVtex.setName(Ferramentas.toRSCase(produtoVtexRef.getName()));
                skuInclusaoVtex.setRefId(produto.getId().toString());
                skuInclusaoVtex.setPackagedHeight(produto.getAltura());
                skuInclusaoVtex.setPackagedLength(produto.getComprimento());
                skuInclusaoVtex.setPackagedWidth(produto.getLargura());
                skuInclusaoVtex.setPackagedWeightKg(produto.getPesoLiquido());
                skuInclusaoVtex.setHeight(produto.getAltura());
                skuInclusaoVtex.setLength(produto.getComprimento());
                skuInclusaoVtex.setWidth(produto.getLargura());
                skuInclusaoVtex.setWeightKg(produto.getPesoLiquido());
                skuInclusaoVtex.setCubicWeight(0.0);
                skuInclusaoVtex.setIsKit(false);
                skuInclusaoVtex.setCreationDate(Date.from(Instant.now()));
                skuInclusaoVtex.setRewardValue(0.0);
                skuInclusaoVtex.setEstimatedDateArrival("");
                skuInclusaoVtex.setManufacturerCode(produto.getCodigoDeFabrica());
                skuInclusaoVtex.setCommercialConditionId(null);
                skuInclusaoVtex.setMeasurementUnit(produto.getUnidade());
                skuInclusaoVtex.setUnitMultiplier(produto.getMultiploVenda());
                skuInclusaoVtex.setModalType(null);
                skuInclusaoVtex.setKitItensSellApart(false);
                skuInclusaoVtex.setHeighCubicWeightt(null);

                produtosVtex.postSku(skuInclusaoVtex);
            }

            skuProduto = produtosVtex.getSKURefId(produto.getId().toString());
            if (skuProduto != null) {
                if (skuProduto.getId() != null) {
                    var skuFileExistente = produtosVtex.getSkuFile(skuProduto.getId());
                    if (skuFileExistente == null) {
                        var imgProd = produtoWinthor.getFotoProdutoPorId(produto.getId().toString());
                        if (imgProd != null && !imgProd.isEmpty()) {
                            var skuFile = new SkuFileDTO();
                            skuFile.setId(null);
                            skuFile.setSkuId(skuProduto.getId());
                            skuFile.setArchiveId(null);
                            var nameSkuFile = Ferramentas.removerAcentos(skuProduto.getName());
                            skuFile.setName(
                                nameSkuFile
                                    .replace(".", "")
                                    .replace(" ", "-")
                            );
                            skuFile.setLabel(skuProduto.getName());
                            skuFile.setText(skuProduto.getName());
                            skuFile.setUrl((String) imgProd.get("url"));
                            skuFile.setIsMain(true);
                            //skuFile.setImage((byte[]) imgProd.get("file"));

                            if (produtosVtex.postSkuFile(skuFile)) {
                                log.info("Foto enviada com sucesso");
                            } else {
                                log.info("Não foi possível enviar foto");
                            }
                        }
                    }

                    if (produto.getCodigoDeBarras() != null) {
                        var skuEan = produtosVtex.getSkuEan(skuProduto.getId().toString());
                        if (skuEan == null) {
                            produtosVtex.postSkuEan(
                                skuProduto.getId().toString(),
                                produto.getCodigoDeBarras().toString()
                            );
                        }
                    }
                } else {
                    log.info("SKU cadastrado na VTEX(skuId VTEX: " + skuProduto.getId() + ")");
                }
            }
        } catch (Exception e) {
            log.warn("[sincronizarProdutos] - Erro: " + e);
        }
    }

    private void sincronizarPrecos(TabelaPrecoDTO[] precos) throws IOException {
        for (TabelaPrecoDTO preco : precos) {
            log.info("Sincronizando preço do produto: " + preco.getIdProduto());
            var skuVtex = produtosVtex.getSKURefId(preco.getIdProduto());

            if (skuVtex != null) {
                var priceVtexDto = new PriceDTO();
                priceVtexDto.setBasePrice(preco.getPreco());
                priceVtexDto.setMarkup(null);
                priceVtexDto.setListPrice(preco.getPreco());
                var precoAtualizado = precosVtex.putPreco(skuVtex.getId().toString(), priceVtexDto);
                if (precoAtualizado) log.info("Preço do produto: " + preco.getIdProduto() + " atualizado com sucesso!");
            } else {
                log.info("Não existe SKU para o produto: " + preco.getIdProduto());
            }
        }
    }

    private String getUF(String regiao) {
        String estado = Ferramentas.removerAcentos(regiao);
        if (estado.equalsIgnoreCase("Rio Grande do Sul")) {
            return "RS";
        }
        if (estado.equalsIgnoreCase("Santa Catarina")) {
            return "SC";
        }
        if (estado.equalsIgnoreCase("Parana")) {
            return "PR";
        }
        if (estado.equalsIgnoreCase("Sao Paulo")) {
            return "SP";
        }
        if (estado.equalsIgnoreCase("Minas Gerais")) {
            return "MG";
        }
        if (estado.equalsIgnoreCase("Espirito Santo")) {
            return "ES";
        }
        if (estado.equalsIgnoreCase("Rio de Janeiro")) {
            return "RJ";
        }
        if (estado.equalsIgnoreCase("Pernambuco")) {
            return "PE";
        }
        if (estado.equalsIgnoreCase("Bahia")) {
            return "BA";
        }
        if (estado.equalsIgnoreCase("Piaui")) {
            return "PI";
        }
        if (estado.equalsIgnoreCase("Alagoas")) {
            return "AL";
        }
        if (estado.equalsIgnoreCase("Sergipe")) {
            return "SE";
        }
        if (estado.equalsIgnoreCase("Paraiba")) {
            return "PB";
        }
        if (estado.equalsIgnoreCase("Maranhao")) {
            return "MA";
        }
        if (estado.equalsIgnoreCase("Rio Grande do Norte")) {
            return "RN";
        }
        if (estado.equalsIgnoreCase("Ceara")) {
            return "CE";
        }
        if (estado.equalsIgnoreCase("Roraima")) {
            return "RR";
        }
        if (estado.equalsIgnoreCase("Rondonia")) {
            return "RO";
        }
        if (estado.equalsIgnoreCase("Acre")) {
            return "AC";
        }
        if (estado.equalsIgnoreCase("Amapa")) {
            return "AM";
        }
        if (estado.equalsIgnoreCase("Para")) {
            return "PA";
        }
        if (estado.equalsIgnoreCase("Tocantins")) {
            return "TO";
        }
        if (estado.equalsIgnoreCase("Mato Grosso")) {
            return "MT";
        }
        if (estado.equalsIgnoreCase("Mato Grosso do Sul")) {
            return "MS";
        }
        if (estado.equalsIgnoreCase("Goias")) {
            return "GO";
        }
        if (estado.equalsIgnoreCase("Distrito Federal")) {
            return "DF";
        }

        return estado.toUpperCase();
    }

}




