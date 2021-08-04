package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;
import java.util.Date;

public class CollectionDTO implements Serializable {

	private Integer id;
	private String name;
	private String description;
	private Boolean isSearchable;
	private String highlight;
	private Date dateFrom;
	private Date dateTo;
	private Integer totalProducts;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsSearchable() {
		return isSearchable;
	}

	public void setIsSearchable(Boolean isSearchable) {
		this.isSearchable = isSearchable;
	}

	public String getHighlight() {
		return highlight;
	}

	public void setHighlight(String highlight) {
		this.highlight = highlight;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public Integer getTotalProducts() {
		return totalProducts;
	}

	public void setTotalProducts(Integer totalProducts) {
		this.totalProducts = totalProducts;
	}

}
