package br.com.i7solution.vtex.apivtex;

import br.com.i7solution.vtex.apivtex.dtos.SKUPriceDTO;
import org.springframework.stereotype.Service;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;


@Service
public class PriceClient {

    public SKUPriceDTO getPrecoPorSku(String skuId) {
        String url = DadosVtex.url + DadosVtex.endPointPreco + skuId + "?an=" + DadosVtex.sellers;
        HttpResponse<SKUPriceDTO> response = null;
        try {
            response = Unirest.get(url).header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken", DadosVtex.appToken)
                    .asObject(SKUPriceDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return response.getBody();
    }

    public SKUPriceDTO putPrecoPorSku(String skuId, SKUPriceDTO dados) {
        String url = DadosVtex.url + DadosVtex.endPointPreco + skuId + "?an=" + DadosVtex.sellers;
        HttpResponse<SKUPriceDTO> response = null;
        try {
            response = Unirest.put(url).header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken", DadosVtex.appToken)
                    .body(dados).asObject(SKUPriceDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return response.getBody();
    }
}
