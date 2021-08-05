package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class SalesChannelDTO implements Serializable {

	private Integer id;
	private String name;
	private Boolean isActive;
	private Integer productClusterId;
	private String countryCode;
	private String cultureInfo;
	private String timeZone;
	private String currencyCode;
	private String currencySymbol;
	private String currencyLocale;

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

	public Integer getProductClusterId() {
		return productClusterId;
	}

	public void setProductClusterId(Integer productClusterId) {
		this.productClusterId = productClusterId;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCultureInfo() {
		return cultureInfo;
	}

	public void setCultureInfo(String cultureInfo) {
		this.cultureInfo = cultureInfo;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCurrencySymbol() {
		return currencySymbol;
	}

	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}

	public String getCurrencyLocale() {
		return currencyLocale;
	}

	public void setCurrencyLocale(String currencyLocale) {
		this.currencyLocale = currencyLocale;
	}

}