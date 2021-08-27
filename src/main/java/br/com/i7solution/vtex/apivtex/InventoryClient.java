package br.com.i7solution.vtex.apivtex;

import br.com.i7solution.vtex.apivtex.dtos.InventoryDTO;

import org.springframework.stereotype.Service;

import br.com.i7solution.vtex.apivtex.dtos.BalanceDTO;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

@Service
public class InventoryClient {

    public InventoryDTO getEstoquePorSku(String skuId) {
        String url = DadosVtex.url + DadosVtex.endPointEstoque+ skuId + "?an=" + DadosVtex.sellers;
        HttpResponse<InventoryDTO> response = null;
        try {
            response = Unirest.get(url)
                    .header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken",DadosVtex.appToken)
                    .asObject(InventoryDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return response.getBody();
    }

    public String putEstoquePorSku(String skuId, String filial, BalanceDTO dados) {
        String url = DadosVtex.url + DadosVtex.endPointEstoque + skuId + "/" + filial + "?an=" + DadosVtex.sellers;
        HttpResponse<String> response = null;
        try {
            response = Unirest.put(url)
                    .header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken",DadosVtex.appToken)
                    .body(dados)
                    .asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return response.getBody();
    }


    public InventoryDTO postEstoquePorSku(String skuId, BalanceDTO dados) {
        String url = DadosVtex.url + DadosVtex.endPointEstoque + skuId + "/" + "?an=" + DadosVtex.sellers;
        HttpResponse<InventoryDTO> response = null;
        try {
            response = Unirest.post(url).header("Content-type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken",DadosVtex.appToken)
                    .body(dados)
                    .asObject(InventoryDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return response.getBody();

    }

}
