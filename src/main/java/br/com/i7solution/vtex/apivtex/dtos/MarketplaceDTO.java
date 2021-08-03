package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class MarketplaceDTO implements Serializable {

	private String baseURL;
	private String isCertified;
	private String name;

	public String getBaseURL() {
		return baseURL;
	}

	public void setBaseURL(String baseURL) {
		this.baseURL = baseURL;
	}

	public String getIsCertified() {
		return isCertified;
	}

	public void setIsCertified(String isCertified) {
		this.isCertified = isCertified;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
