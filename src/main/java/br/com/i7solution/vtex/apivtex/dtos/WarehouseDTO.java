package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class WarehouseDTO implements Serializable {

	private String id;
	private String name;
	private WarehouseDocksDTO warehouseDocks[];

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

	public WarehouseDocksDTO[] getWarehouseDocks() {
		return warehouseDocks;
	}

	public void setWarehouseDocks(WarehouseDocksDTO warehouseDocks[]) {
		this.warehouseDocks = warehouseDocks;
	}

}
