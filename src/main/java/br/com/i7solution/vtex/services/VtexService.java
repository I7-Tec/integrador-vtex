package br.com.i7solution.vtex.services;

import br.com.i7solution.vtex.apivtex.*;
import br.com.i7solution.vtex.apivtex.dtos.*;
import br.com.i7solution.vtex.clients.*;
import br.com.i7solution.vtex.clients.dtos.*;
import br.com.i7solution.vtex.tools.Ferramentas;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

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
    //@Scheduled(fixedRate = 1800000, initialDelay = 10000)
    public void atualizarPrecos() {
        log.info("Iniciando sincronização de preços");
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
        log.info("Fim da atualização de preços");
    }

    @Async(value = "taskAtualizacoes")
    //@Scheduled(fixedRate = 10000000, initialDelay = 10000)
    public void atualizarFiliais() {
        log.info("Inciando sincronização de filiais");
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
        log.info("Finalizando sincronização de filiais");
    }

    @Async(value = "taskAtualizacoes")
    @Scheduled(fixedRate = 100000, initialDelay = 10000)
    public void atualizarProdutos() {
        log.info("[atualizarProdutos] - Iniciando sincronização de produtos");
//        var existeProximo = true;
//        var pagina = 1;
//        while (existeProximo) {
//            var produtos = produtoWinthor.getProdutos(pagina, 100);
//            if (produtos != null) {
//                sincronizarProdutos(produtos);
//            }
//            pagina++;
//
//            existeProximo = !((produtos != null ? produtos.size() : 0) < 100);
//        }
        var lista = new ArrayList<String>();
        lista.add("2507");
        lista.add("51682");
        lista.add("25100");
        lista.add("25639");
        lista.add("63092");

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
    //@Scheduled(fixedRate = 1200000, initialDelay = 10000)
    public void atualizacaoEstoque() {
        log.info("Iniciando sincronização de estoques");
        var existeProximo = true;
        var pagina = 1;
        while (existeProximo) {
            var estoques = estoqueWinthor.getEstoque(pagina, 100);
            if (estoques != null) {
                sincronizarEstqoue(estoques);
            }
            pagina++;

            existeProximo = !((estoques != null ? estoques.length : 0) < 100);
        }
        log.info("Finalizando sincronização de estoques");
    }

    public void ped_vtex_winthor(OrderDTO pedVtex) throws Exception {

        var pedWinthor = new PedidoDTO();
        String pontoErro = "";

        try {
            var pedV = pedidosVtex.getPedidoPorId(pedVtex.getId().toString());

            pontoErro = "dados cabeçalho";

            var clienteVtex = new ClientProfileDataDTO();
            clienteVtex = pedV.getClientProfileData()[0];
            var clienteWinthor = new ClienteDTO();
            clienteWinthor.setCpfCnpj(clienteVtex.getDocument());
            clienteWinthor.setEmail(clienteVtex.getEmail());
            clienteWinthor.setNome(clienteVtex.getFirstName() + " " + clienteVtex.getLastName());
            clienteWinthor.setTelefoneFixo(clienteVtex.getPhone());
            clienteWinthor.setTelefoneCelular(clienteVtex.getCorporatePhone()); // observação

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
            pedWinthor.setIdPedidoCliente(pedV.getOrderId().toString());

            pontoErro = "Definindo dados de pagamento...";
            var pagtos = pedV.getPayments();//validar pagamentos
            if (pagtos.length > 0) {
                if (pagtos[0].getGroup() == "credit card") {
                    if (pagtos.length == 1) {
                        pedWinthor.setIdCobranca("WCCI");
                    } else {
                        pedWinthor.setIdCobranca("WCPI");
                    }

                    switch (pagtos.length) {
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
            }//validar pagamentos

            pedWinthor.isErro(false);

            pontoErro = "Lendo itens...";
            var itensVtex = pedV.getItems();
            var listItens = new ItemPedidoDTO[itensVtex.length];
            for (var i = 0; i < itensVtex.length; i++) {
                var prodW = produtoWinthor.getProdutoPorId(itensVtex[i].getId());

                var item = new ItemPedidoDTO();
                item.setIdProduto(prodW.getId());
                item.setCodigoDeBarras(prodW.getCodigoDeBarras());
                item.setPosicao("P");
                item.setFilialRetira(null);
                item.setPreco(itensVtex[i].getSellingPrice());
                item.setValorDesconto(0.0);
                item.setQuantidade(itensVtex[i].getQuantity());


                listItens[i] = item;
            }

            pedWinthor.setItens(listItens);
            pedWinthor.setQuantidadeItens(Long.valueOf(listItens.length));

            pedidoWinthor.postPedido(pedWinthor);

        } catch (Exception e) {
            log.error("ped_vtex_winthor: " + pontoErro + " -> msg original: " + e);
            throw new Exception(e.getMessage());
        }
        log.info("Fim da leitura dos Itens !");
    }


    //@Async
    //@Scheduled(fixedRate = 10000, initialDelay = 60000)
    public void sincronizarPedidos() throws Exception {
        var dataIni = new SimpleDateFormat("yyyy-MM-dd").format(Date.from(Instant.now().minus(7, ChronoUnit.DAYS)));
        var dataFim = new SimpleDateFormat("yyyy-MM-dd").format(Date.from(Instant.now()));

        var listOrders = pedidosVtex.getPedidosPorData(dataIni, dataFim);
        for (int i = 0; i < listOrders.size(); i++) {
            if ((listOrders.get(i).getStatus() != "canceled")
                    && (pedidoWinthor.getPedidoPorId(listOrders.get(i).getOrderId()))) {
                var pedidoVtex = pedidosVtex.getPedidoPorId(listOrders.get(i).getOrderId().toString());
                ped_vtex_winthor(pedidoVtex);
            }
        }
    }

    //@Async
    //@Scheduled(fixedRate = 20000, initialDelay = 10000)
    public void sincronizarMarcas() {
        log.info("Iniciando sincronização de Marcas...");
        try {
            var marcas = marcaClient.getMarcas();
            for (int i = 0; i < 1; i++) {
                var marca = marcas.get(i);
                if (marca.getIdEcommerce() == null) {
                    var brand = new BrandInclusaoDTO();
                    brand.setName(marca.getDescricao());
                    brand.setActive(true);
                    brand.setSiteTitle(marca.getDescricao());

                    var brandRetorno = marcaVtex.postBrand(brand);
                    if (brandRetorno != null) {
                        marca.setIdEcommerce(brandRetorno.getId().toString());
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
                if (secao.getIdEcommerce() != null) {
                    var category = new CategoryInclusaoDTO();
                    category.setName(secao.getDescricao());
                    category.setActive(true);

                    var secaoRetorno = secaoVtex.postCategory(category);
                    if (secaoRetorno != null) {
                        System.out.println(secaoRetorno.getId());
                        secao.setIdEcommerce(secaoRetorno.getId().toString());
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
                if (produto.getMarca() != null &&
                        produto.getSecao() != null &&
                        produto.getMarca().getIdEcommerce() != null &&
                        produto.getSecao().getIdEcommerce() != null
                ) {
                    var produtoVtexRef = produtosVtex.getProdutoRefId(produto.getId());
                    Long idProdutoVtex = 0L;
                    if (produtoVtexRef == null) {
                        log.info("Incluindo Produto");
                        var produtoInclusaoVtex = new ProductInclusaoDTO();
                        produtoInclusaoVtex.setBrandId(Ferramentas.stringToLong(produto.getMarca().getIdEcommerce()));
                        produtoInclusaoVtex.setCategoryId(Ferramentas.stringToLong(produto.getSecao().getIdEcommerce()));
                        produtoInclusaoVtex.setDescription(produto.getDescricao());
                        produtoInclusaoVtex.setLinkId(Ferramentas.removerAcentos(produto.getDescricao().toLowerCase(Locale.ROOT)) + " " + produto.getId());
                        produtoInclusaoVtex.setName(produto.getDescricao());
                        produtoInclusaoVtex.setRefId(produto.getId());
                        produtoInclusaoVtex.setShowWithoutStock(false);

                        var produtoIncluido = produtosVtex.postProduto(produtoInclusaoVtex);
                        if (produtoIncluido != null) {
                            idProdutoVtex = produtoIncluido.getId();
                            log.info("Produto Incluido!");
                        }

                    } else {
                        idProdutoVtex = produtoVtexRef.getId();
                    }
                    if (idProdutoVtex != null && idProdutoVtex != 0L) {
                        var skuVtexRef = produtosVtex.getSKURefId(produto.getId());
                        if (skuVtexRef == null) {

                            var sku = new SkuInclusaoDTO();
                            sku.setName(produto.getDescricao());
                            sku.setRefId(produto.getId());
                            sku.setProductId(idProdutoVtex);
                            sku.setActive(false);
                            sku.setPackagedHeight(produto.getAltura());
                            sku.setPackagedLength(produto.getComprimento());
                            sku.setPackagedWidth(produto.getLargura());
                            sku.setPackagedWeightKg(produto.getPeso() != null ? produto.getPeso() : produto.getPesoLiquido());
                            sku.setHeight(produto.getAltura());
                            sku.setLength(produto.getComprimento());
                            sku.setWidth(produto.getLargura());
                            sku.setWeightKg(produto.getPeso() != null ? produto.getPeso() : produto.getPesoLiquido());
                            sku.setHeighCubicWeightt(1.0);
                            sku.setKit(false);
                            sku.setRewardValue(0.0);
                            sku.setManufacturerCode(produto.getFornecedor().getId());
                            sku.setMeasurementUnit(produto.getUnidade());
                            sku.setUnitMultiplier(1.0);
                            sku.setKitItensSellApart(false);

                            produtosVtex.postSku(sku);
                            log.info("SKU incluido!");
                        }
                    }

                } else {
                    log.info("Produto não possui marca ou seção");
                }
            }
        } catch (Exception e) {
            log.warn("[sincronizarProdutos] - Erro: " + e);
        }
    }

    private void sincronizarPrecos(TabelaPrecoDTO[] precos) {
        for(int i = 0; i < precos.length; i++) {
            var preco = precos[i];
            log.info("Sincronizando preço do produto: " + preco.getIdProduto());
            var skuVetx = produtosVtex.getSKURefId(preco.getIdProduto());

            if(skuVetx != null) {
                var priceVtexDto = new PriceDTO();
                priceVtexDto.setBasePrice(preco.getPreco());
                if(preco.getMargemPrevista() != null) {
                    priceVtexDto.setMarkup(preco.getMargemPrevista().intValue());
                } else {
                    priceVtexDto.setMarkup(0);
                }
                var precoAtualizado = precosVtex.putPreco(skuVetx.getId(), priceVtexDto);
                if(precoAtualizado != null) log.info("Preço do produto: " + preco.getIdProduto() + " atualizado com sucesso!");
            } else {
                log.info("Não existe SKU para o produto: " + preco.getIdProduto());
            }

        }
    }

    private void sincronizarEstqoue(EstoqueDTO[] estoques) {
        for(int i = 0; i < estoques.length; i++) {
            var estoque = estoques[i];
            var skuVetx = produtosVtex.getSKURefId(estoque.getIdProduto());
            if(skuVetx != null) {
                var inventory = new InventoryDTO();
                inventory.setUnlimitedQuantity(false);
                inventory.setQuantity(estoque.getQuantidadeDisponivel());

                log.info("Atualizando estoque do SKU: " + skuVetx.getId());
                inventoryVtex.putEstoquePorSku(inventory, skuVetx.getId(), estoque.getIdFilial());
            }
        }
    }

}




