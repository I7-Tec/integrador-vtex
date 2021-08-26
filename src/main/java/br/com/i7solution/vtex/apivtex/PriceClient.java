package br.com.i7solution.vtex.apivtex;

import org.springframework.stereotype.Service;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import br.com.i7solution.vtex.apivtex.dtos.SkuPriceDTO;

@Service
public class PriceClient {

    public SkuPriceDTO getPrecoPorSku(String skuId) {
        String url = DadosVtex.url + DadosVtex.endPointPreco + skuId + "?an=" + DadosVtex.sellers;
        HttpResponse<SkuPriceDTO> response = null;
        try {
            response = Unirest.get(url).header("Content-Type", "application/json")
                    .header("Authorization", DadosVtex.bearer).asObject(SkuPriceDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return response.getBody();
    }

    public SkuPriceDTO putPrecoPorSku(String skuId, SkuPriceDTO dados) {
        String url = DadosVtex.url + DadosVtex.endPointPreco + skuId + "?an=" + DadosVtex.sellers;
        HttpResponse<SkuPriceDTO> response = null;
        try {
            response = Unirest.put(url).header("Content-Type", "application/json")
                    .header("Authorization", DadosVtex.bearer).body(dados).asObject(SkuPriceDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return response.getBody();
    }
}
