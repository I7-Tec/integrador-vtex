package br.com.i7solution.vtex.apivtex.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class SellersDTO implements Serializable {
	private String id;
	private String name;
	private String logo;
	private String sellerId;
	private String email;
	private String description;
	private String exchangeReturnPolicy;
	private String delivertPolicy;
	private Boolean useHybridPaymentOptions;
	private String username;
	private String password;
	private String securityPrivacyPolicy;
	private String cnpj;
	private String cscIdentification;
	private String archiveId;
	private String urlLogo;
	private Float productComissionPercentage;
	private Float freightComissiionPercentage;
	private String categoryCommissionPercentage;
	private String fulfillEndpoint;
	private String catalogSystemEndpoint;
	private Boolean isActive;
	private String merchantName;
	private String fulfillmentSellerId;
	private Integer sellerType;
	private Boolean isBetterScope;
}
