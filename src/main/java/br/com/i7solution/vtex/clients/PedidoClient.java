package br.com.i7solution.vtex.clients;

import org.springframework.stereotype.Service;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

import br.com.i7solution.vtex.apivtex.DadosVtex;
import br.com.i7solution.vtex.clients.dtos.PedidoDTO;

@Service
public class PedidoClient {

    public Boolean getPedidoPorId(Long id) {
        String url = DadosMicroServicos.urlPedidos + DadosMicroServicos.endPointPedidos + id + "?an=";
        HttpResponse<Boolean> response = null;
        try {
            response = Unirest.get(url).header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken",DadosVtex.appToken)
                    .asObject(Boolean.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return response.getBody();
    }

    public PedidoDTO putPedidoPorId(String id, PedidoDTO dados) {
        String url = DadosMicroServicos.urlPedidos + DadosMicroServicos.endPointPedidos + id + "?an=";
        HttpResponse<PedidoDTO> response = null;
        try {
            response = Unirest.put(url).header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken",DadosVtex.appToken)
                    .body(dados).asObject(PedidoDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return response.getBody();
    }

    public PedidoDTO postPedidoPorId(String id, PedidoDTO dados) {
        String url = DadosMicroServicos.urlPedidos + DadosMicroServicos.endPointPedidos + id + "?an=";
        HttpResponse<PedidoDTO> response = null;
        try {
            response = Unirest.post(url).header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken",DadosVtex.appToken)
                    .body(dados).asObject(PedidoDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();

        }
        return response.getBody();

    }

    public void postPedido(PedidoDTO dados) {
        String url = DadosMicroServicos.urlPedidos;
        try {
            var response = Unirest.post(url).header("Content-Type", "application/json").body(dados);

        } catch (UnirestException e) {
            e.printStackTrace();
        }

    }
}
