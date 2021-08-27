package br.com.i7solution.vtex.clients;

import java.util.List;

import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import org.springframework.stereotype.Service;

import br.com.i7solution.vtex.apivtex.DadosVtex;
import br.com.i7solution.vtex.clients.dtos.ProdutoDTO;

@Service
public class ProdutoClient {

    public List<ProdutoDTO> getProdutos() {
        String url = DadosMicroServicos.urlCadastros + DadosMicroServicos.endPointProdutos;
        HttpResponse<List<ProdutoDTO>> response = null;
        try {
            response = Unirest.get(url).header("Content-Type", "application/json")
                    .asObject(new GenericType<List<ProdutoDTO>>() {
                    });
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return response.getBody();
    }

    public ProdutoDTO getProdutoPorId(String id) {
        String url = DadosMicroServicos.urlCadastros + DadosMicroServicos.endPointProdutos + id + "?an=";
        // Unirest.setTimeouts(0, 0);
        HttpResponse<ProdutoDTO> response = null;
        try {
            response = Unirest.get(url).header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken",DadosVtex.appToken)
                    .asObject(ProdutoDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return response.getBody();
    }

    public ProdutoDTO putProdutoPorId(String id, ProdutoDTO dados) {
        String url = DadosMicroServicos.urlCadastros + DadosMicroServicos.endPointProdutos + id + "?an=";
        // Unirest.setTimeouts(0,0);
        HttpResponse<ProdutoDTO> response = null;
        try {
            response = Unirest.put(url).header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken",DadosVtex.appToken)
                    .body(dados).asObject(ProdutoDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return response.getBody();
    }

    public ProdutoDTO postProdutoPorId(String id, ProdutoDTO dados) {
        String url = DadosMicroServicos.urlCadastros + DadosMicroServicos.endPointProdutos + id + "?an=";
        // Unirest.setTimeouts(0,0);
        HttpResponse<ProdutoDTO> response = null;
        try {
            response = Unirest.post(url).header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken",DadosVtex.appToken)
                    .body(dados).asObject(ProdutoDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return response.getBody();
    }

}
