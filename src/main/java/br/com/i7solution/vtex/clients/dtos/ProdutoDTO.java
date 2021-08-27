package br.com.i7solution.vtex.clients.dtos;

import java.io.Serializable;

public class ProdutoDTO implements Serializable {
    private String id;
    private String descricao;
    private Long codigoDeBarras;
    private Float peso;
    private Float altura;
    private Float comprimento;
    private Float largura;
    private String codigoDeFabrica;
    private DepartamentoDTO departamento;
    private SecaoDTO secao;
    private MarcaDTO marca;
    private String categoria;
    private String unidade;
    private FornecedorDTO fornecedor;
    private boolean ativo;
    private EmbalagemDTO[] embalagens;
    private Float pesoLiquido;

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

    public Long getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public void setCodigoDeBarras(Long codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public Float getComprimento() {
        return comprimento;
    }

    public void setComprimento(Float comprimento) {
        this.comprimento = comprimento;
    }

    public Float getLargura() {
        return largura;
    }

    public void setLargura(Float largura) {
        this.largura = largura;
    }

    public String getCodigoDeFabrica() {
        return codigoDeFabrica;
    }

    public void setCodigoDeFabrica(String codigoDeFabrica) {
        this.codigoDeFabrica = codigoDeFabrica;
    }

    public DepartamentoDTO getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoDTO departamento) {
        this.departamento = departamento;
    }

    public SecaoDTO getSecao() {
        return secao;
    }

    public void setSecao(SecaoDTO secao) {
        this.secao = secao;
    }

    public MarcaDTO getMarca() {
        return marca;
    }

    public void setMarca(MarcaDTO marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public FornecedorDTO getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(FornecedorDTO fornecedor) {
        this.fornecedor = fornecedor;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public EmbalagemDTO[] getEmbalagens() {
        return embalagens;
    }

    public void setEmbalagens(EmbalagemDTO[] embalagens) {
        this.embalagens = embalagens;
    }

    public Float getPesoLiquido() {
        return pesoLiquido;
    }

    public void setPesoLiquido(Float pesoLiquido) {
        this.pesoLiquido = pesoLiquido;
    }
}