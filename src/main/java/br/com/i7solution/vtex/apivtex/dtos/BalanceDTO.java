package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class BalanceDTO implements Serializable {

    private String warehouseId;
    private String WarehouseName;
    private Long totalQuantity;
    private Long reservedQuantity;
    private boolean hasUnlimitedQuantity;

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseName() {
        return WarehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        WarehouseName = warehouseName;
    }

    public Long getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Long totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Long getReservedQuantity() {
        return reservedQuantity;
    }

    public void setReservedQuantity(Long reservedQuantity) {
        this.reservedQuantity = reservedQuantity;
    }

    public boolean isHasUnlimitedQuantity() {
        return hasUnlimitedQuantity;
    }

    public void setHasUnlimitedQuantity(boolean hasUnlimitedQuantity) {
        this.hasUnlimitedQuantity = hasUnlimitedQuantity;
    }

}
