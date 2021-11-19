package br.com.i7solution.vtex.clients;

import br.com.i7solution.vtex.clients.dtos.SecaoDTO;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecaoClient {

    public List<SecaoDTO> getSecoes() {
        String url = DadosMicroServicos.endPointSecoes;
        HttpResponse<List<SecaoDTO>> response = null;
        try {
            response = Unirest.get(url)
                    .queryString("enviaEcommerce", true)
                    .header("Content-Type", "application/json")
                    .connectTimeout(60000)
                    .asObject(new GenericType<List<SecaoDTO>>() {
                    });
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return response.getBody();
    }

    public SecaoDTO putSecao(SecaoDTO secao) {
        String url = DadosMicroServicos.endPointSecoes;
        HttpResponse<SecaoDTO> response = null;
        try {
            response = Unirest.put(url)
                    .body(secao)
                    .header("Content-Type", "application/json")
                    .connectTimeout(60000)
                    .asObject(SecaoDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return response.getBody();
    }
}


