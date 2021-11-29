package br.com.i7solution.vtex.apivtex.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class TransactionsDTO implements Serializable {
	private Boolean isActive;
	private String transactionId;
	private String merchantName;
	private PaymentsDTO[] payments;
}
