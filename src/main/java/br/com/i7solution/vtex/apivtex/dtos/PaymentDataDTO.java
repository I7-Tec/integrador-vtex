package br.com.i7solution.vtex.apivtex.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class PaymentDataDTO implements Serializable {
	private TransactionsDTO[] transactions;
}
