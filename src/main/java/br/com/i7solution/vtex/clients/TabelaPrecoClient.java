package br.com.i7solution.vtex.clients;

import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import org.springframework.stereotype.Service;
import br.com.i7solution.vtex.clients.dtos.TabelaPrecoDTO;



@Service
public class TabelaPrecoClient {

    public TabelaPrecoDTO[] getPrecos(int pageNumber, int pageSize) {
        String url = DadosMicroServicos.urlPedidos + DadosMicroServicos.endPointPrecos;
        HttpResponse<TabelaPrecoDTO[]> response = null;
        try {
            response = Unirest.get(url)
                    .connectTimeout(60000)
                    .queryString("pageSize", pageSize)
                    .queryString("pageNumber", pageNumber)
                    .header("Content-Type", "application/json")
                    .asObject(new GenericType<TabelaPrecoDTO[]>() {
                    });
            return response.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
            return null;
        }
    }
}
