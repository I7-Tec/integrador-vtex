package br.com.i7solution.vtex.clients;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.i7solution.vtex.apivtex.dtos.PaymentsDTO;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import org.springframework.stereotype.Service;

import br.com.i7solution.vtex.apivtex.DadosVtex;
import br.com.i7solution.vtex.clients.dtos.ProdutoDTO;

@Service
public class ProdutoClient {

    public List<ProdutoDTO> getProdutos(int pageNumber, int pageSize) {
        String url = DadosMicroServicos.urlCadastros + DadosMicroServicos.endPointProdutos;
        HttpResponse<List<ProdutoDTO>> response = null;
        try {
            response = Unirest.get(url)
                    .connectTimeout(60000)
                    .queryString("pageSize", pageSize)
                    .queryString("pageNumber", pageNumber)
                    .queryString("ativo", true)
                    .header("Content-Type", "application/json")
                    .asObject(new GenericType<List<ProdutoDTO>>() {
                    });
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        if(response != null) {
            return response.getBody();
        }
        return null;
    }

    public ProdutoDTO getProdutoPorId(String id) {
        String url = DadosMicroServicos.urlCadastros + DadosMicroServicos.endPointProdutos + id ;
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

        if (response != null) {
            return response.getBody();
        }
        return null ;
    }

    public ProdutoDTO putProdutoPorId(String id, ProdutoDTO dados) {
        String url = DadosMicroServicos.urlCadastros + DadosMicroServicos.endPointProdutos + "/" +id ;
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

        if(response != null) {
            return response.getBody();
        }
        return null;
    }

    public ProdutoDTO postProdutoPorId(String id, ProdutoDTO dados) {
        String url = DadosMicroServicos.urlCadastros + DadosMicroServicos.endPointProdutos  ;
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

        if(response != null) {
            return response.getBody();
        }
        return null;
    }
    public List<PaymentsDTO> getPagamentosPedido(Long orderId) {
        List<PaymentsDTO> result = new ArrayList<>();
        HttpResponse<List<PaymentsDTO>> response = null;
        try {
            String url = DadosVtex.url + DadosVtex.endPointPedidos + orderId + "/payment-transaction" ;

            response = Unirest.get(url)
                    .header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken",DadosVtex.appToken)
                    .asObject(new GenericType<List<PaymentsDTO>>() {
                    });

            result = response.getBody();

        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return result;
    }

}

