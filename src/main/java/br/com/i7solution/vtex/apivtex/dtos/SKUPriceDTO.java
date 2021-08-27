package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class SKUPriceDTO implements Serializable {

	private String itemId; // skuId
	private Double price;
	private Double listPrice;
	private Double costPrice;
	private Double markup;
	private Double basePrice;
	private FixedPricesDTO fixedPrices[];

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Double getListPrice() {
		return listPrice;
	}

	public void setListPrice(Double listPrice) {
		this.listPrice = listPrice;
	}

	public Double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}

	public Double getMarkup() {
		return markup;
	}

	public void setMarkup(Double markup) {
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
