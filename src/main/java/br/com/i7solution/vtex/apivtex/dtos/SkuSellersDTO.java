package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class SkuSellersDTO implements Serializable {

	private Integer sellerId;
	private Integer stockKeepingUnitId;
	private Integer sellerStockKeepingUnitId;
	private Boolean isActive;
	private Double freightComissionPercentage;
	private Double productComissionPercentage;

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public Integer getStockKeepingUnitId() {
		return stockKeepingUnitId;
	}

	public void setStockKeepingUnitId(Integer stockKeepingUnitId) {
		this.stockKeepingUnitId = stockKeepingUnitId;
	}

	public Integer getSellerStockKeepingUnitId() {
		return sellerStockKeepingUnitId;
	}

	public void setSellerStockKeepingUnitId(Integer sellerStockKeepingUnitId) {
		this.sellerStockKeepingUnitId = sellerStockKeepingUnitId;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Double getFreightComissionPercentage() {
		return freightComissionPercentage;
	}

	public void setFreightComissionPercentage(Double freightComissionPercentage) {
		this.freightComissionPercentage = freightComissionPercentage;
	}

	public Double getProductComissionPercentage() {
		return productComissionPercentage;
	}

	public void setProductComissionPercentage(Double productComissionPercentage) {
		this.productComissionPercentage = productComissionPercentage;
	}

}
