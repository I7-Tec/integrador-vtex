package br.com.i7solution.vtex.clients;

import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import org.springframework.stereotype.Service;
import br.com.i7solution.vtex.clients.dtos.TabelaPrecoDTO;



@Service
public class TabelaPrecoClient {

    public TabelaPrecoDTO[] getPrecosWinthor(String idProduto) {
        String url = DadosMicroServicos.urlPedidos + DadosMicroServicos.endPointPrecos;
        HttpResponse<TabelaPrecoDTO[]> response = null;
        try {
            response = Unirest.get(url)
                    .queryString("idProduto", idProduto)
                    .header("Content-Type", "application/json")
                    .asObject(new GenericType<TabelaPrecoDTO[]>() {
                    });
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        if(response != null){
            return response.getBody();
        }
        return null;
    }
}
