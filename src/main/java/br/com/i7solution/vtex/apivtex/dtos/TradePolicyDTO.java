package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class TradePolicyDTO implements Serializable {

	private String accountName;
	private String environment;
	private Integer productId;
	private Integer tradePolicyId;

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getTradePolicyId() {
		return tradePolicyId;
	}

	public void setTradePolicyId(Integer tradePolicyId) {
		this.tradePolicyId = tradePolicyId;
	}

}
