package br.com.i7solution.vtex.apivtex.dtos;

import java.util.Date;

public class PaymentsDTO {

	private String id;
	private String paymentSystem;
	private String paymentSystemName;
	private Double value;
	private Integer installments;
	private Double referenceValue;
	private String cardHolder;
	private String firstDigits;
	private String lastDigits;
	private String url;
	private String giftCardId;
	private String giftCardName;
	private String giftCardCaption;
	private String redemptionCode;
	private String group;
	private String tid;
	private Date dueDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPaymentSystem() {
		return paymentSystem;
	}

	public void setPaymentSystem(String paymentSystem) {
		this.paymentSystem = paymentSystem;
	}

	public String getPaymentSystemName() {
		return paymentSystemName;
	}

	public void setPaymentSystemName(String paymentSystemName) {
		this.paymentSystemName = paymentSystemName;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Integer getInstallments() {
		return installments;
	}

	public void setInstallments(Integer installments) {
		this.installments = installments;
	}

	public Double getReferenceValue() {
		return referenceValue;
	}

	public void setReferenceValue(Double referenceValue) {
		this.referenceValue = referenceValue;
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	public String getFirstDigits() {
		return firstDigits;
	}

	public void setFirstDigits(String firstDigits) {
		this.firstDigits = firstDigits;
	}

	public String getLastDigits() {
		return lastDigits;
	}

	public void setLastDigits(String lastDigits) {
		this.lastDigits = lastDigits;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getGiftCardId() {
		return giftCardId;
	}

	public void setGiftCardId(String giftCardId) {
		this.giftCardId = giftCardId;
	}

	public String getGiftCardName() {
		return giftCardName;
	}

	public void setGiftCardName(String giftCardName) {
		this.giftCardName = giftCardName;
	}

	public String getGiftCardCaption() {
		return giftCardCaption;
	}

	public void setGiftCardCaption(String giftCardCaption) {
		this.giftCardCaption = giftCardCaption;
	}

	public String getRedemptionCode() {
		return redemptionCode;
	}

	public void setRedemptionCode(String redemptionCode) {
		this.redemptionCode = redemptionCode;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

}
