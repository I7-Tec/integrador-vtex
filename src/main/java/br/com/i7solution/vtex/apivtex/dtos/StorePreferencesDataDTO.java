package br.com.i7solution.vtex.apivtex.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class StorePreferencesDataDTO implements Serializable {
	private String countryCode;
	private String currencyCode;
	private CurrencyFormatInfoDTO currencyFormatInfo;
	private Integer currencyLocale;
	private String currencySymbol;
	private String timeZone;
}
