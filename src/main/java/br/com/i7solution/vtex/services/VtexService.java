package br.com.i7solution.vtex.services;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import br.com.i7solution.vtex.apivtex.dtos.*;
import br.com.i7solution.vtex.clients.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import br.com.i7solution.vtex.apivtex.CatalogClient;
import br.com.i7solution.vtex.apivtex.InventoryClient;
import br.com.i7solution.vtex.apivtex.OrderClient;
import br.com.i7solution.vtex.apivtex.PriceClient;
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
    private InventoryClient estoqueVtex;
    @Autowired
    private OrderClient pedidosVtex;


    @Async(value = "taskAtualizacoes")
    @Scheduled(fixedRate = 1800000, initialDelay = 10000) // de 30 em 30 mins
    public void atualizarPrecos() {
        var precosW = precosWinthor.getPrecosWinthor();
        if (precosW.size() > 0) {
            for (int i = 0; i <= precosW.size(); i++) {
                var precoY = new SKUPriceDTO();
                precoY.setPrice(precosW.get(i).getPreco().doubleValue());
                precoY.setItemId(precosW.get(i).getIdProduto());
                // precoY.setSalesChannel(1L);
                precosVtex.putPrecoPorSku(precosW.get(i).getIdProduto(), precoY);
            }
        }
    }

    @Async(value = "taskAtualizacoes")
    @Scheduled(fixedRate = 3600000, initialDelay = 10000) // de 60 em 60 mins
    public void atualizarProdutos() {
        var prodsW = produtoWinthor.getProdutos();
        if (prodsW.size() > 0) {
            for (int i = 0; i <= prodsW.size(); i++) {
                var prodY = new SkuDTO();
                //var categ = new CategoryDTO()[];

                prodY.setId(prodsW.get(i).getId());// .setId(Ferramentas.stringToLong(prodsW.get(i).getId()));
                prodY.setNameComplete(prodsW.get(i).getDescricao());// setName(prodsW.get(i).getDescricao());
                prodY.setEan(prodsW.get(i).getCodigoDeBarras().toString());
                prodY.setDetailUrl("");
                prodY.setManufacturerCode(prodsW.get(i).getFornecedor()); //valiar campo no microserviço
                prodY.setIsTransported(false);
                prodY.setUnitMultiplier(null);
                //prodY.setUnitMultiplier(prodsW.get(i).get);
                prodY.setModalType(null);
                prodY.setIsKit(false);
                prodY.setIsActive(true);
                prodY.setIsActive(null);
                prodY.setEasurementUnit("M3");
                prodY.setIsInventoried(null);


                var dimensoes = new SkuDimensionDTO();
                dimensoes.setHeight(prodsW.get(i).getAltura());
                dimensoes.setLength(prodsW.get(i).getComprimento());
                dimensoes.setWidth(prodsW.get(i).getLargura());
                dimensoes.setWeight(prodsW.get(i).getPeso());
                prodY.setDimension(dimensoes);

                var dimensoesReais = new RealDimensionDTO();
                dimensoesReais.setRealHeight(prodsW.get(i).getAltura());
                dimensoesReais.setRealLength(prodsW.get(i).getComprimento());
                dimensoesReais.setRealWidth(prodsW.get(i).getLargura());
                dimensoesReais.setRealWeight(prodsW.get(i).getPeso());
                prodY.setRealDimension(dimensoesReais);

                produtosVtex.postSku(prodY);
            }
        }
    }

    @Async(value = "taskAtualizacoes")
    @Scheduled(fixedRate = 3600000, initialDelay = 10000) // Executa a cada 60mins e inicia após 10 mins
    public void atualizacaoEstoque() {
        log.info("Estoque atualização: Iniciando...");
        try {
            var listaEstoque = estoqueWinthor.getEstoque();
            if (listaEstoque != null) {
                if (listaEstoque.size() > 0) {
                    for (int i = 0; i < listaEstoque.size(); i++) {
                        if (listaEstoque.get(i).getIdProduto() != null) {
                            try {
                                var itemSku = estoqueVtex.getEstoquePorSku(listaEstoque.get(i).getIdProduto());
                                var item = itemSku.getBalance()[0];

                                item.setReservedQuantity(listaEstoque.get(i).getQuantidadeReservada());
                                item.setTotalQuantity(listaEstoque.get(i).getQuantidadeDisponivel());
                                estoqueVtex.putEstoquePorSku(listaEstoque.get(i).getIdProduto(), "1", item);

                                log.info("Estoque atualização - SKU " + listaEstoque.get(i).getIdProduto()
                                        + " atualizado por quantidade: " + listaEstoque.get(i).getQuantidadeDisponivel());
                            } catch (Exception e) {
                                log.error("Estoque atualização(Erro001): Produto " + listaEstoque.get(i).getIdProduto()
                                        + " msg original: " + e);
                            }
                        } else {
                            log.warn("Estoque atualização: O produto(sku) " + listaEstoque.get(i).getIdProduto()
                                    + " não possui um Vtex_id válido.");
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
            pontoErro = "dados cabeçalho";

            Date dtInclusao = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(pedVtex.getCreationDate() + " UTC");
            String dataString = new SimpleDateFormat("dd/MM/yyyy").format(dtInclusao);
            Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataString);

            var clienteVtex = new ClientProfileDataDTO();
            clienteVtex = pedVtex.getClientProfileData()[0];
            var clienteWinthor = new ClienteDTO();

            clienteWinthor.setCpfCnpj(clienteVtex.getDocument());
            clienteWinthor.setEmail(clienteVtex.getEmail());
            clienteWinthor.setNome(clienteVtex.getFirstName());
            clienteWinthor.setTelefoneFixo(clienteVtex.getPhone());
            clienteWinthor.setId(clienteVtex.getId());
            clienteWinthor.setDataCadastro(null);
            clienteWinthor.setDataNascimento(null);


            var enderecoVtex = new AdressDTO();
            var enderecoWinthor = new EnderecoDTO();

            enderecoWinthor.setBairro(enderecoVtex.getNeighborhood());
            enderecoWinthor.setCep(enderecoVtex.getPostalCode());
            enderecoWinthor.setComplemento(enderecoVtex.getComplement());
            enderecoWinthor.setMunicipio(enderecoVtex.getCity());
            enderecoWinthor.setUf(enderecoVtex.getState());
            enderecoWinthor.setPais(enderecoVtex.getCountry());
            enderecoWinthor.setNumero(enderecoVtex.getNumber());

            var listEnd = new EnderecoDTO[1];
            listEnd[0] = enderecoWinthor;

            clienteWinthor.setEnderecodto(listEnd);

            pedWinthor.setId(pedVtex.getId());
            pedWinthor.setCliente(clienteWinthor.toString());
            pedWinthor.setValorTotal(pedVtex.getValue());
            pedWinthor.setId(pedVtex.getOrderId());
            pedWinthor.setIdPedidoCliente(pedVtex.getOrderId().toString());
            pedWinthor.setDataCriacao(pedVtex.getCreationDate());
            pedWinthor.setQuantidadeItens(pedVtex.getQuantity());
            pedWinthor.setFilial("1");
            pedWinthor.setIdVendedor("10");
            pedWinthor.setDataFaturamento(null);
            pedWinthor.setDataCancelamento(null);
            pedWinthor.setDataEntrega(null);
            pedWinthor.setDataBloqueio(null);


            pontoErro = "Definindo dados de pagamento...";
            var pagtos = pedVtex.getPayments();
            if (pagtos.length > 0) {
                if (pagtos[0].getGroup() == "credit card") {
                    if (pagtos.length == 1) {
                        pedWinthor.setIdCobranca("WCCI");
                    } else {
                        pedWinthor.setIdCobranca("WCPI");
                    }

                    switch (pagtos.length) {
                        case 1:
                            pedWinthor.setIdFormaDePagamento("24");
                        case 2:
                            pedWinthor.setIdFormaDePagamento("25");
                        case 3:
                            pedWinthor.setIdFormaDePagamento("26");
                        case 4:
                            pedWinthor.setIdFormaDePagamento("27");
                        case 5:
                            pedWinthor.setIdFormaDePagamento("28");
                        case 6:
                            pedWinthor.setIdFormaDePagamento("29");
                        case 7:
                            pedWinthor.setIdFormaDePagamento("30");
                        case 8:
                            pedWinthor.setIdFormaDePagamento("31");
                        case 9:
                            pedWinthor.setIdFormaDePagamento("32");
                        case 10:
                            pedWinthor.setIdFormaDePagamento("33");
                        case 11:
                            pedWinthor.setIdFormaDePagamento("34");
                        case 12:
                            pedWinthor.setIdFormaDePagamento("35");
                        default:
                            pedWinthor.setIdFormaDePagamento("23");
                    }
                } else {
                    pedWinthor.setIdCobranca("WBI");
                    pedWinthor.setIdFormaDePagamento("39");
                }
            }

            pedWinthor.isErro(false);

            pontoErro = "Lendo itens...";
            var itensVtex = pedVtex.getItems();
            var listItens = new ItemPedidoDTO[itensVtex.length];
            for (var i = 0; i < itensVtex.length; i++) {
                var prodW = produtoWinthor.getProdutoPorId(itensVtex[i].getProductId());

                var item = new ItemPedidoDTO();
                item.setIdProduto(prodW.getId());
                item.setCodigoDeBarras(prodW.getCodigoDeBarras().longValue());
                item.setPosicao("P");
                item.setPreco(itensVtex[i].getSellingPrice());
                item.setValorDesconto(0.0);
                item.setQuantidade(itensVtex[i].getQuantity());
                //item.setSequencial(itensVtex[i].getUniqueId());
                listItens[i] = item;
            }

            pedWinthor.setItens(listItens);
            pedWinthor.setQuantidadeItens((double) listItens.length);

            pedidoWinthor.postPedido(pedWinthor);

        } catch (Exception e) {
            log.error("ped_vtex_winthor: " + pontoErro + " -> msg original: " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Async
    @Scheduled(fixedRate = 3600000, initialDelay = 60000) // inicia 60 em 60 minutos
    public void sincronizarPedidos() throws Exception {
        var dataIni = new SimpleDateFormat ("yyyy-MM-dd").format(Date.from(Instant.now().minus(7, ChronoUnit.DAYS)));
        var dataFim = new SimpleDateFormat ("yyyy-MM-dd").format(Date.from(Instant.now()));

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
