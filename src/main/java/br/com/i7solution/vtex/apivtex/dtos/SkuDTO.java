package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class SkuDTO implements Serializable {

	private Integer id;
	private Integer productId;
	private String nameComplete;
	private String productName;
	private String productDescription;
	private String skuName;
	private Boolean isActive;
	private Boolean isTransported;
	private Boolean isInventoried;
	private Boolean isGiftCardRecharge;
	private String imageUrl;
	private String detailUrl;
	private String cSCIdentification;
	private String brandId;
	private String brandName;
    private SkuDimensionDTO dimension[];
	private RealDimensionDTO realDimension;
	private String manufacturerCode;
	private Boolean isKit;
	private String kitItems[];
	private String services[];
	private String Categories[];
	private SkuAttachmentsDTO skuAttachments[];
	private String collections[];
	private SkuSellersDTO skuSeller[];
	private Integer salesChannels[];
	private ImagesDTO images[];
	private String videos[];
	private SkuSpecificationsDTO skuSpecifications[];
	private ProductSpecificationsDTO productSpecifications[];
	private String productClustersIds;
	private String productCategoryIds;
	private String productGlobalCategoryId;
	private ProductCategoriesDTO productCategories;
	private Integer commercialConditionId;
	private Float rewardValue;
	private AlternateIdsDTO alternateIds;
	private String alternateIdValues[];
	private String estimatedDateArrival;
	private String easurementUnit;
	private Float unitMultiplier;
	private String informationSource;
	private String modalType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getNameComplete() {
		return nameComplete;
	}

	public void setNameComplete(String nameComplete) {
		this.nameComplete = nameComplete;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsTransported() {
		return isTransported;
	}

	public void setIsTransported(Boolean isTransported) {
		this.isTransported = isTransported;
	}

	public Boolean getIsInventoried() {
		return isInventoried;
	}

	public void setIsInventoried(Boolean isInventoried) {
		this.isInventoried = isInventoried;
	}

	public Boolean getIsGiftCardRecharge() {
		return isGiftCardRecharge;
	}

	public void setIsGiftCardRecharge(Boolean isGiftCardRecharge) {
		this.isGiftCardRecharge = isGiftCardRecharge;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDetailUrl() {
		return detailUrl;
	}

	public void setDetailUrl(String detailUrl) {
		this.detailUrl = detailUrl;
	}

	public String getcSCIdentification() {
		return cSCIdentification;
	}

	public void setcSCIdentification(String cSCIdentification) {
		this.cSCIdentification = cSCIdentification;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public SkuDimensionDTO[] getDimension() {
		return dimension;
	}

	public void setDimension(SkuDimensionDTO[] dimension) {
		this.dimension = dimension;
	}

	public RealDimensionDTO getRealDimension() {
		return realDimension;
	}

	public void setRealDimension(RealDimensionDTO realDimension) {
		this.realDimension = realDimension;
	}

	public String getManufacturerCode() {
		return manufacturerCode;
	}

	public void setManufacturerCode(String manufacturerCode) {
		this.manufacturerCode = manufacturerCode;
	}

	public Boolean getIsKit() {
		return isKit;
	}

	public void setIsKit(Boolean isKit) {
		this.isKit = isKit;
	}

	public String[] getKitItems() {
		return kitItems;
	}

	public void setKitItems(String[] kitItems) {
		this.kitItems = kitItems;
	}

	public String[] getServices() {
		return services;
	}

	public void setServices(String[] services) {
		this.services = services;
	}

	public String[] getCategories() {
		return Categories;
	}

	public void setCategories(String[] categories) {
		Categories = categories;
	}

	public SkuAttachmentsDTO[] getSkuAttachments() {
		return skuAttachments;
	}

	public void setSkuAttachments(SkuAttachmentsDTO[] skuAttachments) {
		this.skuAttachments = skuAttachments;
	}

	public String[] getCollections() {
		return collections;
	}

	public void setCollections(String[] collections) {
		this.collections = collections;
	}

	public SkuSellersDTO[] getSkuSeller() {
		return skuSeller;
	}

	public void setSkuSeller(SkuSellersDTO[] skuSeller) {
		this.skuSeller = skuSeller;
	}

	public Integer[] getSalesChannels() {
		return salesChannels;
	}

	public void setSalesChannels(Integer[] salesChannels) {
		this.salesChannels = salesChannels;
	}

	public ImagesDTO[] getImages() {
		return images;
	}

	public void setImages(ImagesDTO[] images) {
		this.images = images;
	}

	public String[] getVideos() {
		return videos;
	}

	public void setVideos(String[] videos) {
		this.videos = videos;
	}

	public SkuSpecificationsDTO[] getSkuSpecifications() {
		return skuSpecifications;
	}

	public void setSkuSpecifications(SkuSpecificationsDTO[] skuSpecifications) {
		this.skuSpecifications = skuSpecifications;
	}

	public ProductSpecificationsDTO[] getProductSpecifications() {
		return productSpecifications;
	}

	public void setProductSpecifications(ProductSpecificationsDTO[] productSpecifications) {
		this.productSpecifications = productSpecifications;
	}

	public String getProductClustersIds() {
		return productClustersIds;
	}

	public void setProductClustersIds(String productClustersIds) {
		this.productClustersIds = productClustersIds;
	}

	public String getProductCategoryIds() {
		return productCategoryIds;
	}

	public void setProductCategoryIds(String productCategoryIds) {
		this.productCategoryIds = productCategoryIds;
	}

	public String getProductGlobalCategoryId() {
		return productGlobalCategoryId;
	}

	public void setProductGlobalCategoryId(String productGlobalCategoryId) {
		this.productGlobalCategoryId = productGlobalCategoryId;
	}

	public ProductCategoriesDTO getProductCategories() {
		return productCategories;
	}

	public void setProductCategories(ProductCategoriesDTO productCategories) {
		this.productCategories = productCategories;
	}

	public Integer getCommercialConditionId() {
		return commercialConditionId;
	}

	public void setCommercialConditionId(Integer commercialConditionId) {
		this.commercialConditionId = commercialConditionId;
	}

	public Float getRewardValue() {
		return rewardValue;
	}

	public void setRewardValue(Float rewardValue) {
		this.rewardValue = rewardValue;
	}

	public AlternateIdsDTO getAlternateIds() {
		return alternateIds;
	}

	public void setAlternateIds(AlternateIdsDTO alternateIds) {
		this.alternateIds = alternateIds;
	}

	public String[] getAlternateIdValues() {
		return alternateIdValues;
	}

	public void setAlternateIdValues(String[] alternateIdValues) {
		this.alternateIdValues = alternateIdValues;
	}

	public String getEstimatedDateArrival() {
		return estimatedDateArrival;
	}

	public void setEstimatedDateArrival(String estimatedDateArrival) {
		this.estimatedDateArrival = estimatedDateArrival;
	}

	public String getEasurementUnit() {
		return easurementUnit;
	}

	public void setEasurementUnit(String easurementUnit) {
		this.easurementUnit = easurementUnit;
	}

	public Float getUnitMultiplier() {
		return unitMultiplier;
	}

	public void setUnitMultiplier(Float unitMultiplier) {
		this.unitMultiplier = unitMultiplier;
	}

	public String getInformationSource() {
		return informationSource;
	}

	public void setInformationSource(String informationSource) {
		this.informationSource = informationSource;
	}

	public String getModalType() {
		return modalType;
	}

	public void setModalType(String modalType) {
		this.modalType = modalType;
	}

}
