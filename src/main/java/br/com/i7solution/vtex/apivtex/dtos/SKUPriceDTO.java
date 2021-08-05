package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class SKUPriceDTO implements Serializable {

	private String itemId; // skuId
	private Integer listPrice;
	private Integer costPrice;
	private Integer markup;
	private Double basePrice;
	private FixedPricesDTO fixedPrices[];

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Integer getListPrice() {
		return listPrice;
	}

	public void setListPrice(Integer listPrice) {
		this.listPrice = listPrice;
	}

	public Integer getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Integer costPrice) {
		this.costPrice = costPrice;
	}

	public Integer getMarkup() {
		return markup;
	}

	public void setMarkup(Integer markup) {
		this.markup = markup;
	}

	public Double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Double basePrice) {
		this.basePrice = basePrice;
	}

	public FixedPricesDTO[] getFixedPrices() {
		return fixedPrices;
	}

	public void setFixedPrices(FixedPricesDTO[] fixedPrices) {
		this.fixedPrices = fixedPrices;
	}

}
