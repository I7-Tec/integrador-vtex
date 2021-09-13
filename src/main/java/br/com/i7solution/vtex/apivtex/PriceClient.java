package br.com.i7solution.vtex.apivtex;

import br.com.i7solution.vtex.apivtex.dtos.PriceDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;


@Service
@Log4j2
public class PriceClient {

    public PriceDTO getPreco(String skuId) {
        String url = DadosVtex.url + DadosVtex.endPointPreco + skuId;
        HttpResponse<PriceDTO> response = null;
        try {
            response = Unirest.get(url).header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken", DadosVtex.appToken)
                    .asObject(PriceDTO.class);
            return response.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
            return null;
        }
    }

    public PriceDTO putPreco(Long skuId, PriceDTO dados) {
        String url = DadosVtex.url + DadosVtex.endPointPreco + skuId;
        log.info(url);
        HttpResponse<PriceDTO> response = null;
        try {
            response = Unirest.put(url)
                    .header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken", DadosVtex.appToken)
                    .body(dados)
                    .asObject(PriceDTO.class);
            log.info("Status Code Put Price: " + response.getStatus());
            log.info("Body Response Put Price " + response.getBody());
            return response.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
            return null;
        }
    }
}
