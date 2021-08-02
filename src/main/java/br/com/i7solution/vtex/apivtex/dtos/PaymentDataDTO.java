package br.com.i7solution.vtex.apivtex.dtos;

public class PaymentDataDTO {

	private TransactionsDTO transactions[] ;

	public TransactionsDTO[] getTransactions() {
		return transactions;
	}

	public void setTransactions(TransactionsDTO transactions[]) {
		this.transactions = transactions;
	}
}
