package br.com.i7solution.vtex.apivtex;

import br.com.i7solution.vtex.apivtex.dtos.InventoryGetDTO;
import br.com.i7solution.vtex.apivtex.dtos.InventoryPutDTO;
import br.com.i7solution.vtex.config.PropertiesConfig;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

import java.io.IOException;
import java.util.HashMap;

@Service
@Log4j2
public class InventoryClient {

    @Autowired
    private PropertiesConfig properties;

    public InventoryGetDTO getEstoquePorSku(InventoryPutDTO inventory, Long skuId, String warehouseId) throws IOException {
        var props = properties.getProperties();
        String url = props.getProperty("properties.vtex.url") + DadosVtex.endPointEstoquePorSku + skuId + "/warehouses/" + warehouseId;
        HttpResponse<InventoryGetDTO> response = null;
        try {
            response = Unirest.get(url)
                    .header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", props.getProperty("properties.vtex.appkey"))
                    .header("X-VTEX-API-AppToken", props.getProperty("properties.vtex.apptoken"))
                    .asObject(InventoryGetDTO.class);

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
            log.warn("[putEstoquePorSku] Erro: " + e.getMessage());
            return null;
        }
    }

    public boolean putEstoquePorSku(InventoryPutDTO inventory, Long skuId, String warehouseId) throws IOException {
        var props = properties.getProperties();
        String url = props.getProperty("properties.vtex.url") + DadosVtex.endPointEstoquePorSku + skuId + "/warehouses/" + warehouseId;
        HttpResponse<String> response = null;
        try {
            response = Unirest.put(url)
                    .header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", props.getProperty("properties.vtex.appkey"))
                    .header("X-VTEX-API-AppToken", props.getProperty("properties.vtex.apptoken"))
                    .body(inventory)
                    .asString();

            if (response.getStatus() == 200) {
                var result = response.getBody();
                return result.equalsIgnoreCase("true");
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
            log.warn("[putEstoquePorSku] Erro: " + e.getMessage());
            return false;
        }
    }

}
