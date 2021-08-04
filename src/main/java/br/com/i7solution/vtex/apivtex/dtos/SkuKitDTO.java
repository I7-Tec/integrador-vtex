package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class SkuKitDTO implements Serializable {

	private Integer id;
	private Integer stockKeepingUnitParent;
	private Integer stockKeepingUnitId;
	private Integer quantity;
	private Double unitPrice;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStockKeepingUnitParent() {
		return stockKeepingUnitParent;
	}

	public void setStockKeepingUnitParent(Integer stockKeepingUnitParent) {
		this.stockKeepingUnitParent = stockKeepingUnitParent;
	}

	public Integer getStockKeepingUnitId() {
		return stockKeepingUnitId;
	}

	public void setStockKeepingUnitId(Integer stockKeepingUnitId) {
		this.stockKeepingUnitId = stockKeepingUnitId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

}
