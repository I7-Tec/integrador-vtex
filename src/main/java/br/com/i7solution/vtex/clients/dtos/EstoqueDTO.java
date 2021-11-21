package br.com.i7solution.vtex.clients.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class EstoqueDTO implements Serializable {
    private ProdutoDTO produto;
    private FilialDTO filial;
    private Double quantidadeTotal;
    private Double quantidadeDisponivel;
    private Double quantidadeAvariada;
    private Double quantidadeBloqueada;
    private Double quantidadeReservada;
    private Double quantidaGondola;
    private Double quantidadeEmTransito;
    private Double quantidadePendente;
}