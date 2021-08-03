package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class StorePreferencesDataDTO implements Serializable{
	
	private String	countryCode;
	private String	currencyCode;
	private CurrencyFormatInfoDTO currencyFormatInfo[];
	private String	currencySymbol;
	private String	timeZone;
	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public CurrencyFormatInfoDTO[] getCurrencyFormatInfo() {
		return currencyFormatInfo;
	}
	public void setCurrencyFormatInfo(CurrencyFormatInfoDTO[] currencyFormatInfo) {
		this.currencyFormatInfo = currencyFormatInfo;
	}
	public String getCurrencySymbol() {
		return currencySymbol;
	}
	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}
	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	
	

}
