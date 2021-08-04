package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class SubcollectionDataDTO implements Serializable {

	private Integer subCollectionId;
	private Integer skuId;

	public Integer getSubCollectionId() {
		return subCollectionId;
	}

	public void setSubCollectionId(Integer subCollectionId) {
		this.subCollectionId = subCollectionId;
	}

	public Integer getSkuId() {
		return skuId;
	}

	public void setSkuId(Integer skuId) {
		this.skuId = skuId;
	}

}
