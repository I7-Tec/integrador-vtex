package br.com.i7solution.vtex.apivtex;

import br.com.i7solution.vtex.apivtex.dtos.InventoryDTO;

import org.springframework.stereotype.Service;

import br.com.i7solution.vtex.apivtex.dtos.BalanceDTO;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

@Service
public class InventoryClient {

    public InventoryDTO putEstoquePorSku(InventoryDTO inventory, Long skuId, String warehouseId) {
        String url = DadosVtex.url + DadosVtex.endPointEstoquePorSku +  "/warehouses/" + warehouseId;
        HttpResponse<InventoryDTO> response = null;
        try {
            response = Unirest.put(url)
                    .header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken",DadosVtex.appToken)
                    .body(inventory)
                    .asObject(InventoryDTO.class);
            return response.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
            return null;
        }
    }

}
