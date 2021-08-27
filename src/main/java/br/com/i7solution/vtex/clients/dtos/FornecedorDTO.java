package br.com.i7solution.vtex.clients.dtos;

import java.io.Serializable;

public class FornecedorDTO implements Serializable {
    private String id;
    private String nome;
    private  String cpfCnpj;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }
}

