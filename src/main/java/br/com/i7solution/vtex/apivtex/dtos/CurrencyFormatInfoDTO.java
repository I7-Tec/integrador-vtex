package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class CurrencyFormatInfoDTO implements Serializable {

	private Integer currencyDecimalDigits;
	private String currencyDecimalSeparator;
	private String currencyGroupSeparator;
	private Integer currencyGroupSize;
	private Boolean startsWithCurrencySymbol;
	private Integer currencyLocale;

	public Integer getCurrencyDecimalDigits() {
		return currencyDecimalDigits;
	}

	public void setCurrencyDecimalDigits(Integer currencyDecimalDigits) {
		this.currencyDecimalDigits = currencyDecimalDigits;
	}

	public String getCurrencyDecimalSeparator() {
		return currencyDecimalSeparator;
	}

	public void setCurrencyDecimalSeparator(String currencyDecimalSeparator) {
		this.currencyDecimalSeparator = currencyDecimalSeparator;
	}

	public String getCurrencyGroupSeparator() {
		return currencyGroupSeparator;
	}

	public void setCurrencyGroupSeparator(String currencyGroupSeparator) {
		this.currencyGroupSeparator = currencyGroupSeparator;
	}

	public Integer getCurrencyGroupSize() {
		return currencyGroupSize;
	}

	public void setCurrencyGroupSize(Integer currencyGroupSize) {
		this.currencyGroupSize = currencyGroupSize;
	}

	public Boolean getStartsWithCurrencySymbol() {
		return startsWithCurrencySymbol;
	}

	public void setStartsWithCurrencySymbol(Boolean startsWithCurrencySymbol) {
		this.startsWithCurrencySymbol = startsWithCurrencySymbol;
	}

	public Integer getCurrencyLocale() {
		return currencyLocale;
	}

	public void setCurrencyLocale(Integer currencyLocale) {
		this.currencyLocale = currencyLocale;
	}

}
