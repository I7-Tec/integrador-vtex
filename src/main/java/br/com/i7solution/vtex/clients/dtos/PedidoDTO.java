package br.com.i7solution.vtex.clients.dtos;

import java.io.Serializable;
import java.util.Date;

public class PedidoDTO implements Serializable {

	private String id;
	private String filial;
	private String cliente;
	private Double valorTotal;
	private String posicao;
	private Date dataCriacao;
	private Date dataCancelamento;
	private Date dataFaturamento;
	private Date dataBloqueio;
	private String idPedidoRca;
	private String idPedidoCliente;
	private Integer quantidadeItens;
	private Date dataEntrega;
	private String usuario;
	private Double cobranca;
	private String formaDePagamento;
	private Double valorFrete;
	private Double valorOutrasDespesas;
	private String tipoFrete;
	private Boolean erro;
	private ItemPedidoDTO Itens[];

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public Integer getQuantidadeItens() {
		return quantidadeItens;
	}

	public void setQuantidadeItens(Integer quantidadeItens) {
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

	public Double getCobranca() {
		return cobranca;
	}

	public void setCobranca(Double cobranca) {
		this.cobranca = cobranca;
	}

	public String getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
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

	public Boolean isErro() {
		return erro;
	}

}
