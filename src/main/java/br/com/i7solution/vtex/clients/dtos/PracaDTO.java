package br.com.i7solution.vtex.clients.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class PracaDTO implements Serializable {
    private String id;
    private String descricao;
}
