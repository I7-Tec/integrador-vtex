package br.com.i7solution.vtex.clients;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

import br.com.i7solution.vtex.apivtex.DadosVtex;
import br.com.i7solution.vtex.clients.dtos.ItemPedidoDTO;

public class ItemPedidoClient {

    public ItemPedidoDTO getItemPedidoPorId(String idProduto) {
        String url = DadosMicroServicos.urlCadastros + DadosMicroServicos.endPointItemPedido + idProduto + "?an=";
        HttpResponse<ItemPedidoDTO> response = null;
        try {
            response = Unirest.get(url).header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken",DadosVtex.appToken)
                    .asObject(ItemPedidoDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return response.getBody();
    }

    public ItemPedidoDTO putItemPedidoPorId(String idProduto, ItemPedidoDTO dados) {
        String url = DadosMicroServicos.urlCadastros + DadosMicroServicos.endPointItemPedido + idProduto + "?an=";
        HttpResponse<ItemPedidoDTO> response = null;
        try {
            response = Unirest.put(url).header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken",DadosVtex.appToken)
                    .body(dados).asObject(ItemPedidoDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return response.getBody();
    }

    public ItemPedidoDTO postItemPedidoPorId(String idProduto, ItemPedidoDTO dados) {
        String url = DadosMicroServicos.urlCadastros + DadosMicroServicos.endPointItemPedido + idProduto + "?an=";
        HttpResponse<ItemPedidoDTO> response = null;
        try {
            response = Unirest.post(url).header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken",DadosVtex.appToken)
                    .body(dados).asObject(ItemPedidoDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return response.getBody();
    }

}
