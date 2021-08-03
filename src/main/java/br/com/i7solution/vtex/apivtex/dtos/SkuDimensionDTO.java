package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class SkuDimensionDTO implements Serializable {

	private Double cubicweight;
	private Double height;
	private Double length;
	private Double weight;
	private Double width;

	public Double getCubicweight() {
		return cubicweight;
	}

	public void setCubicweight(Double cubicweight) {
		this.cubicweight = cubicweight;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

}
