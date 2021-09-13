package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;
import java.util.Date;

public class SkuInclusaoDTO implements Serializable {

    private Long Id ;
    private Long ProductId ;
    private boolean IsActive;
    private String Name;
    private String RefId;
    private Double PackagedHeight;
    private Double PackagedLength;
    private Double PackagedWidth;
    private Double PackagedWeightKg;
    private Double Height;
    private Double Length;
    private Double Width;
    private Double WeightKg;
    private Double CubicWeight;
    private boolean IsKit;
    private Date CreationDate;
    private Double RewardValue;
    private String EstimatedDateArrival;
    private String ManufacturerCode;
    private Integer CommercialConditionId;
    private String MeasurementUnit;
    private Double UnitMultiplier;
    private String ModalType;
    private boolean KitItensSellApart;
    private Double HeighCubicWeightt;

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

    public Integer getCommercialConditionId() {
        return CommercialConditionId;
    }

    public void setCommercialConditionId(Integer commercialConditionId) {
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

    public Double getHeighCubicWeightt() {
        return HeighCubicWeightt;
    }

    public void setHeighCubicWeightt(Double heighCubicWeightt) {
        HeighCubicWeightt = heighCubicWeightt;
    }

    @Override
    public String toString() {
        return "SkuInclusaoDTO{" +
                "Id:" + Id +
                ", ProductId:" + ProductId +
                ", IsActive:" + IsActive +
                ", Name:'" + Name + '\'' +
                ", RefId:'" + RefId + '\'' +
                ", PackagedHeight:" + PackagedHeight +
                ", PackagedLength:" + PackagedLength +
                ", PackagedWidth:" + PackagedWidth +
                ", PackagedWeightKg:" + PackagedWeightKg +
                ", Height:" + Height +
                ", Length:" + Length +
                ", Width:" + Width +
                ", WeightKg:" + WeightKg +
                ", CubicWeight:" + CubicWeight +
                ", IsKit:" + IsKit +
                ", CreationDate:" + CreationDate +
                ", RewardValue:" + RewardValue +
                ", EstimatedDateArrival:'" + EstimatedDateArrival + '\'' +
                ", ManufacturerCode:'" + ManufacturerCode + '\'' +
                ", CommercialConditionId:" + CommercialConditionId +
                ", MeasurementUnit:'" + MeasurementUnit + '\'' +
                ", UnitMultiplier:" + UnitMultiplier +
                ", ModalType:'" + ModalType + '\'' +
                ", KitItensSellApart:" + KitItensSellApart +
                ", HeighCubicWeightt:" + HeighCubicWeightt +
                '}';
    }
}
