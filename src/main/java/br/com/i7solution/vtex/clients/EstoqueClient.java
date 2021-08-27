package br.com.i7solution.vtex.clients;

import java.util.List;

import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import org.springframework.stereotype.Service;
import br.com.i7solution.vtex.apivtex.DadosVtex;
import br.com.i7solution.vtex.clients.dtos.EstoqueDTO;


    @Service
    public class EstoqueClient {

        public EstoqueDTO[] getEstoque(String idProduto) {
            String url = DadosMicroServicos.urlEstoques + DadosMicroServicos.endPointEstoques;
            HttpResponse<EstoqueDTO[]> response = null;
            try {
                response = Unirest.get(url)
                        .queryString("idProduto", idProduto)
                        .header("Content-Type", "application/json")
                        .asObject(new GenericType<EstoqueDTO[]>() {});
            } catch (UnirestException e) {
                e.printStackTrace();
            }

            if(response != null){
                return response.getBody();
            }
            return null;
        }

        public EstoqueDTO getEstoquePorId(String id) {
            String url = DadosMicroServicos.urlEstoques;
            HttpResponse<EstoqueDTO> response = null;
            try {
                response = Unirest.get(url)
                        .header("Content-Type", "application/json")
                        .asObject(EstoqueDTO.class);
            } catch (UnirestException e) {
                e.printStackTrace();
            }

            return response.getBody();
        }


    public EstoqueDTO putEstoquePorIds(String idProduto, String idFilial, EstoqueDTO dados) {
        String url = DadosMicroServicos.urlCadastros + DadosMicroServicos.endPointEstoques + idProduto + idFilial + "?an=";
        // Unirest.setTimeouts(0, 0);
        HttpResponse<EstoqueDTO> response = null;
        try {
            response = Unirest.put(url).header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken",DadosVtex.appToken)
                    .body(dados).asObject(EstoqueDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return response.getBody();
    }

    public EstoqueDTO postEstoquePorIds(String idProduto, String idFilial, EstoqueDTO dados) {
        String url = DadosMicroServicos.urlCadastros + DadosMicroServicos.endPointEstoques + idProduto + idFilial + "?an=";
        // Unirest.setTimeouts(0, 0);
        HttpResponse<EstoqueDTO> response = null;
        try {
            response = Unirest.post(url).header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken",DadosVtex.appToken)
                    .body(dados).asObject(EstoqueDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();

        }
        return response.getBody();

    }
}
