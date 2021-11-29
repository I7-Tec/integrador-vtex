package br.com.i7solution.vtex.apivtex.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class MarketplaceDTO implements Serializable {
	private String baseURL;
	private String isCertified;
	private String name;
}
