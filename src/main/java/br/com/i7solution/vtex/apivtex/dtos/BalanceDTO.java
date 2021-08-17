package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class BalanceDTO implements Serializable {

	private String warehouseId;
	private String WarehouseName;
	private Double totalQuantity;
	private Double reservedQuantity;
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

	public Double getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Double totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public Double getReservedQuantity() {
		return reservedQuantity;
	}

	public void setReservedQuantity(Double reservedQuantity) {
		this.reservedQuantity = reservedQuantity;
	}

	public boolean isHasUnlimitedQuantity() {
		return hasUnlimitedQuantity;
	}

	public void setHasUnlimitedQuantity(boolean hasUnlimitedQuantity) {
		this.hasUnlimitedQuantity = hasUnlimitedQuantity;
	}

}
