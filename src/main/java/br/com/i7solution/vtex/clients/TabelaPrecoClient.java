package br.com.i7solution.vtex.clients;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import br.com.i7solution.vtex.clients.dtos.TabelaPrecoDTO;

@Service
@Log4j2
public class TabelaPrecoClient {
    public TabelaPrecoDTO[] getPrecos(int pageNumber, int pageSize) {
        String url = DadosMicroServicos.endPointPrecos;
        HttpResponse<TabelaPrecoDTO[]> response = null;
        try {
            response = Unirest.get(url)
                    .connectTimeout(60000)
                    .queryString("pageSize", pageSize)
                    .queryString("pageNumber", pageNumber)
                    .header("Content-Type", "application/json")
                    .asObject(TabelaPrecoDTO[].class);
            return response.getBody();
        } catch (UnirestException e) {
            log.warn("[getPrecos] - Erro: " + e.getMessage());
            return null;
        }
    }
}
