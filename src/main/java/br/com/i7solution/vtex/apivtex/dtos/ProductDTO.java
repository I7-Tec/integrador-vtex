package br.com.i7solution.vtex.apivtex.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDTO implements Serializable {
	@JsonProperty("Id")
	private Long id;
	@JsonProperty("Name")
	private String name;
	@JsonProperty("DepartmentId")
	private Long departmentId;
	@JsonProperty("CategoryId")
	private Long categoryId;
	@JsonProperty("BrandId")
	private Long brandId;
	@JsonProperty("LinkId")
	private String linkId;
	@JsonProperty("RefId")
	private String refId;
	@JsonProperty("IsVisible")
	private Boolean isVisible;
	@JsonProperty("Description")
	private String description;
	@JsonProperty("DescriptionShort")
	private String descriptionShort;
	@JsonProperty("ReleaseDate")
	private String releaseDate;
	@JsonProperty("KeyWords")
	private String keyWords;
	@JsonProperty("Title")
	private String title;
	@JsonProperty("IsActive")
	private Boolean isActive;
	@JsonProperty("TaxCode")
	private String taxCode;
	@JsonProperty("MetaTagDescription")
	private String metaTagDescription;
	@JsonProperty("SupplierId")
	private Long supplierId;
	@JsonProperty("ShowWithoutStock")
	private Boolean showWithoutStock;
	@JsonProperty("ListStoreId")
	private Integer listStoreId[];
	@JsonProperty("AdWordsRemarketingCode")
	private String adWordsRemarketingCode;
	@JsonProperty("LomadeeCampaignCode")
	private String lomadeeCampaignCode;
}
