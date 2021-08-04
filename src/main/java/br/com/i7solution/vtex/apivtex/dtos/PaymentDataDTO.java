package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class PaymentDataDTO implements Serializable {

	private TransactionsDTO transactions[];

	public TransactionsDTO[] getTransactions() {
		return transactions;
	}

	public void setTransactions(TransactionsDTO transactions[]) {
		this.transactions = transactions;
	}
}
