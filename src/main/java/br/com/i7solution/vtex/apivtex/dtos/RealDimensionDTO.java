package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class RealDimensionDTO implements Serializable {

	private Double realCubicWeight;
	private Double realHeight;
	private Double realLength;
	private Double realWeight;
	private Double realWidth;

	public Double getRealCubicWeight() {
		return realCubicWeight;
	}

	public void setRealCubicWeight(Double realCubicWeight) {
		this.realCubicWeight = realCubicWeight;
	}

	public Double getRealHeight() {
		return realHeight;
	}

	public void setRealHeight(Double realHeight) {
		this.realHeight = realHeight;
	}

	public Double getRealLength() {
		return realLength;
	}

	public void setRealLength(Double realLength) {
		this.realLength = realLength;
	}

	public Double getRealWeight() {
		return realWeight;
	}

	public void setRealWeight(Double realWeight) {
		this.realWeight = realWeight;
	}

	public Double getRealWidth() {
		return realWidth;
	}

	public void setRealWidth(Double realWidth) {
		this.realWidth = realWidth;
	}

}
