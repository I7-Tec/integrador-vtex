package br.com.i7solution.vtex.clients;

import br.com.i7solution.vtex.config.PropertiesConfig;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

import br.com.i7solution.vtex.apivtex.DadosVtex;
import br.com.i7solution.vtex.clients.dtos.EnderecoDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class EnderecoClient {

    @Autowired
    private PropertiesConfig properties;

    public EnderecoDTO getEnderecoPorId(String id) throws IOException {
        var props = properties.getProperties();
        String url = DadosMicroServicos.endPointEnderecos;
        HttpResponse<EnderecoDTO> response = null;
        try {
            response = Unirest.get(url)
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + props.getProperty("properties.token"))
                    .queryString("idProdutoI7", DadosMicroServicos.idProdutoI7)
                    .queryString("idClienteI7", props.getProperty("properties.idcliente"))
                    .asObject(EnderecoDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return response.getBody();
    }

    public EnderecoDTO putEnderecoPorId(String id, EnderecoDTO dados) throws IOException {
        var props = properties.getProperties();
        String url = DadosMicroServicos.endPointEnderecos;
        HttpResponse<EnderecoDTO> response = null;
        try {
            response = Unirest.put(url)
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + props.getProperty("properties.token"))
                    .queryString("idProdutoI7", DadosMicroServicos.idProdutoI7)
                    .queryString("idClienteI7", props.getProperty("properties.idcliente"))
                    .body(dados).asObject(EnderecoDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return response.getBody();
    }

    public EnderecoDTO postEnderecoPorId(String id, EnderecoDTO dados) throws IOException {
        var props = properties.getProperties();
        String url = DadosMicroServicos.endPointEnderecos;
        HttpResponse<EnderecoDTO> response = null;
        try {
            response = Unirest.post(url)
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + props.getProperty("properties.token"))
                    .queryString("idProdutoI7", DadosMicroServicos.idProdutoI7)
                    .queryString("idClienteI7", props.getProperty("properties.idcliente"))
                    .body(dados).asObject(EnderecoDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return response.getBody();
    }

}