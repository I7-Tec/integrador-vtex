package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;
import java.util.Date;

public class PaymentsDTO implements Serializable {

	private String id;
	private String paymentSystem;
	private String paymentSystemName;
	private Double value;
	private Integer installments;
	private Double referenceValue;
	private String cardHolder;
	private String cardNumber;
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
	private String cvv2;
    private String expireMonth;
	private String expireYear;

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

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCvv2() {
		return cvv2;
	}

	public void setCvv2(String cvv2) {
		this.cvv2 = cvv2;
	}

	public String getExpireMonth() {
		return expireMonth;
	}

	public void setExpireMonth(String expireMonth) {
		this.expireMonth = expireMonth;
	}

	public String getExpireYear() {
		return expireYear;
	}

	public void setExpireYear(String expireYear) {
		this.expireYear = expireYear;
	}

}
