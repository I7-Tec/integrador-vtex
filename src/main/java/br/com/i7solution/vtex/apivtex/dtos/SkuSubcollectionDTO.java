package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class SkuSubcollectionDTO implements Serializable {

	private Integer page;
	private Integer size;
	private Integer totalRows;
	private Integer totalPage;
	private SubcollectionDataDTO data[];

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public SubcollectionDataDTO[] getData() {
		return data;
	}

	public void setData(SubcollectionDataDTO[] data) {
		this.data = data;
	}

}
