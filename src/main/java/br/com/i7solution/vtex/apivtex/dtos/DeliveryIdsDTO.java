package br.com.i7solution.vtex.apivtex.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class DeliveryIdsDTO implements Serializable {
    private String courierId;
    private String courierName;
    private String dockId;
    private Integer quantity;
    private String warehouseId;
    private String accountCarrierName;
}
