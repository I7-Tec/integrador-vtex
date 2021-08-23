package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;
import java.util.Date;

public class FixedPricesDTO implements Serializable {

    private String tradePolicyId;
    private Float value;
    private String listPrice;
    private Integer minQuantity;
    private Date dateRange[];
    private String dateRangefrom; // Validity start Date
    private String dateRangeto; // Validity end Date

    public String getTradePolicyId() {
        return tradePolicyId;
    }

    public void setTradePolicyId(String tradePolicyId) {
        this.tradePolicyId = tradePolicyId;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public String getListPrice() {
        return listPrice;
    }

    public void setListPrice(String listPrice) {
        this.listPrice = listPrice;
    }

    public Integer getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(Integer minQuantity) {
        this.minQuantity = minQuantity;
    }

    public Date[] getDateRange() {
        return dateRange;
    }

    public void setDateRange(Date[] dateRange) {
        this.dateRange = dateRange;
    }

    public String getDateRangefrom() {
        return dateRangefrom;
    }

    public void setDateRangefrom(String dateRangefrom) {
        this.dateRangefrom = dateRangefrom;
    }

    public String getDateRangeto() {
        return dateRangeto;
    }

    public void setDateRangeto(String dateRangeto) {
        this.dateRangeto = dateRangeto;
    }

}
