package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

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

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExchangeReturnPolicy() {
		return exchangeReturnPolicy;
	}

	public void setExchangeReturnPolicy(String exchangeReturnPolicy) {
		this.exchangeReturnPolicy = exchangeReturnPolicy;
	}

	public String getDelivertPolicy() {
		return delivertPolicy;
	}

	public void setDelivertPolicy(String delivertPolicy) {
		this.delivertPolicy = delivertPolicy;
	}

	public Boolean getUseHybridPaymentOptions() {
		return useHybridPaymentOptions;
	}

	public void setUseHybridPaymentOptions(Boolean useHybridPaymentOptions) {
		this.useHybridPaymentOptions = useHybridPaymentOptions;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecurityPrivacyPolicy() {
		return securityPrivacyPolicy;
	}

	public void setSecurityPrivacyPolicy(String securityPrivacyPolicy) {
		this.securityPrivacyPolicy = securityPrivacyPolicy;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCscIdentification() {
		return cscIdentification;
	}

	public void setCscIdentification(String cscIdentification) {
		this.cscIdentification = cscIdentification;
	}

	public String getArchiveId() {
		return archiveId;
	}

	public void setArchiveId(String archiveId) {
		this.archiveId = archiveId;
	}

	public String getUrlLogo() {
		return urlLogo;
	}

	public void setUrlLogo(String urlLogo) {
		this.urlLogo = urlLogo;
	}

	public Float getProductComissionPercentage() {
		return productComissionPercentage;
	}

	public void setProductComissionPercentage(Float productComissionPercentage) {
		this.productComissionPercentage = productComissionPercentage;
	}

	public Float getFreightComissiionPercentage() {
		return freightComissiionPercentage;
	}

	public void setFreightComissiionPercentage(Float freightComissiionPercentage) {
		this.freightComissiionPercentage = freightComissiionPercentage;
	}

	public String getCategoryCommissionPercentage() {
		return categoryCommissionPercentage;
	}

	public void setCategoryCommissionPercentage(String categoryCommissionPercentage) {
		this.categoryCommissionPercentage = categoryCommissionPercentage;
	}

	public String getFulfillEndpoint() {
		return fulfillEndpoint;
	}

	public void setFulfillEndpoint(String fulfillEndpoint) {
		this.fulfillEndpoint = fulfillEndpoint;
	}

	public String getCatalogSystemEndpoint() {
		return catalogSystemEndpoint;
	}

	public void setCatalogSystemEndpoint(String catalogSystemEndpoint) {
		this.catalogSystemEndpoint = catalogSystemEndpoint;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getFulfillmentSellerId() {
		return fulfillmentSellerId;
	}

	public void setFulfillmentSellerId(String fulfillmentSellerId) {
		this.fulfillmentSellerId = fulfillmentSellerId;
	}

	public Integer getSellerType() {
		return sellerType;
	}

	public void setSellerType(Integer sellerType) {
		this.sellerType = sellerType;
	}

	public Boolean getIsBetterScope() {
		return isBetterScope;
	}

	public void setIsBetterScope(Boolean isBetterScope) {
		this.isBetterScope = isBetterScope;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

}
