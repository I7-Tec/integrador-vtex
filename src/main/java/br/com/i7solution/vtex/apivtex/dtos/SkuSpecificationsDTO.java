package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class SkuSpecificationsDTO implements Serializable {

	private Integer fieldId;
	private String fieldName;
	private Integer fieldValueIds[];
	private String fieldValues[];

	public Integer getFieldId() {
		return fieldId;
	}

	public void setFieldId(Integer fieldId) {
		this.fieldId = fieldId;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Integer[] getFieldValueIds() {
		return fieldValueIds;
	}

	public void setFieldValueIds(Integer[] fieldValueIds) {
		this.fieldValueIds = fieldValueIds;
	}

	public String[] getFieldValues() {
		return fieldValues;
	}

	public void setFieldValues(String[] fieldValues) {
		this.fieldValues = fieldValues;
	}

}
