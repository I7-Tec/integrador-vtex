package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class SkuAttachmentsFieldsDTO implements Serializable {

	private String fieldName;
	private String maxCaracters;
	private String domainValues;

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getMaxCaracters() {
		return maxCaracters;
	}

	public void setMaxCaracters(String maxCaracters) {
		this.maxCaracters = maxCaracters;
	}

	public String getDomainValues() {
		return domainValues;
	}

	public void setDomainValues(String domainValues) {
		this.domainValues = domainValues;
	}

}
