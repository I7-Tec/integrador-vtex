package br.com.i7solution.vtex.clients.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class TabelaPrecoDTO implements Serializable {
    private String idProduto;
    private Double preco;
    private Double margemPrevista;

    @Override
    public String toString() {
        return "TabelaPrecoDTO{" +
                "    \"idProduto\": \"" + idProduto + "\",\n" +
                "    \"preco\": " + preco + ",\n" +
                "    \"margemPrevista\": " + margemPrevista + "\n" +
                '}';
    }
}
