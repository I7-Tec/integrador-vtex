package br.com.i7solution.vtex.apivtex.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class SkuInventoryDTO implements Serializable {
    private String warehouseId;
    private String warehouseName;
    private Double totalQuantity;
    private Double reservedQuantity;
    private String hasUnlimitedQuantity;
    private String timeToRefill;
    private String dateOfSupplyUtc;
}
