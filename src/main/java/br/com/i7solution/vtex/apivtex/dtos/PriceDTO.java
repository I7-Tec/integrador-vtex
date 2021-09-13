package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class PriceDTO implements Serializable {
    private Integer markup;
    private Double listPrice;
    private Double basePrice;
    private Double costPrice;

    public Integer getMarkup() {
        return markup;
    }

    public void setMarkup(Integer markup) {
        this.markup = markup;
    }

    public Double getListPrice() {
        return listPrice;
    }

    public void setListPrice(Double listPrice) {
        this.listPrice = listPrice;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    @Override
    public String toString() {
        return "PriceDTO{" +
                "markup:" + markup +
                ", listPrice:" + listPrice +
                ", basePrice:" + basePrice +
                ", costPrice:" + costPrice +
                '}';
    }
}
