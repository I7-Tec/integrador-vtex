package br.com.i7solution.vtex.apivtex.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class ItemsDTO implements Serializable {
    private String uniqueId;
    private String id;
    private String productId;
    private String ean;
    private Integer quantity;
    private String seller;
    private String name;
    private String refId;
    private Integer price;
    private Integer listPrice;
    private Integer manualPrice;
    private String sellerSku;
    private Integer commission;
    private Integer tax;
    private String measurementUnit;
    private Double unitMultiplier;
    private Integer sellingPrice;
    private Boolean isGift;
    private Integer shippingPrice;
    private Integer rewardValue;
    private String taxCode;
    private Integer costPrice;
}
