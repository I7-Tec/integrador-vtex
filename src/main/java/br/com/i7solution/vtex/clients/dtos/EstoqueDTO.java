package br.com.i7solution.vtex.clients.dtos;

import java.io.Serializable;

public class EstoqueDTO implements Serializable {

	private String idProduto;
	private String idFilial;
	private Long quantidadeDisponivel;
	private Long quantidadeAvariada;
	private Long quantidadeReservada;
	private Long quantidadePendente;
	private Long quantidadeBloqueada;
	private Long quantidadeEmTransito;
	private Long quantidaGondola;
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

	public Long getQuantidadeDisponivel() {
		return quantidadeDisponivel;
	}

	public void setQuantidadeDisponivel(Long quantidadeDisponivel) {
		this.quantidadeDisponivel = quantidadeDisponivel;
	}

	public Long getQuantidadeAvariada() {
		return quantidadeAvariada;
	}

	public void setQuantidadeAvariada(Long quantidadeAvariada) {
		this.quantidadeAvariada = quantidadeAvariada;
	}

	public Long getQuantidadeReservada() {
		return quantidadeReservada;
	}

	public void setQuantidadeReservada(Long quantidadeReservada) {
		this.quantidadeReservada = quantidadeReservada;
	}

	public Long getQuantidadePendente() {
		return quantidadePendente;
	}

	public void setQuantidadePendente(Long quantidadePendente) {
		this.quantidadePendente = quantidadePendente;
	}

	public Long getQuantidadeBloqueada() {
		return quantidadeBloqueada;
	}

	public void setQuantidadeBloqueada(Long quantidadeBloqueada) {
		this.quantidadeBloqueada = quantidadeBloqueada;
	}

	public Long getQuantidadeEmTransito() {
		return quantidadeEmTransito;
	}

	public void setQuantidadeEmTransito(Long quantidadeEmTransito) {
		this.quantidadeEmTransito = quantidadeEmTransito;
	}

	public Long getQuantidaGondola() {
		return quantidaGondola;
	}

	public void setQuantidaGondola(Long quantidaGondola) {
		this.quantidaGondola = quantidaGondola;
	}

	public boolean isErro() {
		return erro;
	}

}
