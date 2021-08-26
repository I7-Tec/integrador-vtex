package br.com.i7solution.vtex.clients.dtos;

import java.io.Serializable;

public class ProdutoDTO implements Serializable {

    private String id;
    private String descricao;
    private Double codigoDeBarras;
    private String fornecedor;
    private Double peso;
    private Double altura;
    private Double comprimento;
    private Double largura;
    private String codigoDeFabrica;
    private String departamento;
    private String secao;
    private String categoria[];
    private String unidade;
    private Boolean ativo;
    private Boolean erro;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public void setCodigoDeBarras(Double codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getComprimento() {
        return comprimento;
    }

    public void setComprimento(Double comprimento) {
        this.comprimento = comprimento;
    }

    public Double getLargura() {
        return largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }

    public String getCodigoDeFabrica() {
        return codigoDeFabrica;
    }

    public void setCodigoDeFabrica(String codigoDeFabrica) {
        this.codigoDeFabrica = codigoDeFabrica;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getSecao() {
        return secao;
    }

    public void setSecao(String secao) {
        this.secao = secao;
    }

    public String[] getCategoria() {
        return categoria;
    }

    public void setCategoria(String[] categoria) {
        this.categoria = categoria;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Boolean isErro() {
        return erro;
    }

}