package br.com.i7solution.vtex.services;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import br.com.i7solution.vtex.apivtex.*;
import br.com.i7solution.vtex.apivtex.dtos.*;
import br.com.i7solution.vtex.clients.*;
import br.com.i7solution.vtex.tools.Ferramentas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import br.com.i7solution.vtex.clients.dtos.ClienteDTO;
import br.com.i7solution.vtex.clients.dtos.EnderecoDTO;
import br.com.i7solution.vtex.clients.dtos.ItemPedidoDTO;
import br.com.i7solution.vtex.clients.dtos.PedidoDTO;
import lombok.extern.log4j.Log4j2;

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
    private BrandClient marcaWinthor;

    @Async(value = "taskAtualizacoes")
    @Scheduled(fixedRate = 1800000, initialDelay = 10000) // de 30 em 30 mins
    public void atualizarPrecos() throws Exception {
        log.info("Iniciando método de sincornização de preços");
        var skus = produtosVtex.getSKUs();
        for (int i = 0; i < skus.getSkus().length; i++) {
            var sku = skus.getSkus()[i];
            if (sku.getRefid() != null) {
                var preco = tabelaPrecoWinthorClient.getPrecosWinthor(sku.getRefid());
                if (preco != null && preco.length > 0 && preco[0].getPreco() > 0 && sku.getSkuId() != null) {
                    var precoVtex = new SKUPriceDTO();
                    precoVtex.setPrice(preco[0].getPreco().doubleValue());
                    precoVtex.setListPrice(preco[0].getPreco().doubleValue());
                    //precoVtex.setSalesChannel(1L);

                    precosVtex.putPrecoPorSku(sku.getSkuId(), precoVtex);
                }
            }
            log.info("Finalizando método de sincornização de preços");
        }
    }

    @Async(value = "taskAtualizacoes")
    @Scheduled(fixedRate = 30000, initialDelay = 10000) //de 30 em 30 mins
    public void atualizarProdutos() {
        log.info("Iniciando sincronização de produtos...");
        var produtos = produtoWinthor.getProdutos();
        for (int i = 0; i < produtos.size(); i++) {
            var produto = produtos.get(i);
            if (produto.getMarca().getIdEcommerce() != null && produto.getSecao().getIdEcommerce() != null) {
                var produtoVtex = new ProductDTO();
                produtoVtex.setBrandId(Ferramentas.stringToLong(produto.getMarca().getIdEcommerce()));
                produtoVtex.setCategoryId(Ferramentas.stringToLong(produto.getSecao().getIdEcommerce()));
                produtoVtex.setDescription((produto.getDescricao()));
                produtoVtex.setLinkId(Ferramentas.removerAcentos(produto.getDescricao().toLowerCase()));
                produtoVtex.setName(produto.getDescricao());
                produtoVtex.setRefId(produto.getId());

                var produtoRetorno = produtosVtex.postProduto(produtoVtex);
                var sku = new SkuDTO();
                sku.setProductId(produtoRetorno.getId().toString());
                sku.setNameComplete(produto.getDescricao());
                sku.setEan(produto.getCodigoDeBarras().toString());
                sku.setRefid(produto.getId());
                sku.getUnitMultiplier();

                var dimension = new SkuDimensionDTO();
                dimension.setHeight(produto.getAltura().doubleValue());
                dimension.setWidth(produto.getLargura().doubleValue());
                dimension.setLength(produto.getComprimento().doubleValue());
                dimension.setWeight(produto.getPesoLiquido().doubleValue());

                sku.setDimension(dimension);

                produtosVtex.postSku(sku);
            }
        }
    }

    @Async(value = "taskAtualizacoes")
    @Scheduled(fixedRate = 30000, initialDelay = 10000)//Executa a cada 20mins e inicia após 10 mins
    public void atualizacaoEstoque() {
        log.info("Iniciando método de sincornização de estoques");
        try {
            var skus = produtosVtex.getSKUs();
            for (int i = 0; i < skus.getSkus().length; i++) {
                var sku = skus.getSkus()[i];
                if (sku.getRefid() != null) {
                    var estoques = estoqueWinthor.getEstoque(sku.getRefid());
                    if (estoques != null && estoques.length > 0 && sku.getSkuId() != null) {
                        for (int e = 0; e < estoques.length; e++) {
                            var estoque = estoques[e];
                            var estoqueVtex = new BalanceDTO();
                            estoqueVtex.setReservedQuantity(estoque.getQuantidadeReservada().longValue());
                            estoqueVtex.setTotalQuantity(estoque.getQuantidadeTotal().longValue());
                            estoqueVtex.setWarehouseId(estoque.getIdFilial());
                            var s = inventoryVtex.putEstoquePorSku(sku.getSkuId(), estoque.getIdFilial(), estoqueVtex);
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
            clienteWinthor.setNome(clienteVtex.getFirstName() + clienteVtex.getLastName());
            clienteWinthor.setTelefoneFixo(clienteVtex.getPhone());

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
            var pagtos = pedV.getPayments();
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
            }

            pedWinthor.isErro();

            pontoErro = "Lendo itens...";
            var itensVtex = pedV.getItems();
            var listItens = new ItemPedidoDTO[itensVtex.length];
            for (var i = 0; i < itensVtex.length; i++) {
                var prodW = produtoWinthor.getProdutoPorId(itensVtex[i].getId());

                var item = new ItemPedidoDTO();
                item.setIdProduto(prodW.getId());
                item.setCodigoDeBarras(prodW.getCodigoDeBarras().longValue());
                //item.setPosicao("P");
                //item.setFilialRetira(itensVtex[i]);
                item.setPreco(itensVtex[i].getSellingPrice());
                item.setValorDesconto(0.0);
                item.setQuantidade(itensVtex[i].getQuantity().doubleValue());

                listItens[i] = item;
            }

            pedWinthor.setItens(listItens);
            pedWinthor.setQuantidadeItens(Double.valueOf(listItens.length));

            pedidoWinthor.postPedido(pedWinthor);

        } catch (Exception e) {
            log.error("ped_vtex_winthor: " + pontoErro + " -> msg original: " + e);
            throw new Exception(e.getMessage());
        }
    }


    @Async
    @Scheduled(fixedRate = 3600000, initialDelay = 60000) // inicia 60 em 60 minutos
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


}

