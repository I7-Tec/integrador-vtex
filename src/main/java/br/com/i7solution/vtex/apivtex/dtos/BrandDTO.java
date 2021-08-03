package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class BrandDTO implements Serializable {
   
	private Integer	id;
	private String	name;
	private Boolean	isActive;
	private String	title;
	private String	metaTagDescription;
	
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
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMetaTagDescription() {
		return metaTagDescription;
	}
	public void setMetaTagDescription(String metaTagDescription) {
		this.metaTagDescription = metaTagDescription;
	}
	
	
	
	
}
