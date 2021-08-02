package br.com.i7solution.vtex.clients.dtos;

import java.io.Serializable;

public class EstoqueDTO implements Serializable {

	private String idProduto;
	private String idFilial;
	private Integer quantidadeDisponivel;
	private Integer quantidadeAvariada;
	private Integer quantidadeReservada;
	private Integer quantidadePendente;
	private Integer quantidadeBloqueada;
	private Integer quantidadeEmTransito;
	private Integer quantidaGondola;
	private boolean erro;

	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public String getIdFilial() {
		return idFilial;
	}

	public void setIdFilial(String idFilial) {
		this.idFilial = idFilial;
	}

	public Integer getQuantidadeDisponivel() {
		return quantidadeDisponivel;
	}

	public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
		this.quantidadeDisponivel = quantidadeDisponivel;
	}

	public Integer getQuantidadeAvariada() {
		return quantidadeAvariada;
	}

	public void setQuantidadeAvariada(Integer quantidadeAvariada) {
		this.quantidadeAvariada = quantidadeAvariada;
	}

	public Integer getQuantidadeReservada() {
		return quantidadeReservada;
	}

	public void setQuantidadeReservada(Integer quantidadeReservada) {
		this.quantidadeReservada = quantidadeReservada;
	}

	public Integer getQuantidadePendente() {
		return quantidadePendente;
	}

	public void setQuantidadePendente(Integer quantidadePendente) {
		this.quantidadePendente = quantidadePendente;
	}

	public Integer getQuantidadeBloqueada() {
		return quantidadeBloqueada;
	}

	public void setQuantidadeBloqueada(Integer quantidadeBloqueada) {
		this.quantidadeBloqueada = quantidadeBloqueada;
	}

	public Integer getQuantidadeEmTransito() {
		return quantidadeEmTransito;
	}

	public void setQuantidadeEmTransito(Integer quantidadeEmTransito) {
		this.quantidadeEmTransito = quantidadeEmTransito;
	}

	public Integer getQuantidaGondola() {
		return quantidaGondola;
	}

	public void setQuantidaGondola(Integer quantidaGondola) {
		this.quantidaGondola = quantidaGondola;
	}

	public boolean isErro() {
		return erro;
	}

}
