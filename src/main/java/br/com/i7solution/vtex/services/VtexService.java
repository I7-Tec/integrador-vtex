package br.com.i7solution.vtex.services;

import br.com.i7solution.vtex.apivtex.*;
import br.com.i7solution.vtex.apivtex.dtos.*;
import br.com.i7solution.vtex.clients.*;
import br.com.i7solution.vtex.clients.dtos.*;
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

    @Async(value = "taskAtualizacoes")
    @Scheduled(fixedRate = 1800000, initialDelay = 10000)
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
    @Scheduled(fixedDelay = 1800000, initialDelay = 10000)
    public void atualizarProdutos() throws IOException {
        log.info("[atualizarProdutos] - Iniciando sincronização de produtos");

        var lista = new ArrayList<String>();
//        lista.add("2507");
//        lista.add("51682");
//        lista.add("25100");
//        lista.add("25639");
//        lista.add("63092");
        lista.add("75");
        lista.add("312");
        lista.add("619");
        lista.add("1090");
        lista.add("1297");

        for (var i = 0; i < lista.size(); i++) {
            log.info("[atualizarProdutos] - Lendo produto " + lista.get(i));
            var produto = produtoWinthor.getProdutoPorId(lista.get(i));
            var produtos = new ArrayList<ProdutoDTO>();
            if (produto != null) {
                produtos.add(produto);
                log.info("[atualizarProdutos] - Sincronizando produto " + produto.getId());
                sincronizarProdutos(produtos);
            } else {
                log.warn("[atualizarProdutos] - Produto " + lista.get(i) + " não encontrado no Winthor.");
            }
        }
        log.info("[atualizarProdutos] - Fim da Atualização de Produtos");
    }

    @Async(value = "taskAtualizacoes")
    @Scheduled(fixedRate = 1200000, initialDelay = 60000)
    public void atualizacaoEstoque() throws IOException {
        log.info("Iniciando sincronização de estoques");
        try {
            var lista = new ArrayList<String>();
            lista.add("75");
            lista.add("312");
            lista.add("619");
            lista.add("1090");
            lista.add("1297");
            for (int e = 0; e < lista.size(); e++) {
                var estoque = estoqueWinthor.getEstoquePorId("1", lista.get(e));
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

//            var listaEstoques = estoqueWinthor.getEstoque();
//            for (int e = 0; e < listaEstoques.length; e++) {
//                var estoque = listaEstoques[e];
//                var skuVtex = produtosVtex.getSKURefId(estoque.getProduto().getId());
//                if (skuVtex != null) {
//                    log.info("[atualizacaoEstoque] - Atualizando estoque do produto " +
//                            estoque.getProduto().getId() +
//                            " - " +
//                            estoque.getProduto().getDescricao() +
//                            " para " + estoque.getQuantidadeDisponivel()
//                    );
//                    var itemEstoque = new InventoryPutDTO();
//                    itemEstoque.setQuantity(estoque.getQuantidadeDisponivel());
//                    itemEstoque.setUnlimitedQuantity(false);
//
//                    inventoryVtex.putEstoquePorSku(
//                            itemEstoque,
//                            skuVtex.getId(),
//                            estoque.getFilial().getId()
//                    );
//                }
//            }
        } catch (Exception e) {
            log.warn("[atualizacaoEstoque] - Erro: " + e);
        }
        log.info("Finalizando sincronização de estoques");
    }

    @Async(value = "taskPedidos")
    @Scheduled(fixedRate = 10000, initialDelay = 60000)
    public void sincronizarPedidos() throws Exception {
        try {
            log.info("Integrando pedidos de venda...");
            var listOrders = pedidosVtex.getPedidos("payment-approved", 10L);
            for (int i = 0; i < listOrders.size(); i++) {
                var pedW = pedidoWinthor.getPedidoPorNumpedWeb(
                    Long.parseLong(Ferramentas.somenteNumeros(listOrders.get(i).getOrderId()))
                );
                if ((pedW == null) || (pedW.getId() == null)) {
                    ped_vtex_winthor(listOrders.get(i));

                    var resultPed = pedidoWinthor.importarPedido(
                        Long.parseLong(Ferramentas.somenteNumeros(listOrders.get(i).getOrderId()))
                    );
                    log.info(
                        "Pedido VTEX nr." + resultPed.getNumpedweb() + "\n" +
                        "...Importado: " + resultPed.getImportado() + "\n" +
                        "...Msg: " + resultPed.getMsg() + "\n" +
                        "...Pedido Winthor: " + resultPed.getNumped() + "\n"
                    );
                }
            }
            log.info("Fim da integração dos pedidos de venda.");
        } catch (Exception e) {
            log.warn("[sincronizarPedidos] - Erro: " + e);
        }
    }

    public void ped_vtex_winthor(OrderDTO pedVtex) throws Exception {
        var pedWinthor = new PedidoDTO();
        String pontoErro = "";

        try {
            var pedV = pedidosVtex.getPedidoPorId(pedVtex.getId());

            pontoErro = "dados cabeçalho";

            var clienteVtex = pedV.getClientProfileData();
            var clienteWinthor = new ClienteDTO();
            clienteWinthor.setCpfCnpj(clienteVtex.getDocument());
            clienteWinthor.setEmail(clienteVtex.getEmail());
            clienteWinthor.setNome(clienteVtex.getFirstName() + " " + clienteVtex.getLastName());
            clienteWinthor.setTelefoneFixo(clienteVtex.getPhone());
            clienteWinthor.setTelefoneCelular(clienteVtex.getCorporatePhone());

            var enderecoVtex = new AdressDTO();
            var enderecoWinthor = new EnderecoDTO();
            enderecoWinthor.setBairro(enderecoVtex.getNeighborhood());
            enderecoWinthor.setCep(enderecoVtex.getPostalCode());
            enderecoWinthor.setComplemento(enderecoVtex.getComplement());
            enderecoWinthor.setMunicipio(enderecoVtex.getCity());
            enderecoWinthor.setUf(enderecoVtex.getState());
            enderecoWinthor.setPais(enderecoVtex.getCountry());
            enderecoWinthor.setNumero(enderecoVtex.getNumber());
            enderecoWinthor.setRua(enderecoVtex.getStreet());

            pedWinthor.setId(pedV.getId().toString());
            pedWinthor.setEndereco(enderecoWinthor);
            pedWinthor.setIdPedidoEcommerce(pedV.getId().toString());
            pedWinthor.setIdFilial("1");
            pedWinthor.setCliente(clienteWinthor);
            pedWinthor.setValorTotal(pedV.getValue());
            pedWinthor.setIdPedidoEcommerce(pedV.getId().toString());
            pedWinthor.setIdPedidoCliente(pedV.getOrderId());

            pontoErro = "Definindo dados de pagamento...";
            var pagtos = pedV.getPaymentData().getTransactions()[0];
            if (pagtos.getPayments().length > 0) {
                if (pagtos.getPayments()[0].getGroup().equals("creditCard")) {
                    if (pagtos.getPayments().length == 1) {
                        pedWinthor.setIdCobranca("WCCI");
                    } else {
                        pedWinthor.setIdCobranca("WCPI");
                    }

                    switch (pagtos.getPayments().length) {
                        case 1:
                            pedWinthor.setIdPlanoDePagamento("24");
                        case 2:
                            pedWinthor.setIdPlanoDePagamento("25");
                        case 3:
                            pedWinthor.setIdPlanoDePagamento("26");
                        case 4:
                            pedWinthor.setIdPlanoDePagamento("27");
                        case 5:
                            pedWinthor.setIdPlanoDePagamento("28");
                        case 6:
                            pedWinthor.setIdPlanoDePagamento("29");
                        case 7:
                            pedWinthor.setIdPlanoDePagamento("30");
                        case 8:
                            pedWinthor.setIdPlanoDePagamento("31");
                        case 9:
                            pedWinthor.setIdPlanoDePagamento("32");
                        case 10:
                            pedWinthor.setIdPlanoDePagamento("33");
                        case 11:
                            pedWinthor.setIdPlanoDePagamento("34");
                        case 12:
                            pedWinthor.setIdPlanoDePagamento("35");
                        default:
                            pedWinthor.setIdPlanoDePagamento("23");
                    }
                } else {
                    pedWinthor.setIdCobranca("WBI");
                    pedWinthor.setIdPlanoDePagamento("39");
                }
            }

            pontoErro = "Lendo itens...";
            var itensVtex = pedV.getItems();
            var listItens = new ItemPedidoDTO[itensVtex.length];
            for (var i = 0; i < itensVtex.length; i++) {
                var prodW = produtoWinthor.getProdutoPorId(itensVtex[i].getRefId());

                var item = new ItemPedidoDTO();
                item.setNumpedweb(Long.parseLong(Ferramentas.somenteNumeros(pedV.getOrderId())));
                item.setIntegradora("28");
                item.setCodcli(pedWinthor.getCliente().getId());
                item.setCodfilialretira(null);
                item.setCodprod(prodW.getId());
                item.setCodauxiliar(prodW.getCodigoDeBarras());
                item.setData(pedWinthor.getDataCriacao());
                item.setPesobruto(prodW.getPeso());
                item.setPtabela((double) itensVtex[i].getListPrice() / 100);
                item.setPvenda((double) itensVtex[i].getPrice() / 100);
                item.setQt((double) itensVtex[i].getQuantity());
                item.setNumseq((long) i);

                listItens[i] = item;
            }

            pedWinthor.setItens(listItens);
            pedWinthor.setQuantidadeItens((long) listItens.length);

            pedidoWinthor.postPedido(pedWinthor);

        } catch (Exception e) {
            log.error("ped_vtex_winthor: " + pontoErro + " -> msg original: " + e);
            throw new Exception(e.getMessage());
        }
        log.info("Fim da leitura dos itens.");
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


    private void sincronizarProdutos(List<ProdutoDTO> produtos) {
        try {
            for (int i = 0; i < produtos.size(); i++) {
                var produto = produtos.get(i);

                var produtoVtexRef = produtosVtex.getProdutoRefId(produto.getId().toString());
                var produtoInclusaoVtex = new ProductInclusaoDTO();
                Long idProdutoVtex = 0L;
                if (produtoVtexRef == null) {
                    log.info("Cadastrando produto " + produto.getId());
                    produtoInclusaoVtex.setName(produto.getDescricao());
                    produtoInclusaoVtex.setDepartmentId(1L);
                    produtoInclusaoVtex.setCategoryId(1L);
                    produtoInclusaoVtex.setBrandId(2000000L);
//                    if (produto.getDepartamento() != null) {
//                        produtoInclusaoVtex.setDepartmentId(Ferramentas.stringToLong(produto.getDepartamento().getIdVtex()));
//                    } else {
//                        throw new DadosException("Produto " + produto.getId() + " sem departamento válido.");
//                    }
//                    if (produto.getCategoria() != null) {
//                        produtoInclusaoVtex.setCategoryId(Ferramentas.stringToLong(produto.getCategoria().getIdVtex()));
//                    } else {
//                        throw new DadosException("Produto " + produto.getId() + " sem categoria válida.");
//                    }
//                    if (produto.getMarca() != null) {
//                        produtoInclusaoVtex.setBrandId(Ferramentas.stringToLong(produto.getMarca().getIdVtex()));
//                    } else {
//                        throw new DadosException("Produto " + produto.getId() + " sem marca válida.");
//                    }

                    var link = Ferramentas.removerAcentos(produto.getDescricao().toLowerCase(Locale.ROOT)) + "-" + produto.getId();
                    produtoInclusaoVtex.setLinkId(link.replace(" ", "-"));

                    produtoInclusaoVtex.setRefId(produto.getId().toString());
                    produtoInclusaoVtex.setVisible(false);
                    produtoInclusaoVtex.setDescription(Ferramentas.toRSCase(produto.getDescricao()));
                    produtoInclusaoVtex.setDescriptionShort(Ferramentas.toRSCase(produto.getDescricao()));
                    produtoInclusaoVtex.setReleaseDate(
                            Ferramentas.dataFormatada(Date.from(Instant.now()),"yyyy-MM-dd HH:mm:ss")
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
                            idProdutoVtex = produtoIncluido.getId();
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
                    skuInclusaoVtex.setRefId(produtoVtexRef.getRefId());
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
                    skuProduto = produtosVtex.getSKURefId(produto.getId().toString());
                }

                if (skuProduto != null) {
                    if (skuProduto.getId() != null) {
                        log.info("SKU cadastrado no VTEX(skuId VTEX: " + skuProduto.getId() + ")");

                        var skuFileExistente = produtosVtex.getSkuFile(skuProduto.getId());
                        if (skuFileExistente == null) {
                            var imgProd = produtoWinthor.getFotoProdutoPorId(produto.getId().toString());
                            if (imgProd != null && !imgProd.isEmpty()) {
                                var skuFile = new SkuFileDTO();
                                skuFile.setId(null);
                                skuFile.setSkuId(skuProduto.getId());
                                skuFile.setArchiveId(null);
                                skuFile.setName(skuProduto.getName());
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

                        var skuEan = produtosVtex.getSkuEan(skuProduto.getId().toString());
                        if (skuEan == null) {
                            produtosVtex.postSkuEan(
                                skuProduto.getId().toString(),
                                produto.getCodigoDeBarras().toString()
                            );
                        }
                    }
                }

            }

        } catch (Exception e) {
            log.warn("[sincronizarProdutos] - Erro: " + e);
        }
    }

    private void sincronizarPrecos(TabelaPrecoDTO[] precos) throws IOException {
        for (int i = 0; i < precos.length; i++) {
            var preco = precos[i];
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

}




