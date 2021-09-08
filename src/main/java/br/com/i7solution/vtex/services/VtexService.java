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

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

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

    //@Async(value = "taskAtualizacoes")
    //@Scheduled(fixedRate = 40000, initialDelay = 10000)
    public void atualizarPrecos() {
        log.info("Iniciando método de sincornização de preços...");
        var skus = produtosVtex.getSKUs();
        for (int i = 0; i < skus.getSkus().length; i++) {
            var sku = skus.getSkus()[i];
            if (sku.getRefId() != null) {
                var preco = tabelaPrecoWinthorClient.getPrecosWinthor(sku.getRefId());
                if (preco != null && preco.length > 0 && preco[0].getPreco() > 0 && sku.getId() != null) {
                    var precoVtex = new PriceDTO();
                    precoVtex.setPrice(preco[0].getPreco().doubleValue());
                    precoVtex.setListPrice(preco[0].getPreco().doubleValue());
                    precoVtex.setSkuId(preco[0].getIdProduto());

                    precosVtex.putPrecoPorSku(sku.getId().toString(), precoVtex);
                }
            }
            log.info("Finalizando método de sincornização de preços!");
        }
    }

    @Async(value = "taskAtualizacoes")
    @Scheduled(fixedRate = 120000, initialDelay = 10000)
    public void atualizarProdutos() {
        log.info("Iniciando sincronização de produtos...");
        var existeProximo = true;
        var pagina = 1;
        while (existeProximo) {
            var produtos = produtoWinthor.getProdutos(pagina, 100);
            if (produtos != null) {
                sincronizarProdutos(produtos);
            }
            pagina++;

            existeProximo = !((produtos != null ? produtos.size() : 0) < 100);
        }
        log.info("Fim da sincronização de produtos!");
    }

    //@Async(value = "taskAtualizacoes")
    //@Scheduled(fixedRate = 30000, initialDelay = 10000)
    public void atualizacaoEstoque() {
        log.info("Iniciando método de sincornização de estoques...");
        try {
            var skus = produtosVtex.getSKUs();
            for (int i = 0; i < skus.getSkus().length; i++) {
                var sku = skus.getSkus()[i];
                if (sku.getRefId() != null) {
                    var estoques = estoqueWinthor.getEstoque(sku.getRefId());
                    if (estoques != null && estoques.length > 0 && sku.getId() != null) {
                        for (int e = 0; e < estoques.length; e++) {
                            var estoque = estoques[e];
                            var estoqueVtex = new BalanceDTO();
                            estoqueVtex.setReservedQuantity(estoque.getQuantidadeReservada().longValue());
                            estoqueVtex.setTotalQuantity(estoque.getQuantidadeTotal().longValue());
                            estoqueVtex.setWarehouseId(estoque.getIdFilial());
                            var s = inventoryVtex.putEstoquePorSku(sku.getId().toString(), estoqueVtex);
                            log.info(s);
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error("Estoque atualização(Erro002): " + e);
        }
        log.info("Estoque atualização: Finalizado!");
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
        log.info("Quantidade de Produtos a sincronizar:" + "  " + produtos.size());
        for (int i = 0; i < produtos.size(); i++) {
            var produto = produtos.get(i);
            var produtoVtexRef = produtosVtex.getProdutoRefId(produtos.get(i).getId());


            if (produto.getMarca() != null &&
                    produto.getSecao() != null &&
                    produto.getMarca().getIdEcommerce() != null &&
                    produto.getSecao().getIdEcommerce() != null
            ) {

                if (produtoVtexRef == null) {
                    log.info("Incluindo Produto ...");
                    var produtoInclusaoVtex = new ProductInclusaoDTO();
                    produtoInclusaoVtex.setBrandId(Ferramentas.stringToLong(produto.getMarca().getIdEcommerce()));
                    produtoInclusaoVtex.setCategoryId(Ferramentas.stringToLong(produto.getSecao().getIdEcommerce()));
                    produtoInclusaoVtex.setDescription((produto.getDescricao()));
                    produtoInclusaoVtex.setLinkId(Ferramentas.removerAcentos(produto.getDescricao().toLowerCase()));
                    produtoInclusaoVtex.setName(produto.getDescricao());
                    produtoInclusaoVtex.setRefId(produto.getId());
                    produtoInclusaoVtex.setShowWithoutStock(false);

                    produtosVtex.postProduto(produtoInclusaoVtex);

                    log.info("Fim da Inclusão !");
                } else {

                    produtosVtex.getProdutoRefId(produtoVtexRef.getRefId());
                    log.info("Produto Já Incluido!");
                }
            }
            var skuRef = produtosVtex.getSKURefId(produtos.get(i).getId());
            var skuVtex = produtosVtex.getSKU();
            if (skuRef == null) {
                log.info("...");
                atualizarSKU(skuVtex);
            } else {
                produtosVtex.getSKURefId(skuRef.getRefId());
                log.info("Sku já incluido!");
            }


        }
    }


    private void atualizarSKU(SkuDTO sku) {
        log.info("Iniciando Atualização de SKU's ...");
        var skuInit = produtosVtex.getSKU().getRefId();
        var skuR = produtosVtex.getSKURefId(skuInit);
        var produtoV = produtosVtex.getSKU();

        if (skuR == null) {
            log.info("Incluindo SKU...");
            var skuInc = new SkuInclusaoDTO();
            skuInc.setProductId(produtoV.getProductId());
            skuInc.setName(produtoV.getName());
            skuInc.setRefId(produtoV.getRefId());


            //sku.getUnitMultiplier();

            var dimension = new SkuDimensionDTO();
            skuInc.setHeight(dimension.getHeight());
            skuInc.setCubicWeight(dimension.getCubicweight());
            skuInc.setWidth(dimension.getWidth());
            skuInc.setWeightKg(dimension.getWeight());
            skuInc.setLength(dimension.getLength());



            produtosVtex.postSku(skuInc);
        } else {
            var skuExiste = produtosVtex.getSKURefId(produtoV.getRefId());
            log.info("Sku já existe" + "  " + skuExiste);

        }


    }

}




