package br.com.i7solution.vtex.clients.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PedidoDTO implements Serializable {
    private String id;
    private String idPedidoEcommerce;
    private String idPedidoErp;
    private String idFilial;
    private Double valorTotal;
    private String posicao;
    private Date dataCriacao;
    private Date dataCancelamento;
    private Date dataFaturamento;
    private Date dataBloqueio;
    private String idPedidoVendedor;
    private String idPedidoCliente;
    private Long quantidadeItens;
    private Date dataEntrega;
    private String idVendedor;
    private String idCobranca;
    private String idPlanoDePagamento;
    private Double valorFrete;
    private Double valorOutrasDespesas;
    private String tipoFrete;
    private ClienteDTO cliente;
    private ItemPedidoDTO[] itens;
    private EnderecoDTO endereco;
}
