package br.com.i7solution.vtex.clients.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PedidoDTO implements Serializable {
    private String id;
    private String idPedidoErp;
    private String idPedidoVendedor;
    private String idPedidoCliente;
    private FilialDTO filial;
    private Boolean importado;
    private Double valorTotal;
    //private String posicao;
    private Date dataCriacao;
    //private Date dataCancelamento;
    //private Date dataFaturamento;
    //private Date dataBloqueio;
    private Long quantidadeItens;
    //private Date dataEntrega;
    private VendedorDTO vendedor;
    private CobrancaDTO cobranca;
    private PlanoDePagamentoDTO planoDePagamento;
    private Double valorFrete;
    private Double valorOutrasDespesas;
    private String tipoFrete;
    private ClienteDTO cliente;
    private String observacaoIntegracao;
    private String tipoIntegracao;
    private String tipoVenda;
    private Long hora;
    private Long minuto;
    private String integradora;
    private ItemPedidoDTO[] itens;
    private EnderecoDTO endereco;
    private String origemPedido;
}
