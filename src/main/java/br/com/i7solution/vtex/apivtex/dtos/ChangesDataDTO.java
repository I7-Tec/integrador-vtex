package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class ChangesDataDTO implements Serializable {

    private String reason;
    private Double discountValue;
    private Double incrementValue;
    private ItemsAddedDTO itemsAdded[];
    private ItemsRemovedDTO itemsRemovedDTO[];

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Double getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(Double discountValue) {
        this.discountValue = discountValue;
    }

    public Double getIncrementValue() {
        return incrementValue;
    }

    public void setIncrementValue(Double incrementValue) {
        this.incrementValue = incrementValue;
    }

    public ItemsAddedDTO[] getItemsAdded() {
        return itemsAdded;
    }

    public void setItemsAdded(ItemsAddedDTO[] itemsAdded) {
        this.itemsAdded = itemsAdded;
    }

    public ItemsRemovedDTO[] getItemsRemovedDTO() {
        return itemsRemovedDTO;
    }

    public void setItemsRemovedDTO(ItemsRemovedDTO[] itemsRemovedDTO) {
        this.itemsRemovedDTO = itemsRemovedDTO;
    }

}
