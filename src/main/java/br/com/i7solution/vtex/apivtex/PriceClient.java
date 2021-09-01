package br.com.i7solution.vtex.apivtex;

import br.com.i7solution.vtex.apivtex.dtos.PriceDTO;
import org.springframework.stereotype.Service;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;


@Service
public class PriceClient {

    public PriceDTO getPrecoPorSku(String skuId) {
        String url = DadosVtex.url + DadosVtex.endPointPreco + skuId + "?an=" + DadosVtex.sellers;
        HttpResponse<PriceDTO> response = null;
        try {
            response = Unirest.get(url).header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken", DadosVtex.appToken)
                    .asObject(PriceDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return response.getBody();
    }

    public PriceDTO putPrecoPorSku(String skuId, PriceDTO dados) {
        String url = DadosVtex.url + DadosVtex.endPointPreco + skuId + "?an=" + DadosVtex.sellers;
        HttpResponse<PriceDTO> response = null;
        try {
            response = Unirest.put(url).header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken", DadosVtex.appToken)
                    .body(dados).asObject(PriceDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return response.getBody();
    }
}
