package br.com.i7solution.vtex.clients.dtos;

import java.io.Serializable;
import java.util.Date;

public class PedidoDTO implements Serializable {

    private String id;
    private String idPedidoEcommerce;
    private String idPedidoErp;
    private String idFilial;
    private Double valorTotal;
    private String posicao;
    private Date dataCriacao;
    private Date dataCancelamento;
    private Date dataFaturamento;
    private Date dataBloqueio;
    private String idPedidoVendedor;
    private String idPedidoCliente;
    private Double quantidadeItens;
    private Date dataEntrega;
    private String idVendedor;
    private String idCobranca;
    private String idPlanoDePagamento;
    private Double valorFrete;
    private Double valorOutrasDespesas;
    private String tipoFrete;
    private ClienteDTO cliente;
    private ItemPedidoDTO itens[];
    private EnderecoDTO endereco;
    private boolean erro;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdPedidoEcommerce() {
        return idPedidoEcommerce;
    }

    public void setIdPedidoEcommerce(String idPedidoEcommerce) {
        this.idPedidoEcommerce = idPedidoEcommerce;
    }

    public String getIdPedidoErp() {
        return idPedidoErp;
    }

    public void setIdPedidoErp(String idPedidoErp) {
        this.idPedidoErp = idPedidoErp;
    }

    public String getIdFilial() {
        return idFilial;
    }

    public void setIdFilial(String idFilial) {
        this.idFilial = idFilial;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataCancelamento() {
        return dataCancelamento;
    }

    public void setDataCancelamento(Date dataCancelamento) {
        this.dataCancelamento = dataCancelamento;
    }

    public Date getDataFaturamento() {
        return dataFaturamento;
    }

    public void setDataFaturamento(Date dataFaturamento) {
        this.dataFaturamento = dataFaturamento;
    }

    public Date getDataBloqueio() {
        return dataBloqueio;
    }

    public void setDataBloqueio(Date dataBloqueio) {
        this.dataBloqueio = dataBloqueio;
    }

    public String getIdPedidoVendedor() {
        return idPedidoVendedor;
    }

    public void setIdPedidoVendedor(String idPedidoVendedor) {
        this.idPedidoVendedor = idPedidoVendedor;
    }

    public String getIdPedidoCliente() {
        return idPedidoCliente;
    }

    public void setIdPedidoCliente(String idPedidoCliente) {
        this.idPedidoCliente = idPedidoCliente;
    }

    public Double getQuantidadeItens() {
        return quantidadeItens;
    }

    public void setQuantidadeItens(Double quantidadeItens) {
        this.quantidadeItens = quantidadeItens;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getIdCobranca() {
        return idCobranca;
    }

    public void setIdCobranca(String idCobranca) {
        this.idCobranca = idCobranca;
    }

    public String getIdPlanoDePagamento() {
        return idPlanoDePagamento;
    }

    public void setIdPlanoDePagamento(String idPlanoDePagamento) {
        this.idPlanoDePagamento = idPlanoDePagamento;
    }

    public Double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(Double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public Double getValorOutrasDespesas() {
        return valorOutrasDespesas;
    }

    public void setValorOutrasDespesas(Double valorOutrasDespesas) {
        this.valorOutrasDespesas = valorOutrasDespesas;
    }

    public String getTipoFrete() {
        return tipoFrete;
    }

    public void setTipoFrete(String tipoFrete) {
        this.tipoFrete = tipoFrete;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public ItemPedidoDTO[] getItens() {
        return itens;
    }

    public void setItens(ItemPedidoDTO[] itens) {
        this.itens = itens;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public boolean getErro (boolean erro) {
        return erro ;
    }

    public boolean isErro(boolean erro) {
        return erro ;
    }
}
