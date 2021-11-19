package br.com.i7solution.vtex.clients;

import java.io.IOException;
import java.util.List;

import br.com.i7solution.vtex.config.PropertiesConfig;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.i7solution.vtex.apivtex.DadosVtex;
import br.com.i7solution.vtex.clients.dtos.EstoqueDTO;


@Service
public class EstoqueClient {

    @Autowired
    private PropertiesConfig properties;

    public EstoqueDTO[] getEstoque(int pageNumber, int pageSize) throws IOException {
        var props = properties.getProperties();
        String url = DadosMicroServicos.endPointEstoques;
        HttpResponse<EstoqueDTO[]> response = null;
        try {
            response = Unirest.get(url)
                    .queryString("pageSize", pageSize)
                    .queryString("pageNumber", pageNumber)
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + props.getProperty("properties.token"))
                    .queryString("idProdutoI7", DadosMicroServicos.idProdutoI7)
                    .queryString("idClienteI7", props.getProperty("properties.idcliente"))
                    .asObject(new GenericType<EstoqueDTO[]>() {
                    });
            return response.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
            return null;
        }
    }

    public EstoqueDTO getEstoquePorId(String id) throws IOException {
        var props = properties.getProperties();
        String url = DadosMicroServicos.endPointEstoques;
        HttpResponse<EstoqueDTO> response = null;
        try {
            response = Unirest.get(url)
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + props.getProperty("properties.token"))
                    .queryString("idProdutoI7", DadosMicroServicos.idProdutoI7)
                    .queryString("idClienteI7", props.getProperty("properties.idcliente"))
                    .asObject(EstoqueDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return response.getBody();
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
