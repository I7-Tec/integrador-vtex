package br.com.i7solution.vtex.apivtex.dtos;

public class TransactionsDTO {

	private Boolean isActive;
	private String transactionId;
	private String merchantName;
	private PaymentsDTO payments[];

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public PaymentsDTO[] getPayments() {
		return payments;
	}

	public void setPayments(PaymentsDTO[] payments) {
		this.payments = payments;
	}

}
