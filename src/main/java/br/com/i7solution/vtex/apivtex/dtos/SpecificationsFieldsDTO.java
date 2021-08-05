package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class SpecificationsFieldsDTO implements Serializable {

	private String name;
	private Integer categoryId;
	private Integer fieldId;
	private Boolean isActive;
	private Boolean isRequired;
	private Integer fieldTypeId;
	private Integer fieldValueId;
	private String fieldTypeName;
	private String description;
	private Boolean isStockKeepingUnit;
	private Boolean isFilter;
	private Boolean isOnProductDetails;
	private Integer position;
	private Boolean isWizard;
	private Boolean isTopMenuLinkActive;
	private Boolean isSideMenuLinkActive;
	private String defaultValue;
	private Integer fieldGroupId;
	private String fieldGroupName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getFieldId() {
		return fieldId;
	}

	public void setFieldId(Integer fieldId) {
		this.fieldId = fieldId;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsRequired() {
		return isRequired;
	}

	public void setIsRequired(Boolean isRequired) {
		this.isRequired = isRequired;
	}

	public Integer getFieldTypeId() {
		return fieldTypeId;
	}

	public void setFieldTypeId(Integer fieldTypeId) {
		this.fieldTypeId = fieldTypeId;
	}

	public Integer getFieldValueId() {
		return fieldValueId;
	}

	public void setFieldValueId(Integer fieldValueId) {
		this.fieldValueId = fieldValueId;
	}

	public String getFieldTypeName() {
		return fieldTypeName;
	}

	public void setFieldTypeName(String fieldTypeName) {
		this.fieldTypeName = fieldTypeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsStockKeepingUnit() {
		return isStockKeepingUnit;
	}

	public void setIsStockKeepingUnit(Boolean isStockKeepingUnit) {
		this.isStockKeepingUnit = isStockKeepingUnit;
	}

	public Boolean getIsFilter() {
		return isFilter;
	}

	public void setIsFilter(Boolean isFilter) {
		this.isFilter = isFilter;
	}

	public Boolean getIsOnProductDetails() {
		return isOnProductDetails;
	}

	public void setIsOnProductDetails(Boolean isOnProductDetails) {
		this.isOnProductDetails = isOnProductDetails;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Boolean getIsWizard() {
		return isWizard;
	}

	public void setIsWizard(Boolean isWizard) {
		this.isWizard = isWizard;
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

	public Integer getFieldGroupId() {
		return fieldGroupId;
	}

	public void setFieldGroupId(Integer fieldGroupId) {
		this.fieldGroupId = fieldGroupId;
	}

	public String getFieldGroupName() {
		return fieldGroupName;
	}

	public void setFieldGroupName(String fieldGroupName) {
		this.fieldGroupName = fieldGroupName;
	}

}
