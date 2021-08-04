package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

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
	private String shippingEstimateDate;
	private String slas[];
	private String shipsTo[];
	private String deliveryIds[];
	private String deliveryChannel;
	private String pickupStoreInfo;
	private String addressId;
	private String polygonName;

	public Integer getItemIndex() {
		return itemIndex;
	}

	public void setItemIndex(Integer itemIndex) {
		this.itemIndex = itemIndex;
	}

	public String getSelectedSla() {
		return selectedSla;
	}

	public void setSelectedSla(String selectedSla) {
		this.selectedSla = selectedSla;
	}

	public String getLockTTL() {
		return lockTTL;
	}

	public void setLockTTL(String lockTTL) {
		this.lockTTL = lockTTL;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getListPrice() {
		return listPrice;
	}

	public void setListPrice(Integer listPrice) {
		this.listPrice = listPrice;
	}

	public Integer getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Integer sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public String getDeliveryWindow() {
		return deliveryWindow;
	}

	public void setDeliveryWindow(String deliveryWindow) {
		this.deliveryWindow = deliveryWindow;
	}

	public String getDeliveryCompany() {
		return deliveryCompany;
	}

	public void setDeliveryCompany(String deliveryCompany) {
		this.deliveryCompany = deliveryCompany;
	}

	public String getShippingEstimate() {
		return shippingEstimate;
	}

	public void setShippingEstimate(String shippingEstimate) {
		this.shippingEstimate = shippingEstimate;
	}

	public String getShippingEstimateDate() {
		return shippingEstimateDate;
	}

	public void setShippingEstimateDate(String shippingEstimateDate) {
		this.shippingEstimateDate = shippingEstimateDate;
	}

	public String[] getSlas() {
		return slas;
	}

	public void setSlas(String[] slas) {
		this.slas = slas;
	}

	public String[] getShipsTo() {
		return shipsTo;
	}

	public void setShipsTo(String[] shipsTo) {
		this.shipsTo = shipsTo;
	}

	public String[] getDeliveryIds() {
		return deliveryIds;
	}

	public void setDeliveryIds(String[] deliveryIds) {
		this.deliveryIds = deliveryIds;
	}

	public String getDeliveryChannel() {
		return deliveryChannel;
	}

	public void setDeliveryChannel(String deliveryChannel) {
		this.deliveryChannel = deliveryChannel;
	}

	public String getPickupStoreInfo() {
		return pickupStoreInfo;
	}

	public void setPickupStoreInfo(String pickupStoreInfo) {
		this.pickupStoreInfo = pickupStoreInfo;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getPolygonName() {
		return polygonName;
	}

	public void setPolygonName(String polygonName) {
		this.polygonName = polygonName;
	}

}
