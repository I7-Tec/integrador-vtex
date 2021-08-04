package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class SkuServiceValueDTO implements Serializable {

	private Integer skuServiceTypeId;
	private String name;
	private Float value;
	private Float cost;

	public Integer getSkuServiceTypeId() {
		return skuServiceTypeId;
	}

	public void setSkuServiceTypeId(Integer skuServiceTypeId) {
		this.skuServiceTypeId = skuServiceTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

}
