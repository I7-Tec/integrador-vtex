package br.com.i7solution.vtex.clients.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ItemPedidoDTO implements Serializable {
    private Long numpedweb;
    private Long codprod;
    private Long numseq;
    private Date data;
    private String numpedrca;
    private String numpedcli;
    private String tipointegracao;
    private String codcli;
    private Double ptabela;
    private Double qt;
    private Double pvenda;
    private Long codusur;
    private Long codauxiliar;
    private Double pesobruto;
    private String integradora;
    private String codfilialretira;
}
