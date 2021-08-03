package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class AttachmentsDTO implements Serializable {

	private Integer quantity;
	private String seller;
	private String name;
	private String refId;
	private Integer price;
	private Integer listPrice;
	private String manualPrice;

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getListPrice() {
		return listPrice;
	}

	public void setListPrice(Integer listPrice) {
		this.listPrice = listPrice;
	}

	public String getManualPrice() {
		return manualPrice;
	}

	public void setManualPrice(String manualPrice) {
		this.manualPrice = manualPrice;
	}

}
