package br.com.i7solution.vtex.clients.dtos;

import java.io.Serializable;

public class TabelaPrecoDTO implements Serializable {

    private String idProduto;
    private Float preco;
    private Boolean erro;


    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Boolean isErro() {
        return erro;
    }

}
