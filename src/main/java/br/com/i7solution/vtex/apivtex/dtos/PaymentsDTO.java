package br.com.i7solution.vtex.apivtex.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
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
}
