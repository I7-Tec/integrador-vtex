package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;
import java.util.Date;

public class InvoiceDataDTO implements Serializable {

	private Date date;
	private String orderId;
	private String receipt;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

}
