package br.com.i7solution.vtex.apivtex.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SkuInclusaoDTO implements Serializable {
    private Long Id;
    private Long ProductId;
    private Boolean IsActive;
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
    private Boolean IsKit;
    private Date CreationDate;
    private Double RewardValue;
    private String EstimatedDateArrival;
    private String ManufacturerCode;
    private Integer CommercialConditionId;
    private String MeasurementUnit;
    private Double UnitMultiplier;
    private String ModalType;
    private Boolean KitItensSellApart;
    private Double HeighCubicWeightt;

    @Override
    public String toString() {
        return "SkuInclusaoDTO{" +
                "   \"Id\": \"" + Id + "\",\n" +
                "   \"ProductId\": \"" + ProductId + "\",\n" +
                "   \"IsActive\": \"" + IsActive + "\",\n" +
                "   \"Name\": \"" + Name + "\",\n" +
                "   \"RefId\": \"" + RefId + "\",\n" +
                "   \"PackagedHeight\": \"" + PackagedHeight + "\",\n" +
                "   \"PackagedLength\": \"" + PackagedLength + "\",\n" +
                "   \"PackagedWidth\": \"" + PackagedWidth + "\",\n" +
                "   \"PackagedWeightKg\": \"" + PackagedWeightKg + "\",\n" +
                "   \"Height\": \"" + Height + "\",\n" +
                "   \"Length\": \"" + Length + "\",\n" +
                "   \"Width\": \"" + Width + "\",\n" +
                "   \"WeightKg\": \"" + WeightKg + "\",\n" +
                "   \"CubicWeight\": \"" + CubicWeight + "\",\n" +
                "   \"IsKit\": \"" + IsKit + "\",\n" +
                "   \"CreationDate\": \"" + CreationDate + "\",\n" +
                "   \"RewardValue\": \"" + RewardValue + "\",\n" +
                "   \"EstimatedDateArrival\": \"" + EstimatedDateArrival + "\",\n" +
                "   \"ManufacturerCode\": \"" + ManufacturerCode + "\",\n" +
                "   \"CommercialConditionId\": \"" + CommercialConditionId + "\",\n" +
                "   \"MeasurementUnit\": \"" + MeasurementUnit + "\",\n" +
                "   \"UnitMultiplier\": \"" + UnitMultiplier + "\",\n" +
                "   \"ModalType\": \"" + ModalType + "\",\n" +
                "   \"KitItensSellApart\": \"" + KitItensSellApart + "\",\n" +
                "   \"HeighCubicWeightt\": \"" + HeighCubicWeightt + "\"\n" +
                '}';
    }
}
