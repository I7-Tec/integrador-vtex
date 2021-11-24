package br.com.i7solution.vtex.apivtex.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class FixedPricesDTO implements Serializable {
    private String tradePolicyId;
    private Double value;
    private Double listPrice;
    private Integer minQuantity;
    private Date dateRange;

    @Override
    public String toString() {
        return "FixedPricesDTO{" +
                "    \"tradePolicyId\": \"" + tradePolicyId + "\",\n" +
                "    \"value \": " + value + ",\n" +
                "    \"listPrice\": " + listPrice + ",\n" +
                "    \"minQuantity\": " + minQuantity + "\n" +
                "}";
    }
}
