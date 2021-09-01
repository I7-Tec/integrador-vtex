package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class PriceDTO implements Serializable {

    private Long index;
    private String skuId;
    private Double price;
    private Long quantity;
    private Double listPrice;
    private Double costPrice;
    private Double markup;
    private Double basePrice;
    private String priceTable;
    private String priceValidUnit;
    private FixedPricesDTO fixedPrices[];

    public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getListPrice() {
        return listPrice;
    }

    public void setListPrice(Double listPrice) {
        this.listPrice = listPrice;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Double getMarkup() {
        return markup;
    }

    public void setMarkup(Double markup) {
        this.markup = markup;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public String getPriceTable() {
        return priceTable;
    }

    public void setPriceTable(String priceTable) {
        this.priceTable = priceTable;
    }

    public String getPriceValidUnit() {
        return priceValidUnit;
    }

    public void setPriceValidUnit(String priceValidUnit) {
        this.priceValidUnit = priceValidUnit;
    }

    public FixedPricesDTO[] getFixedPrices() {
        return fixedPrices;
    }

    public void setFixedPrices(FixedPricesDTO[] fixedPrices) {
        this.fixedPrices = fixedPrices;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
