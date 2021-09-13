package br.com.i7solution.vtex.clients.dtos;

import java.io.Serializable;

public class TabelaPrecoDTO implements Serializable {

    private String idProduto;
    private Double preco;
    private Double margemPrevista;

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getMargemPrevista() {
        return margemPrevista;
    }

    public void setMargemPrevista(Double margemPrevista) {
        this.margemPrevista = margemPrevista;
    }
}
