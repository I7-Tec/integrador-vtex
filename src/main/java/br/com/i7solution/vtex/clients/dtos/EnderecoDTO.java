package br.com.i7solution.vtex.clients.dtos;

import java.io.Serializable;

import br.com.i7solution.vtex.tipos.TipoEndereco;
import lombok.Data;

@Data
public class EnderecoDTO implements Serializable {
    private Long id;
    private Integer numero;
    private String cep;
    private String bairro;
    private String complemento;
    private String uf;
    private String pais;
    private String cidade;
    private Long codigoIbge;
    private Boolean erro;
    private String rua;
    private TipoEndereco tipoEndereco;
}
