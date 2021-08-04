package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class RatesAndBenefitsDataDTO implements Serializable {

	private String id;
	private String rateAndBenefitsIdentifiers[];

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String[] getRateAndBenefitsIdentifiers() {
		return rateAndBenefitsIdentifiers;
	}

	public void setRateAndBenefitsIdentifiers(String[] rateAndBenefitsIdentifiers) {
		this.rateAndBenefitsIdentifiers = rateAndBenefitsIdentifiers;
	}

}
