package br.com.i7solution.vtex.apivtex;

import br.com.i7solution.vtex.apivtex.dtos.BrandInclusaoDTO;
import br.com.i7solution.vtex.config.PropertiesConfig;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;

@Service
@Log4j2
public class BrandClient {

    @Autowired
    private PropertiesConfig properties;

    public BrandInclusaoDTO postBrand(BrandInclusaoDTO brand) throws IOException {
        var props = properties.getProperties();
        String url = props.getProperty("properties.vtex.url") + DadosVtex.endPointMarcas;
        HttpResponse<BrandInclusaoDTO> response = null;
        try {
            response = Unirest.post(url)
                    .header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", props.getProperty("properties.vtex.appkey"))
                    .header("X-VTEX-API-AppToken", props.getProperty("properties.vtex.apptoken"))
                    .body(brand)
                    .asObject(BrandInclusaoDTO.class);

            if (response.getStatus() == 200) {
                return response.getBody();
            } else {
                String msgErro = "HttpStatus: " + response.getStatus() + " ";
                var msg = response.mapError(HashMap.class);
                if (msg != null) {
                    if (msg.containsKey("message")) msgErro += msg.containsKey("message");
                    if (msg.containsKey("Message")) msgErro += msg.containsKey("Message");
                }
                throw new UnirestException(msgErro);
            }
        } catch (UnirestException e) {
            log.warn("[postBrand] - Erro: " + e.getMessage());
            return null;
        }
    }
}
