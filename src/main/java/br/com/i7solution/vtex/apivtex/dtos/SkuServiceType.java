package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class SkuServiceType implements Serializable {

	private String name;
	private Boolean isActive;
	private Boolean showOnProductFront;
	private Boolean showOnCartFront;
	private Boolean showOnAttachmentFront;
	private Boolean showOnFileUpload;
	private Boolean isGiftCard;
	private Boolean isRequired;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getShowOnProductFront() {
		return showOnProductFront;
	}

	public void setShowOnProductFront(Boolean showOnProductFront) {
		this.showOnProductFront = showOnProductFront;
	}

	public Boolean getShowOnCartFront() {
		return showOnCartFront;
	}

	public void setShowOnCartFront(Boolean showOnCartFront) {
		this.showOnCartFront = showOnCartFront;
	}

	public Boolean getShowOnAttachmentFront() {
		return showOnAttachmentFront;
	}

	public void setShowOnAttachmentFront(Boolean showOnAttachmentFront) {
		this.showOnAttachmentFront = showOnAttachmentFront;
	}

	public Boolean getShowOnFileUpload() {
		return showOnFileUpload;
	}

	public void setShowOnFileUpload(Boolean showOnFileUpload) {
		this.showOnFileUpload = showOnFileUpload;
	}

	public Boolean getIsGiftCard() {
		return isGiftCard;
	}

	public void setIsGiftCard(Boolean isGiftCard) {
		this.isGiftCard = isGiftCard;
	}

	public Boolean getIsRequired() {
		return isRequired;
	}

	public void setIsRequired(Boolean isRequired) {
		this.isRequired = isRequired;
	}

}
