package br.com.i7solution.vtex.clients.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class ImportarPedidoDTO implements Serializable {
    private Long numpedweb;
    private Long numped;
    private String posicao;
    private Boolean importado;
    private String msg;
}
