package br.com.i7solution.vtex.clients;

import br.com.i7solution.vtex.clients.dtos.MarcaDTO;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaClient {

    public List<MarcaDTO> getMarcas() {
        String url = DadosMicroServicos.endPointMarcas;
        HttpResponse<List<MarcaDTO>> response = null;
        try {
            response = Unirest.get(url)
                    .queryString("enviaEcommerce", true)
                    .header("Content-Type", "application/json")
                    .connectTimeout(60000)
                    .asObject(new GenericType<List<MarcaDTO>>() {
                    });
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return response.getBody();
    }

    public MarcaDTO putMarca(MarcaDTO marca) {
        String url = DadosMicroServicos.endPointMarcas;
        HttpResponse<MarcaDTO> response = null;
        try {
            response = Unirest.put(url)
                    .body(marca)
                    .header("Content-Type", "application/json")
                    .connectTimeout(60000)
                    .asObject(MarcaDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return response.getBody();
    }
}


