package br.com.i7solution.vtex.clients.dtos;

import java.io.Serializable;

public class ItemPedidoDTO implements Serializable {

	private String idProduto;
	private Long codigoDeBarras;
	private Double preco;
	private Double valorDesconto;
	private String filialRetira;
	private String posicao;
	private boolean erro;

	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public Long getCodigoDeBarras() {
		return codigoDeBarras;
	}

	public void setCodigoDeBarras(Long codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Double getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(Double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public String getFilialRetira() {
		return filialRetira;
	}

	public void setFilialRetira(String filialRetira) {
		this.filialRetira = filialRetira;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public Integer getSequencial() {
		return sequencial;
	}

	public void setSequencial(Integer sequencial) {
		this.sequencial = sequencial;
	}

	public boolean isErro() {
		return erro;
	}

	private Integer sequencial;
}
