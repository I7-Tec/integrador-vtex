package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class CategoryDTO implements Serializable {

	private Integer id;
	private String name;
	private Boolean hasChildren;
	private String url;
	private ChildrenDTO children[];

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

	public Boolean getHasChildren() {
		return hasChildren;
	}

	public void setHasChildren(Boolean hasChildren) {
		this.hasChildren = hasChildren;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ChildrenDTO[] getChildren() {
		return children;
	}

	public void setChildren(ChildrenDTO[] children) {
		this.children = children;
	}

}
