package br.com.i7solution.vtex.clients.dtos;

import java.io.Serializable;

public class TabelaPrecoDTO implements Serializable {

	private String idProduto;
	private String idFilial;
	private Double precoVenda;
	private Boolean erro;

	public String getIdFilial() {
		return idFilial;
	}

	public void setIdFilial(String idFilial) {
		this.idFilial = idFilial;
	}

	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Boolean isErro() {
		return erro;
	}

}
