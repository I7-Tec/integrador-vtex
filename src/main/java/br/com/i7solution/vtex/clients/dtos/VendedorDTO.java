package br.com.i7solution.vtex.clients.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class VendedorDTO implements Serializable {
    private String id;
    private String nome;
}
