package br.com.i7solution.vtex.apivtex.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class InventoryGetDTO implements Serializable {
    private String skuId;
    private SkuInventoryDTO[] balance;
}
