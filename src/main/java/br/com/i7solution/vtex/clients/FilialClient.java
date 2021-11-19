package br.com.i7solution.vtex.clients;

import br.com.i7solution.vtex.clients.dtos.EstoqueDTO;
import br.com.i7solution.vtex.clients.dtos.FilialDTO;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import org.springframework.stereotype.Service;

@Service
public class FilialClient {
    public FilialDTO[] carregar() {
        String url = DadosMicroServicos.endPointFiliais;
        HttpResponse<FilialDTO[]> response = null;
        try {
            response = Unirest.get(url)
                    .header("Content-Type", "application/json")
                    .asObject(new GenericType<FilialDTO[]>() {
                    });
            return response.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
            return null;
        }
    }
}
