package br.com.i7solution.vtex.clients;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import br.com.i7solution.vtex.config.PropertiesConfig;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.i7solution.vtex.apivtex.DadosVtex;
import br.com.i7solution.vtex.clients.dtos.EstoqueDTO;

@Service
@Log4j2
public class EstoqueClient {

    @Autowired
    private PropertiesConfig properties;

    public EstoqueDTO[] getEstoque() throws IOException {
        var props = properties.getProperties();
        String url = DadosMicroServicos.endPointEstoques;
        HttpResponse<EstoqueDTO[]> response = null;
        try {
            response = Unirest.get(url)
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + props.getProperty("properties.token"))
                    .queryString("idProdutoI7", DadosMicroServicos.idProdutoI7)
                    .queryString("idClienteI7", props.getProperty("properties.idcliente"))
                    //.queryString("idProduto", "")
                    .queryString("idFilial", "1")
                    .queryString("enviaEcommerce", true)
                    .asObject(EstoqueDTO[].class);

            return response.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
            return null;
        }
    }

    public EstoqueDTO getEstoquePorId(String idFilial, String idProduto) throws IOException {
        var props = properties.getProperties();
        String url = DadosMicroServicos.endPointEstoques;
        HttpResponse<EstoqueDTO[]> response = null;
        try {
            response = Unirest.get(url)
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + props.getProperty("properties.token"))
                    .queryString("idProdutoI7", DadosMicroServicos.idProdutoI7)
                    .queryString("idClienteI7", props.getProperty("properties.idcliente"))
                    .queryString("idFilial", idFilial)
                    .queryString("idProduto", idProduto)
                    .asObject(EstoqueDTO[].class);

            if (response.getStatus() == 200) {
                var result = response.getBody();
                if (result.length > 0) {
                    return result[0];
                }
                return null;
            } else {
                String msgErro = "";
                var msg = response.mapError(HashMap.class);
                if (msg.containsKey("message")) msgErro += msg.containsKey("message");
                if (msg.containsKey("Message")) msgErro += msg.containsKey("Message");
                throw new UnirestException(msgErro);
            }
        } catch (UnirestException e) {
            log.warn("[getEstoquePorId] - Erro: " + e.getMessage());
            return null;
        }
    }


    public EstoqueDTO putEstoquePorIds(String idProduto, String idFilial, EstoqueDTO dados) throws IOException {
        var props = properties.getProperties();
        String url = DadosMicroServicos.endPointEstoques ;
        // Unirest.setTimeouts(0, 0);
        HttpResponse<EstoqueDTO> response = null;
        try {
            response = Unirest.put(url)
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + props.getProperty("properties.token"))
                    .queryString("idProdutoI7", DadosMicroServicos.idProdutoI7)
                    .queryString("idClienteI7", props.getProperty("properties.idcliente"))
                    .body(dados).asObject(EstoqueDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return response.getBody();
    }

    public EstoqueDTO postEstoquePorIds(String idProduto, String idFilial, EstoqueDTO dados) throws IOException {
        var props = properties.getProperties();
        String url = DadosMicroServicos.endPointEstoques;
        // Unirest.setTimeouts(0, 0);
        HttpResponse<EstoqueDTO> response = null;
        try {
            response = Unirest.post(url)
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + props.getProperty("properties.token"))
                    .queryString("idProdutoI7", DadosMicroServicos.idProdutoI7)
                    .queryString("idClienteI7", props.getProperty("properties.idcliente"))
                    .body(dados).asObject(EstoqueDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();

        }
        return response.getBody();

    }
}
