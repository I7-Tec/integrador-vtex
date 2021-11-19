package br.com.i7solution.vtex.clients;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import br.com.i7solution.vtex.apivtex.dtos.PaymentsDTO;
import br.com.i7solution.vtex.config.PropertiesConfig;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.i7solution.vtex.apivtex.DadosVtex;
import br.com.i7solution.vtex.clients.dtos.ProdutoDTO;

@Log4j2
@Service
public class ProdutoClient {

    @Autowired
    private PropertiesConfig properties;

    public List<ProdutoDTO> getProdutos(int pageNumber, int pageSize) throws IOException {
        var props = properties.getProperties();
        String idCliente = props.getProperty("properties.idcliente");
        String token = props.getProperty("properties.token");

        String url = DadosMicroServicos.endPointProdutos;
        HttpResponse<List<ProdutoDTO>> response = null;
        try {
            response = Unirest.get(url)
                    .connectTimeout(60000)
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + token)
                    .queryString("idClienteI7", idCliente)
                    .queryString("idProdutoI7", DadosMicroServicos.idProdutoI7)
                    .asObject(new GenericType<List<ProdutoDTO>>() {});

            if(response != null) {
                return response.getBody();
            }
            return null;
        } catch (UnirestException e) {
            log.warn("[getProdutos: UnirestException] - Erro: " + e.getMessage());
            return null;
        } catch (Exception e) {
            log.warn("[getProdutos: Exception] - Erro: " + e);
            return null;
        }
    }

    public ProdutoDTO getProdutoPorId(String id) throws IOException {
        var props = properties.getProperties();
        String idCliente = props.getProperty("properties.idcliente");
        String token = props.getProperty("properties.token");

        String url = DadosMicroServicos.endPointProdutos;
        HttpResponse<ProdutoDTO[]> response = null;
        try {
            log.info("[getProdutoPorId] - Buscando produto " + id);
            response = Unirest.get(url)
                    .connectTimeout(60000)
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + token)
                    .queryString("idClienteI7", idCliente)
                    .queryString("idProdutoI7", DadosMicroServicos.idProdutoI7)
                    .queryString("id", id)
                    .asObject(ProdutoDTO[].class);

            if (response != null) {
                if (response.getBody().length > 0) {
                    return response.getBody()[0];
                }
            }
            return null;
        } catch (UnirestException e) {
            log.warn("[getProdutoPorId: UnirestException] - Erro: " + e.getMessage());
            return null;
        } catch (Exception e) {
            log.warn("[getProdutoPorId: Exception] - Erro: " + e);
            return null;
        }
    }

    public HashMap<String, Object> getFotoProdutoPorId(String id) throws IOException {
        var props = properties.getProperties();
        String idCliente = props.getProperty("properties.idcliente");
        String token = props.getProperty("properties.token");
        var result = new HashMap<String, Object>();

        String url = DadosMicroServicos.endPointFotoProduto;
        HttpResponse<byte[]> response = null;
        try {
            log.info("[getProdutoPorId] - Buscando produto " + id);
            var request = Unirest.get(url)
                    .connectTimeout(60000)
                    .header("Content-Type", "image/jpg")
                    .header("Authorization", "Bearer " + token)
                    .queryString("idClienteI7", idCliente)
                    .queryString("idProdutoI7", DadosMicroServicos.idProdutoI7)
                    .queryString("id", id);

            response = request.asBytes();//File("./cache_imagens/produto_" + id + ".jpg");
            var arqImagem = response.getBody();
            if (response.isSuccess()) {
                result.put("file", arqImagem);
                result.put("url", url + "?idClienteI7=" + idCliente +
                        "&idProdutoI7=" + DadosMicroServicos.idProdutoI7 +
                        "&id=" + id
                );
                return result;
            }
            var msg = response.mapError(HashMap.class);
            if (msg.containsKey("Message")) log.info("[postSku] Erro: " + msg.get("Message"));
            if (msg.containsKey("message")) log.info("[postSku] Erro: " + msg.get("message"));
            return null;
        } catch (UnirestException e) {
            log.warn("[getProdutoPorId: UnirestException] - Erro: " + e.getMessage());
            return null;
        } catch (Exception e) {
            log.warn("[getProdutoPorId: Exception] - Erro: " + e);
            return null;
        }
    }

    public ProdutoDTO putProdutoPorId(String id, ProdutoDTO dados) throws IOException {
        var props = properties.getProperties();
        String idCliente = props.getProperty("properties.idcliente");
        String token = props.getProperty("properties.token");
        String url = DadosMicroServicos.endPointProdutos;

        HttpResponse<ProdutoDTO> response = null;
        try {
            response = Unirest.put(url)
                    .connectTimeout(60000)
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + token)
                    .queryString("idClienteI7", idCliente)
                    .queryString("idProdutoI7", DadosMicroServicos.idProdutoI7)
                    .body(dados).asObject(ProdutoDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        if(response != null) {
            return response.getBody();
        }
        return null;
    }

    public ProdutoDTO postProdutoPorId(String id, ProdutoDTO dados) throws IOException {
        var props = properties.getProperties();
        String idCliente = props.getProperty("properties.idcliente");
        String token = props.getProperty("properties.token");
        String url = DadosMicroServicos.endPointProdutos;

        HttpResponse<ProdutoDTO> response = null;
        try {
            response = Unirest.post(url)
                    .connectTimeout(60000)
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + token)
                    .queryString("idClienteI7", idCliente)
                    .queryString("idProdutoI7", DadosMicroServicos.idProdutoI7)
                    .body(dados).asObject(ProdutoDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        if(response != null) {
            return response.getBody();
        }
        return null;
    }

}

