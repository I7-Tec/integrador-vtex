package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class SkuAttachmentsDTO implements Serializable {

	private String id;
	private String name;
	private String keys[];
	private Boolean isActive;
	private Boolean isRequired;
	private SkuAttachmentsFieldsDTO skuAttachmentsFields[];

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getKeys() {
		return keys;
	}

	public void setKeys(String[] keys) {
		this.keys = keys;
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

	public SkuAttachmentsFieldsDTO[] getSkuAttachmentsFields() {
		return skuAttachmentsFields;
	}

	public void setSkuAttachmentsFields(SkuAttachmentsFieldsDTO[] skuAttachmentsFields) {
		this.skuAttachmentsFields = skuAttachmentsFields;
	}

}
