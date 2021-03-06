package br.com.i7solution.vtex.clients.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class MarcaDTO implements Serializable {
    private String id;
    private String descricao;
    private boolean ativo;
    private String idVtex;
    private String descricaoEcommerce;
    private boolean enviaEcommerce;
}
