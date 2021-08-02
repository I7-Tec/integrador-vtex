package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class TotalsDTO implements Serializable {

	private String id;
	private String name;

	private Integer value;

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

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

}
