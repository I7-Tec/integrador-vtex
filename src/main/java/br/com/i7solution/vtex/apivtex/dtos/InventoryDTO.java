package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class InventoryDTO implements Serializable {

	private String skuId;
	private String warehouseId;
	private String warehouseName;
	private Long totalQuantity;
	private Long reservedQuantity;
	private Boolean hasUnlimitedQuantity;

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public String getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
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

	public Boolean getHasUnlimitedQuantity() {
		return hasUnlimitedQuantity;
	}

	public void setHasUnlimitedQuantity(Boolean hasUnlimitedQuantity) {
		this.hasUnlimitedQuantity = hasUnlimitedQuantity;
	}

}
