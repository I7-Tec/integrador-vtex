package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class SpecificationValueDTO implements Serializable {

	private Integer id;
	private Integer fieldTypeId;
	private Integer categoryId;
	private Integer fieldGroupId;
	private String name;
	private String description;
	private Integer position;
	private Boolean isFilter;
	private Boolean isRequired;
	private Boolean isOnProductDetails;
	private Boolean isStockKeepingUnit;
	private Boolean isWizard;
	private Boolean isActive;
	private Boolean isTopMenuLinkActive;
	private Boolean isSideMenuLinkActive;
	private String defaultValue;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFieldTypeId() {
		return fieldTypeId;
	}

	public void setFieldTypeId(Integer fieldTypeId) {
		this.fieldTypeId = fieldTypeId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getFieldGroupId() {
		return fieldGroupId;
	}

	public void setFieldGroupId(Integer fieldGroupId) {
		this.fieldGroupId = fieldGroupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Boolean getIsFilter() {
		return isFilter;
	}

	public void setIsFilter(Boolean isFilter) {
		this.isFilter = isFilter;
	}

	public Boolean getIsRequired() {
		return isRequired;
	}

	public void setIsRequired(Boolean isRequired) {
		this.isRequired = isRequired;
	}

	public Boolean getIsOnProductDetails() {
		return isOnProductDetails;
	}

	public void setIsOnProductDetails(Boolean isOnProductDetails) {
		this.isOnProductDetails = isOnProductDetails;
	}

	public Boolean getIsStockKeepingUnit() {
		return isStockKeepingUnit;
	}

	public void setIsStockKeepingUnit(Boolean isStockKeepingUnit) {
		this.isStockKeepingUnit = isStockKeepingUnit;
	}

	public Boolean getIsWizard() {
		return isWizard;
	}

	public void setIsWizard(Boolean isWizard) {
		this.isWizard = isWizard;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsTopMenuLinkActive() {
		return isTopMenuLinkActive;
	}

	public void setIsTopMenuLinkActive(Boolean isTopMenuLinkActive) {
		this.isTopMenuLinkActive = isTopMenuLinkActive;
	}

	public Boolean getIsSideMenuLinkActive() {
		return isSideMenuLinkActive;
	}

	public void setIsSideMenuLinkActive(Boolean isSideMenuLinkActive) {
		this.isSideMenuLinkActive = isSideMenuLinkActive;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

}
