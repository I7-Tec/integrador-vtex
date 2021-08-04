package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class AdditionalInfoDTO implements Serializable {

	private String brandName;
	private String brandId;
	private String categoriesIds;
	private String productClusterId;
	private String commercialConditionId;
	private DimensionDTO dimension[];
	private String offeringInfo;
	private String offeringType;
	private String offeringTypeId;

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getCategoriesIds() {
		return categoriesIds;
	}

	public void setCategoriesIds(String categoriesIds) {
		this.categoriesIds = categoriesIds;
	}

	public String getProductClusterId() {
		return productClusterId;
	}

	public void setProductClusterId(String productClusterId) {
		this.productClusterId = productClusterId;
	}

	public String getCommercialConditionId() {
		return commercialConditionId;
	}

	public void setCommercialConditionId(String commercialConditionId) {
		this.commercialConditionId = commercialConditionId;
	}

	public DimensionDTO[] getDimension() {
		return dimension;
	}

	public void setDimension(DimensionDTO[] dimension) {
		this.dimension = dimension;
	}

	public String getOfferingInfo() {
		return offeringInfo;
	}

	public void setOfferingInfo(String offeringInfo) {
		this.offeringInfo = offeringInfo;
	}

	public String getOfferingType() {
		return offeringType;
	}

	public void setOfferingType(String offeringType) {
		this.offeringType = offeringType;
	}

	public String getOfferingTypeId() {
		return offeringTypeId;
	}

	public void setOfferingTypeId(String offeringTypeId) {
		this.offeringTypeId = offeringTypeId;
	}

}
