package br.com.i7solution.vtex.apivtex.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.File;
import java.io.Serializable;

@Data
public class SkuFileDTO implements Serializable {
	@JsonProperty("Id")
	private Long id;
	@JsonProperty("ArchiveId")
	private Long archiveId;
	@JsonProperty("SkuId")
	private Long skuId;
	@JsonProperty("Name")
	private String name;
	@JsonProperty("IsMain")
	private Boolean isMain;
	@JsonProperty("Label")
	private String label;
	@JsonProperty("Url")
	private String url;
	@JsonProperty("Text")
	private String text;
//	@JsonProperty("Image file")
//	private byte[] image;
}
