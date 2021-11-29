package br.com.i7solution.vtex.apivtex.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class ShippingDataDTO implements Serializable {
	private String id;
	private AdressDTO[] shippingDataAdress;
	private LogisticsInfoDTO[] logisticsInfo;
	private AdressDTO[] selectedAdress;
	private String trackingHints;
}
