package br.com.i7solution.vtex.apivtex;

import br.com.i7solution.vtex.apivtex.dtos.InventoryDTO;

import br.com.i7solution.vtex.config.PropertiesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.i7solution.vtex.apivtex.dtos.BalanceDTO;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

import java.io.IOException;

@Service
public class InventoryClient {

    @Autowired
    private PropertiesConfig properties;

    public InventoryDTO putEstoquePorSku(InventoryDTO inventory, Long skuId, String warehouseId) throws IOException {
        var props = properties.getProperties();
        String url = props.getProperty("properties.vtex.url") + DadosVtex.endPointEstoquePorSku +  "/warehouses/" + warehouseId;
        HttpResponse<InventoryDTO> response = null;
        try {
            response = Unirest.put(url)
                    .header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", props.getProperty("properties.vtex.appkey"))
                    .header("X-VTEX-API-AppToken", props.getProperty("properties.vtex.apptoken"))
                    .body(inventory)
                    .asObject(InventoryDTO.class);
            return response.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
            return null;
        }
    }

}
