package br.com.i7solution.vtex.clients;

import br.com.i7solution.vtex.config.PropertiesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

import br.com.i7solution.vtex.apivtex.DadosVtex;
import br.com.i7solution.vtex.clients.dtos.PedidoDTO;

import java.io.IOException;

@Service
public class PedidoClient {

    @Autowired
    private PropertiesConfig properties;

    public Boolean getPedidoPorId(Long id) throws IOException {
        var props = properties.getProperties();
        String url = DadosMicroServicos.endPointPedidos + id + "?an=";
        HttpResponse<Boolean> response = null;
        try {
            response = Unirest.get(url)
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + props.getProperty("properties.token"))
                    .queryString("idProdutoI7", DadosMicroServicos.idProdutoI7)
                    .queryString("idClienteI7", props.getProperty("properties.idcliente"))
                    .asObject(Boolean.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return response.getBody();
    }

    public PedidoDTO putPedidoPorId(String id, PedidoDTO dados) throws IOException {
        var props = properties.getProperties();
        String url = DadosMicroServicos.endPointPedidos + id + "?an=";
        HttpResponse<PedidoDTO> response = null;
        try {
            response = Unirest.put(url)
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + props.getProperty("properties.token"))
                    .queryString("idProdutoI7", DadosMicroServicos.idProdutoI7)
                    .queryString("idClienteI7", props.getProperty("properties.idcliente"))
                    .body(dados).asObject(PedidoDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return response.getBody();
    }

    public PedidoDTO postPedidoPorId(String id, PedidoDTO dados) throws IOException {
        var props = properties.getProperties();
        String url = DadosMicroServicos.endPointPedidos + id + "?an=";
        HttpResponse<PedidoDTO> response = null;
        try {
            response = Unirest.post(url)
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + props.getProperty("properties.token"))
                    .queryString("idProdutoI7", DadosMicroServicos.idProdutoI7)
                    .queryString("idClienteI7", props.getProperty("properties.idcliente"))
                    .body(dados).asObject(PedidoDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();

        }
        return response.getBody();

    }

    public void postPedido(PedidoDTO dados) throws IOException {
        var props = properties.getProperties();
        String url = DadosMicroServicos.endPointPedidos;
        try {
            var response = Unirest.post(url)
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + props.getProperty("properties.token"))
                    .queryString("idProdutoI7", DadosMicroServicos.idProdutoI7)
                    .queryString("idClienteI7", props.getProperty("properties.idcliente"))
                    .body(dados);

        } catch (UnirestException e) {
            e.printStackTrace();
        }

    }
}
