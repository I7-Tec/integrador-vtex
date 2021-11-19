package br.com.i7solution.vtex.apivtex;

import br.com.i7solution.vtex.apivtex.dtos.PriceDTO;
import br.com.i7solution.vtex.config.PropertiesConfig;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

import java.io.IOException;


@Service
@Log4j2
public class PriceClient {

    @Autowired
    private PropertiesConfig properties;

    public PriceDTO getPreco(String skuId) throws IOException {
        var props = properties.getProperties();
        String url = props.getProperty("properties.vtex.url") + DadosVtex.endPointPreco + skuId;
        HttpResponse<PriceDTO> response = null;
        try {
            response = Unirest.get(url).header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", props.getProperty("properties.vtex.appkey"))
                    .header("X-VTEX-API-AppToken", props.getProperty("properties.vtex.apptoken"))
                    .asObject(PriceDTO.class);
            return response.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
            return null;
        }
    }

    public PriceDTO putPreco(Long skuId, PriceDTO dados) throws IOException {
        var props = properties.getProperties();
        String url = props.getProperty("properties.vtex.url") + DadosVtex.endPointPreco + skuId;
        HttpResponse<PriceDTO> response = null;
        try {
            response = Unirest.put(url)
                    .header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", props.getProperty("properties.vtex.appkey"))
                    .header("X-VTEX-API-AppToken", props.getProperty("properties.vtex.apptoken"))
                    .body(dados)
                    .asObject(PriceDTO.class);
            return response.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
            return null;
        }
    }
}
