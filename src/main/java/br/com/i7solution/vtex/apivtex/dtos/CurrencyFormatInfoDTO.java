package br.com.i7solution.vtex.apivtex.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class CurrencyFormatInfoDTO implements Serializable {
    @JsonProperty("CurrencyDecimalDigits")
    private Integer currencyDecimalDigits;
    @JsonProperty("CurrencyDecimalSeparator")
    private String currencyDecimalSeparator;
    @JsonProperty("CurrencyGroupSeparator")
    private String currencyGroupSeparator;
    @JsonProperty("CurrencyGroupSize")
    private Integer currencyGroupSize;
    @JsonProperty("StartsWithCurrencySymbol")
    private Boolean startsWithCurrencySymbol;
}
