package br.com.i7solution.vtex.apivtex.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class LogisticsInfoDTO implements Serializable {
	private Integer itemIndex;
	private String selectedSla;
	private String lockTTL;
	private Integer price;
	private Integer listPrice;
	private Integer sellingPrice;
	private String deliveryWindow;
	private String deliveryCompany;
	private String shippingEstimate;
	private Date shippingEstimateDate;
	//private String[] slas;
	private String[] shipsTo;
	private DeliveryIdsDTO[] deliveryIds;
	private String deliveryChannel;
	//private String pickupStoreInfo;
	private String addressId;
}
