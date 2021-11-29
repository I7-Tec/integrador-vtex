package br.com.i7solution.vtex.clients;

import br.com.i7solution.vtex.clients.dtos.ImportarPedidoDTO;
import br.com.i7solution.vtex.config.PropertiesConfig;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

import br.com.i7solution.vtex.clients.dtos.PedidoDTO;

import java.io.IOException;
import java.util.HashMap;

@Service
@Log4j2
public class PedidoClient {

    @Autowired
    private PropertiesConfig properties;

    public PedidoDTO getPedidoPorId(Long id) throws IOException {
        var props = properties.getProperties();
        String url = DadosMicroServicos.endPointPedidos;
        HttpResponse<PedidoDTO> response = null;
        try {
            response = Unirest.get(url)
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + props.getProperty("properties.token"))
                    .queryString("idProdutoI7", DadosMicroServicos.idProdutoI7)
                    .queryString("idClienteI7", props.getProperty("properties.idcliente"))
                    .queryString("id", id)
                    .asObject(PedidoDTO.class);

            if (response.getStatus() == 200) {
                return response.getBody();
            } else {
                String msgErro = "HttpStatus: " + response.getStatus();
                var msg = response.mapError(HashMap.class);
                if (msg != null) {
                    if (msg.containsKey("message")) msgErro += msg.get("message") + " \n";
                    if (msg.containsKey("Message")) msgErro += msg.get("Message") + " \n";
                }
                throw new UnirestException(msgErro);
            }
        } catch (UnirestException e) {
            log.warn("[getPedidoPorId] - Erro: " + e.getMessage());
            return null;
        }
    }

    public PedidoDTO getPedidoPorNumpedWeb(Long numpedweb) throws IOException {
        var props = properties.getProperties();
        String url = DadosMicroServicos.endPointPedidos;
        HttpResponse<PedidoDTO> response = null;
        try {
            response = Unirest.get(url)
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + props.getProperty("properties.token"))
                    .queryString("idProdutoI7", DadosMicroServicos.idProdutoI7)
                    .queryString("idClienteI7", props.getProperty("properties.idcliente"))
                    .queryString("numpedweb", numpedweb)
                    .asObject(PedidoDTO.class);

            if (response.getStatus() == 200) {
                return response.getBody();
            } else {
                String msgErro = "HttpStatus: " + response.getStatus();
                var msg = response.mapError(HashMap.class);
                if (msg != null) {
                    if (msg.containsKey("message")) msgErro += msg.get("message") + " \n";
                    if (msg.containsKey("Message")) msgErro += msg.get("Message") + " \n";
                }
                throw new UnirestException(msgErro);
            }
        } catch (UnirestException e) {
            log.warn("[getPedidoPorId] - Erro: " + e.getMessage());
            return null;
        }
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

    public ImportarPedidoDTO importarPedido(Long numpedweb) throws IOException {
        var props = properties.getProperties();
        String url = DadosMicroServicos.endPointPedidos;
        try {
            var response = Unirest.post(url)
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + props.getProperty("properties.token"))
                    .queryString("idProdutoI7", DadosMicroServicos.idProdutoI7)
                    .queryString("idClienteI7", props.getProperty("properties.idcliente"))
                    .queryString("id", numpedweb)
                    .asObject(ImportarPedidoDTO.class);

            if (response.isSuccess()) {
                return response.getBody();
            } else {
                String msgErro = "HttpStatus: " + response.getStatus();
                var msg = response.mapError(HashMap.class);
                if (msg != null) {
                    if (msg.containsKey("message")) msgErro += msg.get("message") + " \n";
                    if (msg.containsKey("Message")) msgErro += msg.get("Message") + " \n";
                }
                throw new UnirestException(msgErro);
            }
        } catch (UnirestException e) {
            log.warn("[importarPedido] - Erro: " + e.getMessage());
            return null;
        }

    }
}
