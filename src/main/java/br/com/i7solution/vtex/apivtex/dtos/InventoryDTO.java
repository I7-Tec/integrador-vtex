package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class InventoryDTO implements Serializable {

    private boolean unlimitedQuantity;
    private Double quantity;

    public boolean isUnlimitedQuantity() {
        return unlimitedQuantity;
    }

    public void setUnlimitedQuantity(boolean unlimitedQuantity) {
        this.unlimitedQuantity = unlimitedQuantity;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}