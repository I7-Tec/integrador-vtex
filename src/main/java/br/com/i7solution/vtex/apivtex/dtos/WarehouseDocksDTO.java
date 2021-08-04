package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class WarehouseDocksDTO implements Serializable {

	private String dockId;
	private String time;
	private Float cost;

	public String getDockId() {
		return dockId;
	}

	public void setDockId(String dockId) {
		this.dockId = dockId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

}
