package br.com.i7solution.vtex.clients.dtos;

import lombok.Data;
import java.io.Serializable;

@Data
public class ProdutoDTO implements Serializable {
    private String id;
    private String descricao;
    private Long codigoDeBarras;
    private Double peso;
    private Double altura;
    private Double comprimento;
    private Double largura;
    private String codigoDeFabrica;
    private DepartamentoDTO departamento;
    private SecaoDTO secao;
    private MarcaDTO marca;
    private CategoriaDTO categoria;
    private String unidade;
    private FornecedorDTO fornecedor;
    private boolean ativo;
    private EmbalagemDTO[] embalagens;
    private Double pesoLiquido;
    private Double multiploVenda;
}