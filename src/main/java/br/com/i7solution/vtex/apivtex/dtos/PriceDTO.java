package br.com.i7solution.vtex.apivtex.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class PriceDTO implements Serializable {
    private String itemId;
    private Double listPrice;
    private Double costPrice;
    private Double basePrice;
    private Integer markup;
    private FixedPricesDTO fixedPrices[];

    @Override
    public String toString() {
        return "PriceDTO{" +
                "    \"itemId\": \"" + itemId + "\",\n" +
                "    \"markup\": " + markup + ",\n" +
                "    \"listPrice\": " + listPrice + ",\n" +
                "    \"basePrice\": " + basePrice + ",\n" +
                "    \"costPrice\": " + costPrice + ",\n" +
                "    \"fixedPrices\": " + fixedPrices.toString() + "\n" +
                '}';
    }
}
