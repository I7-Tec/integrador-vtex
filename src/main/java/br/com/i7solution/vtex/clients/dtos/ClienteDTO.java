package br.com.i7solution.vtex.clients.dtos;

import java.io.Serializable;

import java.util.Date;

public class ClienteDTO implements Serializable {

    private String id;
    private String nome;
    private String cpfCnpj;
    private String email;
    private String telefoneCelular;
    private String telefoneFixo;
    private Date dataNascimento;
    private Date dataCadastro;
    private boolean erro;
    private EnderecoDTO enderecos[];

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public EnderecoDTO[] getEnderecosdto() {
        return enderecos;
    }

    public void setEnderecodto(EnderecoDTO[] enderecos) {
        this.enderecos = enderecos;
    }

    public boolean isErro() {
        return erro;
    }

}
