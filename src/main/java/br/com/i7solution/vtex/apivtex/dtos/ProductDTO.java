package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class ProductDTO implements Serializable {

	private Integer id;
	private String name;
	private Integer departmentId;
	private Integer categoryId;
	private Integer brandId;
	private String linkId;
	private String refId;
	private Boolean isVisible;
	private String description;
	private String descriptionShort;
	private String releaseDate;
	private String keyWords;
	private String title;
	private Boolean isActive;
	private String taxCode;
	private String metaTagDescription;
	private Integer supplierId;
	private Boolean showWithoutStock;
	private Integer listStoreId[];
	private String adWordsRemarketingCode;
	private String lomadeeCampaignCode;
	private Integer store ;
    

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public String getLinkId() {
		return linkId;
	}

	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public Boolean getIsVisible() {
		return isVisible;
	}

	public void setIsVisible(Boolean isVisible) {
		this.isVisible = isVisible;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescriptionShort() {
		return descriptionShort;
	}

	public void setDescriptionShort(String descriptionShort) {
		this.descriptionShort = descriptionShort;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public String getMetaTagDescription() {
		return metaTagDescription;
	}

	public void setMetaTagDescription(String metaTagDescription) {
		this.metaTagDescription = metaTagDescription;
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public Boolean getShowWithoutStock() {
		return showWithoutStock;
	}

	public void setShowWithoutStock(Boolean showWithoutStock) {
		this.showWithoutStock = showWithoutStock;
	}

	public Integer[] getListStoreId() {
		return listStoreId;
	}

	public void setListStoreId(Integer[] listStoreId) {
		this.listStoreId = listStoreId;
	}

	public String getAdWordsRemarketingCode() {
		return adWordsRemarketingCode;
	}

	public void setAdWordsRemarketingCode(String adWordsRemarketingCode) {
		this.adWordsRemarketingCode = adWordsRemarketingCode;
	}

	public String getLomadeeCampaignCode() {
		return lomadeeCampaignCode;
	}

	public void setLomadeeCampaignCode(String lomadeeCampaignCode) {
		this.lomadeeCampaignCode = lomadeeCampaignCode;
	}

	public Integer getStore() {
		return store;
	}

	public void setStore(Integer store) {
		this.store = store;
	}

}
