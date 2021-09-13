package br.com.i7solution.vtex.apivtex;

import br.com.i7solution.vtex.apivtex.DadosVtex;
import br.com.i7solution.vtex.apivtex.dtos.WarehouseDTO;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import org.springframework.stereotype.Service;

@Service
public class WarehouseClient {
    public WarehouseDTO postWarehouse(WarehouseDTO warehouse) {
        String url = DadosVtex.url + DadosVtex.endPointWarehouse;
        HttpResponse<WarehouseDTO> response = null;
        try {
            response = Unirest.post(url).header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken", DadosVtex.appToken)
                    .body(warehouse)
                    .asObject(WarehouseDTO.class);
            return response.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
            return null;
        }
    }
}
