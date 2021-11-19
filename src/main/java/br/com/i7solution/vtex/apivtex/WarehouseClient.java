package br.com.i7solution.vtex.apivtex;

import br.com.i7solution.vtex.apivtex.DadosVtex;
import br.com.i7solution.vtex.apivtex.dtos.WarehouseDTO;
import br.com.i7solution.vtex.config.PropertiesConfig;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WarehouseClient {

    @Autowired
    private PropertiesConfig properties;

    public WarehouseDTO postWarehouse(WarehouseDTO warehouse) throws IOException {
        var props = properties.getProperties();
        String url = props.getProperty("properties.vtex.url") + DadosVtex.endPointWarehouse;
        HttpResponse<WarehouseDTO> response = null;
        try {
            response = Unirest.post(url).header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", props.getProperty("properties.vtex.appkey"))
                    .header("X-VTEX-API-AppToken", props.getProperty("properties.vtex.apptoken"))
                    .body(warehouse)
                    .asObject(WarehouseDTO.class);
            return response.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
            return null;
        }
    }
}
