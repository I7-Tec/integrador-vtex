package br.com.i7solution.vtex.clients.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class EmbalagemDTO implements Serializable {
    private String idProduto;
    private String idFilial;
    private Long codigoDeBarras;
    private String descricao;
    private Float altura;
    private Float largura;
    private Float comprimento;
    private Float pesoLiquido;
    private Float pesoBruto;
    private Float multiploDeEstoque;
}

