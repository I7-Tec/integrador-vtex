package br.com.i7solution.vtex.clients.dtos;

import lombok.Data;
import java.io.Serializable;

@Data
public class ItemPedidoDTO implements Serializable {
    private ProdutoDTO produto;
    private Long codigoDeBarras;
    private Double quantidade;
    private Double preco;
    private Double valorDesconto;
    private Long sequencial;
    private FilialDTO filialRetira;
    private String posicao;
}
