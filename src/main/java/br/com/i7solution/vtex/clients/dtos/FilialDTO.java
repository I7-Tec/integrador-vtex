package br.com.i7solution.vtex.clients.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class FilialDTO implements Serializable {
    private String id;
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
}
