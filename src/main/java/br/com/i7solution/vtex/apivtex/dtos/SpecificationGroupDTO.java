package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class SpecificationGroupDTO implements Serializable {

	private Integer categoryId;
	private Integer id;
	private String name;
	private Integer position;

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

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

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

}
