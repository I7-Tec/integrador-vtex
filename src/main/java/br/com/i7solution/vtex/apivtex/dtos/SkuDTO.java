package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;
import java.util.Date;

public class SkuDTO implements Serializable {

    private Long Id ; // SKU ID
    private Long ProductId ; //ProductId	integer	Product ID
    private Boolean IsActive; //boolean	Shows if the SKU is active. To avoid receiving a 400 - Bad Request this attribute must be false
    private String Name; //	string	SKU Name
    private String RefId; //	string	SKU RefId
    private Double PackagedHeight; //	decimal	Packaged Height
    private Double PackagedLength; //	decimal	Packaged Length
    private Double PackagedWidth; //	decimal	Packaged Width
    private Double PackagedWeightKg; //	decimal	Packaged Weight
    private Double Height; //	decimal	SKU Height
    private Double Length; //	decimal	SKU Length
    private Double Width; //	decimal	SKU Width
    private Double WeightKg;	//	SKU Weight
    private Double CubicWeight; //	decimal	Cubic Weight
    private Boolean IsKit; //	boolean	Shows if the SKU is a Kit
    private Date CreationDate; //	string	SKU Creation Date
    private Double RewardValue ; //	decimal	How much the client will get rewarded by buying the SKU
    private String EstimatedDateArrival; //	string	SKU Estimated Date Arrival
    private String ManufacturerCode; //	string	Manufacturer Code
    private Double CommercialConditionId; //	integer	Commercial Condition ID
    private String MeasurementUnit; //	string	Measurement Unit
    private Double UnitMultiplier; //	decimal	Multiplies the amount of SKUs inserted on the cart
    private String ModalType; //	string	Defines deliver model
    private Boolean KitItensSellApart; //	boolean	Defines if Kit components can be sold apart

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getProductId() {
        return ProductId;
    }

    public void setProductId(Long productId) {
        ProductId = productId;
    }

    public Boolean getActive() {
        return IsActive;
    }

    public void setActive(Boolean active) {
        IsActive = active;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRefId() {
        return RefId;
    }

    public void setRefId(String refId) {
        RefId = refId;
    }

    public Double getPackagedHeight() {
        return PackagedHeight;
    }

    public void setPackagedHeight(Double packagedHeight) {
        PackagedHeight = packagedHeight;
    }

    public Double getPackagedLength() {
        return PackagedLength;
    }

    public void setPackagedLength(Double packagedLength) {
        PackagedLength = packagedLength;
    }

    public Double getPackagedWidth() {
        return PackagedWidth;
    }

    public void setPackagedWidth(Double packagedWidth) {
        PackagedWidth = packagedWidth;
    }

    public Double getPackagedWeightKg() {
        return PackagedWeightKg;
    }

    public void setPackagedWeightKg(Double packagedWeightKg) {
        PackagedWeightKg = packagedWeightKg;
    }

    public Double getHeight() {
        return Height;
    }

    public void setHeight(Double height) {
        Height = height;
    }

    public Double getLength() {
        return Length;
    }

    public void setLength(Double length) {
        Length = length;
    }

    public Double getWidth() {
        return Width;
    }

    public void setWidth(Double width) {
        Width = width;
    }

    public Double getWeightKg() {
        return WeightKg;
    }

    public void setWeightKg(Double weightKg) {
        WeightKg = weightKg;
    }

    public Double getCubicWeight() {
        return CubicWeight;
    }

    public void setCubicWeight(Double cubicWeight) {
        CubicWeight = cubicWeight;
    }

    public Boolean getKit() {
        return IsKit;
    }

    public void setKit(Boolean kit) {
        IsKit = kit;
    }

    public Date getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(Date creationDate) {
        CreationDate = creationDate;
    }

    public Double getRewardValue() {
        return RewardValue;
    }

    public void setRewardValue(Double rewardValue) {
        RewardValue = rewardValue;
    }

    public String getEstimatedDateArrival() {
        return EstimatedDateArrival;
    }

    public void setEstimatedDateArrival(String estimatedDateArrival) {
        EstimatedDateArrival = estimatedDateArrival;
    }

    public String getManufacturerCode() {
        return ManufacturerCode;
    }

    public void setManufacturerCode(String manufacturerCode) {
        ManufacturerCode = manufacturerCode;
    }

    public Double getCommercialConditionId() {
        return CommercialConditionId;
    }

    public void setCommercialConditionId(Double commercialConditionId) {
        CommercialConditionId = commercialConditionId;
    }

    public String getMeasurementUnit() {
        return MeasurementUnit;
    }

    public void setMeasurementUnit(String measurementUnit) {
        MeasurementUnit = measurementUnit;
    }

    public Double getUnitMultiplier() {
        return UnitMultiplier;
    }

    public void setUnitMultiplier(Double unitMultiplier) {
        UnitMultiplier = unitMultiplier;
    }

    public String getModalType() {
        return ModalType;
    }

    public void setModalType(String modalType) {
        ModalType = modalType;
    }

    public Boolean getKitItensSellApart() {
        return KitItensSellApart;
    }

    public void setKitItensSellApart(Boolean kitItensSellApart) {
        KitItensSellApart = kitItensSellApart;
    }
}
