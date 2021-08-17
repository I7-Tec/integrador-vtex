package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class ItemsDTO implements Serializable {

	private String uniqueId;
	private String id;
	private String productId;
	private String ean;
	private String lockId;
	private ItemAttachmentDTO itemAttachment[];
	private AttachmentsDTO attachments[];
	private String priceTags;
	private String imageURL;
	private String detailURL;
	private String components;
	private String bundleItems;
	private String params;
	private String offerings;
	private String sellerSku;
	private String ValidUnitil;
	private Double comission;
	private Double tax;
	private String preSaleDate;
	private AdditionalInfoDTO additionalInfo[];
	private String measurementUnit;
	private Integer unitMultiplier;
	private Double sellingPrice;
	private Boolean isGift;
	private String shippingPrice;
	private Integer rewardValue;
	private Integer freightCommission;
	private String priceDefinitions;
	private String taxCode;
	private String parentItemIndex;
	private String parentAssemblyBinding;

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public String getLockId() {
		return lockId;
	}

	public void setLockId(String lockId) {
		this.lockId = lockId;
	}

	public ItemAttachmentDTO[] getItemAttachment() {
		return itemAttachment;
	}

	public void setItemAttachment(ItemAttachmentDTO[] itemAttachment) {
		this.itemAttachment = itemAttachment;
	}

	public AttachmentsDTO[] getAttachments() {
		return attachments;
	}

	public void setAttachments(AttachmentsDTO[] attachments) {
		this.attachments = attachments;
	}

	public String getPriceTags() {
		return priceTags;
	}

	public void setPriceTags(String priceTags) {
		this.priceTags = priceTags;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getDetailURL() {
		return detailURL;
	}

	public void setDetailURL(String detailURL) {
		this.detailURL = detailURL;
	}

	public String getComponents() {
		return components;
	}

	public void setComponents(String components) {
		this.components = components;
	}

	public String getBundleItems() {
		return bundleItems;
	}

	public void setBundleItems(String bundleItems) {
		this.bundleItems = bundleItems;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getOfferings() {
		return offerings;
	}

	public void setOfferings(String offerings) {
		this.offerings = offerings;
	}

	public String getSellerSku() {
		return sellerSku;
	}

	public void setSellerSku(String sellerSku) {
		this.sellerSku = sellerSku;
	}

	public String getValidUnitil() {
		return ValidUnitil;
	}

	public void setValidUnitil(String validUnitil) {
		ValidUnitil = validUnitil;
	}

	public Double getComission() {
		return comission;
	}

	public void setComission(Double comission) {
		this.comission = comission;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public String getPreSaleDate() {
		return preSaleDate;
	}

	public void setPreSaleDate(String preSaleDate) {
		this.preSaleDate = preSaleDate;
	}

	public AdditionalInfoDTO[] getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(AdditionalInfoDTO[] additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getMeasurementUnit() {
		return measurementUnit;
	}

	public void setMeasurementUnit(String measurementUnit) {
		this.measurementUnit = measurementUnit;
	}

	public Integer getUnitMultiplier() {
		return unitMultiplier;
	}

	public void setUnitMultiplier(Integer unitMultiplier) {
		this.unitMultiplier = unitMultiplier;
	}

	public Double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public Boolean getIsGift() {
		return isGift;
	}

	public void setIsGift(Boolean isGift) {
		this.isGift = isGift;
	}

	public String getShippingPrice() {
		return shippingPrice;
	}

	public void setShippingPrice(String shippingPrice) {
		this.shippingPrice = shippingPrice;
	}

	public Integer getRewardValue() {
		return rewardValue;
	}

	public void setRewardValue(Integer rewardValue) {
		this.rewardValue = rewardValue;
	}

	public Integer getFreightCommission() {
		return freightCommission;
	}

	public void setFreightCommission(Integer freightCommission) {
		this.freightCommission = freightCommission;
	}

	public String getPriceDefinitions() {
		return priceDefinitions;
	}

	public void setPriceDefinitions(String priceDefinitions) {
		this.priceDefinitions = priceDefinitions;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public String getParentItemIndex() {
		return parentItemIndex;
	}

	public void setParentItemIndex(String parentItemIndex) {
		this.parentItemIndex = parentItemIndex;
	}

	public String getParentAssemblyBinding() {
		return parentAssemblyBinding;
	}

	public void setParentAssemblyBinding(String parentAssemblyBinding) {
		this.parentAssemblyBinding = parentAssemblyBinding;
	}

}
