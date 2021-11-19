package br.com.i7solution.vtex.apivtex.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SkuDTO implements Serializable {
    @JsonProperty("Id")
    private Long Id ; // SKU ID
    @JsonProperty("ProductId")
    private Long ProductId ; //ProductId	integer	Product ID
    @JsonProperty("IsActive")
    private Boolean IsActive; //boolean	Shows if the SKU is active. To avoid receiving a 400 - Bad Request this attribute must be false
    @JsonProperty("Name")
    private String Name; //	string	SKU Name
    @JsonProperty("RefId")
    private String RefId; //	string	SKU RefId
    @JsonProperty("PackagedHeight")
    private Double PackagedHeight; //	decimal	Packaged Height
    @JsonProperty("PackagedLength")
    private Double PackagedLength; //	decimal	Packaged Length
    @JsonProperty("PackagedWidth")
    private Double PackagedWidth; //	decimal	Packaged Width
    @JsonProperty("PackagedWeightKg")
    private Double PackagedWeightKg; //	decimal	Packaged Weight
    @JsonProperty("Height")
    private Double Height; //	decimal	SKU Height
    @JsonProperty("Length")
    private Double Length; //	decimal	SKU Length
    @JsonProperty("Width")
    private Double Width; //	decimal	SKU Width
    @JsonProperty("WeightKg")
    private Double WeightKg;	//	SKU Weight
    @JsonProperty("CubicWeight")
    private Double CubicWeight; //	decimal	Cubic Weight
    @JsonProperty("IsKit")
    private Boolean IsKit; //	boolean	Shows if the SKU is a Kit
    @JsonProperty("CreationDate")
    private Date CreationDate; //	string	SKU Creation Date
    @JsonProperty("RewardValue")
    private Double RewardValue ; //	decimal	How much the client will get rewarded by buying the SKU
    @JsonProperty("EstimatedDateArrival")
    private String EstimatedDateArrival; //	string	SKU Estimated Date Arrival
    @JsonProperty("ManufacturerCode")
    private String ManufacturerCode; //	string	Manufacturer Code
    @JsonProperty("CommercialConditionId")
    private Double CommercialConditionId; //	integer	Commercial Condition ID
    @JsonProperty("MeasurementUnit")
    private String MeasurementUnit; //	string	Measurement Unit
    @JsonProperty("UnitMultiplier")
    private Double UnitMultiplier; //	decimal	Multiplies the amount of SKUs inserted on the cart
    @JsonProperty("ModalType")
    private String ModalType; //	string	Defines deliver model
    @JsonProperty("KitItensSellApart")
    private Boolean KitItensSellApart; //	boolean	Defines if Kit components can be sold apart
}
