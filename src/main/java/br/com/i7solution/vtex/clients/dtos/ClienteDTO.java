package br.com.i7solution.vtex.clients.dtos;

import lombok.Data;

import java.io.Serializable;

import java.util.Date;

@Data
public class ClienteDTO implements Serializable {
    private String id;
    private String nome;
    private String cpfCnpj;
    private String email;
    private String telefoneCelular;
    private String telefoneFixo;
    private Date dataNascimento;
    private Date dataCadastro;
    private PracaDTO praca;
    private EnderecoDTO[] enderecos;
}
