package br.com.i7solution.vtex.apivtex.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class InventoryPutDTO implements Serializable {
    private boolean unlimitedQuantity;
    private String dateUtcOnBalanceSystem;
    private Integer quantity;

    @Override
    public String toString() {
        return "{" +
                "   \"unlimitedQuantity\": \"" + unlimitedQuantity + "\",\n" +
                "   \"dateUtcOnBalanceSystem\": \"" + dateUtcOnBalanceSystem + "\",\n" +
                "   \"quantity\": " + quantity + "\n" +
                "}";
    }
}