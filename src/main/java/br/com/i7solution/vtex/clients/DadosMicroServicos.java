package br.com.i7solution.vtex.clients;

public class DadosMicroServicos {
    static private String baseUrl = "http://srv62463.oracledba.com.br:5006/api";

    static public String endPointProdutos = baseUrl + "/comet/produtos";
    static public String endPointFotoProduto = baseUrl + "/comet/produtos/fotos";
    static public String endPointSecoes = baseUrl + "/comet/secoes";
    static public String endPointMarcas = baseUrl + "/comet/marcas";
    static public String endPointClientes = baseUrl + "/comet/clientes";
    static public String endPointEnderecos = baseUrl + "/comet/enderecos";
    static public String endPointFiliais = baseUrl + "/comet/filiais";

    static public String endPointEstoques = baseUrl + "/andromeda/estoques";

    static public String endPointPrecos = baseUrl + "/orion/precos";
    static public String endPointPedidos = baseUrl + "/orion/pedidos";

    static public String idProdutoI7 = "aeb894da-8125-43d4-b6b2-2597062f985d";
}

