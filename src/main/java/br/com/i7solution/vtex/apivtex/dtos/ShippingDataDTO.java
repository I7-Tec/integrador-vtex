package br.com.i7solution.vtex.apivtex.dtos;

public class ShippingDataDTO {

	private String id;
	private AdressDTO shippingDataAdress[];
	private LogisticsInfoDTO logisticsInfo[];
	private AdressDTO selectedAdress[];
	private String trackingHints;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public AdressDTO[] getShippingDataAdress() {
		return shippingDataAdress;
	}

	public void setShippingDataAdress(AdressDTO[] shippingDataAdress) {
		this.shippingDataAdress = shippingDataAdress;
	}

	public LogisticsInfoDTO[] getLogisticsInfo() {
		return logisticsInfo;
	}

	public void setLogisticsInfo(LogisticsInfoDTO[] logisticsInfo) {
		this.logisticsInfo = logisticsInfo;
	}

	public AdressDTO[] getSelectedAdress() {
		return selectedAdress;
	}

	public void setSelectedAdress(AdressDTO[] selectedAdress) {
		this.selectedAdress = selectedAdress;
	}

	public String getTrackingHints() {
		return trackingHints;
	}

	public void setTrackingHints(String trackingHints) {
		this.trackingHints = trackingHints;
	}

}
