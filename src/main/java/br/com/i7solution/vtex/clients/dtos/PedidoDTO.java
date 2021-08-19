package br.com.i7solution.vtex.clients.dtos;

import java.io.Serializable;
import java.util.Date;

public class PedidoDTO implements Serializable {

	private Long id;
	private String filial;
	private String cliente;
	private Double valorTotal;
	private String posicao;
	private Date dataCriacao;
	private Date dataCancelamento;
	private Date dataFaturamento;
	private Date dataBloqueio;
	private String idPedidoRca;
	private String idVendedor;
	private String idPedidoCliente;
	private Double quantidadeItens;
	private Date dataEntrega;
	private String usuario;
	private String idCobranca;
	private String idFormaDePagamento;
	private Double valorFrete;
	private Double valorOutrasDespesas;
	private String tipoFrete;
	private boolean erro;
	private ItemPedidoDTO Itens[];

	
	public String getFilial() {
		return filial;
	}

	public void setFilial(String filial) {
		this.filial = filial;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataCancelamento() {
		return dataCancelamento;
	}

	public void setDataCancelamento(Date dataCancelamento) {
		this.dataCancelamento = dataCancelamento;
	}

	public Date getDataFaturamento() {
		return dataFaturamento;
	}

	public void setDataFaturamento(Date dataFaturamento) {
		this.dataFaturamento = dataFaturamento;
	}

	public Date getDataBloqueio() {
		return dataBloqueio;
	}

	public void setDataBloqueio(Date dataBloqueio) {
		this.dataBloqueio = dataBloqueio;
	}

	public String getIdPedidoRca() {
		return idPedidoRca;
	}

	public void setIdPedidoRca(String idPedidoRca) {
		this.idPedidoRca = idPedidoRca;
	}

	public String getIdPedidoCliente() {
		return idPedidoCliente;
	}

	public void setIdPedidoCliente(String idPedidoCliente) {
		this.idPedidoCliente = idPedidoCliente;
	}

	public Double getQuantidadeItens() {
		return quantidadeItens;
	}

	public void setQuantidadeItens(Double quantidadeItens) {
		this.quantidadeItens = quantidadeItens;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
    


	public String getIdCobranca() {
		return idCobranca;
	}

	public void setIdCobranca(String idCobranca) {
		this.idCobranca = idCobranca;
	}

	public String getIdFormaDePagamento() {
		return idFormaDePagamento;
	}

	public void setIdFormaDePagamento(String idFormaDePagamento) {
		this.idFormaDePagamento = idFormaDePagamento;
	}

	public Double getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(Double valorFrete) {
		this.valorFrete = valorFrete;
	}

	public Double getValorOutrasDespesas() {
		return valorOutrasDespesas;
	}

	public void setValorOutrasDespesas(Double valorOutrasDespesas) {
		this.valorOutrasDespesas = valorOutrasDespesas;
	}

	public String getTipoFrete() {
		return tipoFrete;
	}

	public void setTipoFrete(String tipoFrete) {
		this.tipoFrete = tipoFrete;
	}

	public ItemPedidoDTO[] getItens() {
		return Itens;
	}

	public void setItens(ItemPedidoDTO itens[]) {
		Itens = itens;
	}

	public boolean isErro(boolean b) {
		return erro;
	}

	public String getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(String idVendedor) {
		this.idVendedor = idVendedor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
