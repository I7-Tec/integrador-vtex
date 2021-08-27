package br.com.i7solution.vtex.clients.dtos;

import java.io.Serializable;

public class EstoqueDTO implements Serializable {

    private String idProduto;
    private String idFilial;
    private Double quantidadeDisponivel;
    private Double quantidadeAvariada;
    private Double quantidadeReservada;
    private Double quantidadePendente;
    private Double quantidadeBloqueada;
    private Double quantidadeEmTransito;
    private Double quantidaGondola;
    private Double quantidadeTotal;
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

    public Double getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(Double quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public Double getQuantidadeAvariada() {
        return quantidadeAvariada;
    }

    public void setQuantidadeAvariada(Double quantidadeAvariada) {
        this.quantidadeAvariada = quantidadeAvariada;
    }

    public Double getQuantidadeReservada() {
        return quantidadeReservada;
    }

    public void setQuantidadeReservada(Double quantidadeReservada) {
        this.quantidadeReservada = quantidadeReservada;
    }

    public Double getQuantidadePendente() {
        return quantidadePendente;
    }

    public void setQuantidadePendente(Double quantidadePendente) {
        this.quantidadePendente = quantidadePendente;
    }

    public Double getQuantidadeBloqueada() {
        return quantidadeBloqueada;
    }

    public void setQuantidadeBloqueada(Double quantidadeBloqueada) {
        this.quantidadeBloqueada = quantidadeBloqueada;
    }

    public Double getQuantidadeEmTransito() {
        return quantidadeEmTransito;
    }

    public void setQuantidadeEmTransito(Double quantidadeEmTransito) {
        this.quantidadeEmTransito = quantidadeEmTransito;
    }

    public Double getQuantidaGondola() {
        return quantidaGondola;
    }

    public void setQuantidaGondola(Double quantidaGondola) {
        this.quantidaGondola = quantidaGondola;
    }

    public Double getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(Double quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public boolean isErro() {
        return erro;
    }

    public void setErro(boolean erro) {
        this.erro = erro;
    }
}