package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class SimilarCategoryDTO implements Serializable {

	private Integer productId;
	private Integer categoryId;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

}
