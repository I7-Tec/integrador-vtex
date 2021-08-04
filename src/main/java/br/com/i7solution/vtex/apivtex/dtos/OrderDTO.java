package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;
import java.util.Date;

public class OrderDTO implements Serializable {

	private String emailTracked;
	private String approvedBy;
	private String cancelledBy;
	private String cancelReason;
	private String orderId;
	private String sequence;
	private String marketplaceOrderId;
	private String marketplaceServicesEndpoint;
	private String sellerOrderId;
	private String origin;
	private String affiliateId;
	private String salesChannel;
	private String merchantName;
	private String status;
	private String statusDescription;
	private Integer value;
	private String creationDate;
	private String lastChange;
	private String orderGroup;
	private TotalsDTO totals[];
	private ItemsDTO items[];
	private String marketplaceItems[];
	private ClientProfileDataDTO clientProfileData[];
	private String giftRegistryData;
	private String marketingData;
	private RatesAndBenefitsDataDTO rateAndBenefitsIdentifiers[];
	private ShippingDataDTO shippingData[];
	private PaymentDataDTO paymentData[];
	private PackageAttachmentDTO packageAttachment[];
	private SellersDTO sellers[];
	private String callCenterOperatorData;
	private String followUpEmail;
	private String lastMessage;
	private String hostname;
	private InvoiceDataDTO invoiceData[];
	private ChangesAttachmentDTO changesAttachment[];
	private String openTextField;
	private Integer roundingError;
	private String orderFormId;
	private String commercialConditionData;
	private Boolean isCompleted;
	private String customData;
	private StorePreferencesDataDTO storePreferencesData[];
	private Boolean allowCancellation;
	private Boolean allowEdition;
	private Boolean isCheckedIn;
	private MarketplaceDTO marketplace[];
	private Date authorizedDate;
	private Date invoicedDate;

	public String getEmailTracked() {
		return emailTracked;
	}

	public void setEmailTracked(String emailTracked) {
		this.emailTracked = emailTracked;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getCancelledBy() {
		return cancelledBy;
	}

	public void setCancelledBy(String cancelledBy) {
		this.cancelledBy = cancelledBy;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getMarketplaceOrderId() {
		return marketplaceOrderId;
	}

	public void setMarketplaceOrderId(String marketplaceOrderId) {
		this.marketplaceOrderId = marketplaceOrderId;
	}

	public String getMarketplaceServicesEndpoint() {
		return marketplaceServicesEndpoint;
	}

	public void setMarketplaceServicesEndpoint(String marketplaceServicesEndpoint) {
		this.marketplaceServicesEndpoint = marketplaceServicesEndpoint;
	}

	public String getSellerOrderId() {
		return sellerOrderId;
	}

	public void setSellerOrderId(String sellerOrderId) {
		this.sellerOrderId = sellerOrderId;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getAffiliateId() {
		return affiliateId;
	}

	public void setAffiliateId(String affiliateId) {
		this.affiliateId = affiliateId;
	}

	public String getSalesChannel() {
		return salesChannel;
	}

	public void setSalesChannel(String salesChannel) {
		this.salesChannel = salesChannel;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getLastChange() {
		return lastChange;
	}

	public void setLastChange(String lastChange) {
		this.lastChange = lastChange;
	}

	public String getOrderGroup() {
		return orderGroup;
	}

	public void setOrderGroup(String orderGroup) {
		this.orderGroup = orderGroup;
	}

	public TotalsDTO[] getTotals() {
		return totals;
	}

	public void setTotals(TotalsDTO[] totals) {
		this.totals = totals;
	}

	public ItemsDTO[] getItems() {
		return items;
	}

	public void setItems(ItemsDTO[] items) {
		this.items = items;
	}

	public String[] getMarketplaceItems() {
		return marketplaceItems;
	}

	public void setMarketplaceItems(String[] marketplaceItems) {
		this.marketplaceItems = marketplaceItems;
	}

	public ClientProfileDataDTO[] getClientProfileData() {
		return clientProfileData;
	}

	public void setClientProfileData(ClientProfileDataDTO[] clientProfileData) {
		this.clientProfileData = clientProfileData;
	}

	public String getGiftRegistryData() {
		return giftRegistryData;
	}

	public void setGiftRegistryData(String giftRegistryData) {
		this.giftRegistryData = giftRegistryData;
	}

	public String getMarketingData() {
		return marketingData;
	}

	public void setMarketingData(String marketingData) {
		this.marketingData = marketingData;
	}

	public RatesAndBenefitsDataDTO[] getRateAndBenefitsIdentifiers() {
		return rateAndBenefitsIdentifiers;
	}

	public void setRateAndBenefitsIdentifiers(RatesAndBenefitsDataDTO[] rateAndBenefitsIdentifiers) {
		this.rateAndBenefitsIdentifiers = rateAndBenefitsIdentifiers;
	}

	public ShippingDataDTO[] getShippingData() {
		return shippingData;
	}

	public void setShippingData(ShippingDataDTO[] shippingData) {
		this.shippingData = shippingData;
	}

	public PaymentDataDTO[] getPaymentData() {
		return paymentData;
	}

	public void setPaymentData(PaymentDataDTO[] paymentData) {
		this.paymentData = paymentData;
	}

	public PackageAttachmentDTO[] getPackageAttachment() {
		return packageAttachment;
	}

	public void setPackageAttachment(PackageAttachmentDTO[] packageAttachment) {
		this.packageAttachment = packageAttachment;
	}

	public SellersDTO[] getSellers() {
		return sellers;
	}

	public void setSellers(SellersDTO[] sellers) {
		this.sellers = sellers;
	}

	public String getCallCenterOperatorData() {
		return callCenterOperatorData;
	}

	public void setCallCenterOperatorData(String callCenterOperatorData) {
		this.callCenterOperatorData = callCenterOperatorData;
	}

	public String getFollowUpEmail() {
		return followUpEmail;
	}

	public void setFollowUpEmail(String followUpEmail) {
		this.followUpEmail = followUpEmail;
	}

	public String getLastMessage() {
		return lastMessage;
	}

	public void setLastMessage(String lastMessage) {
		this.lastMessage = lastMessage;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public InvoiceDataDTO[] getInvoiceData() {
		return invoiceData;
	}

	public void setInvoiceData(InvoiceDataDTO[] invoiceData) {
		this.invoiceData = invoiceData;
	}

	public ChangesAttachmentDTO[] getChangesAttachment() {
		return changesAttachment;
	}

	public void setChangesAttachment(ChangesAttachmentDTO[] changesAttachment) {
		this.changesAttachment = changesAttachment;
	}

	public String getOpenTextField() {
		return openTextField;
	}

	public void setOpenTextField(String openTextField) {
		this.openTextField = openTextField;
	}

	public Integer getRoundingError() {
		return roundingError;
	}

	public void setRoundingError(Integer roundingError) {
		this.roundingError = roundingError;
	}

	public String getOrderFormId() {
		return orderFormId;
	}

	public void setOrderFormId(String orderFormId) {
		this.orderFormId = orderFormId;
	}

	public String getCommercialConditionData() {
		return commercialConditionData;
	}

	public void setCommercialConditionData(String commercialConditionData) {
		this.commercialConditionData = commercialConditionData;
	}

	public Boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public String getCustomData() {
		return customData;
	}

	public void setCustomData(String customData) {
		this.customData = customData;
	}

	public StorePreferencesDataDTO[] getStorePreferencesData() {
		return storePreferencesData;
	}

	public void setStorePreferencesData(StorePreferencesDataDTO[] storePreferencesData) {
		this.storePreferencesData = storePreferencesData;
	}

	public Boolean getAllowCancellation() {
		return allowCancellation;
	}

	public void setAllowCancellation(Boolean allowCancellation) {
		this.allowCancellation = allowCancellation;
	}

	public Boolean getAllowEdition() {
		return allowEdition;
	}

	public void setAllowEdition(Boolean allowEdition) {
		this.allowEdition = allowEdition;
	}

	public Boolean getIsCheckedIn() {
		return isCheckedIn;
	}

	public void setIsCheckedIn(Boolean isCheckedIn) {
		this.isCheckedIn = isCheckedIn;
	}

	public MarketplaceDTO[] getMarketplace() {
		return marketplace;
	}

	public void setMarketplace(MarketplaceDTO[] marketplace) {
		this.marketplace = marketplace;
	}

	public Date getAuthorizedDate() {
		return authorizedDate;
	}

	public void setAuthorizedDate(Date authorizedDate) {
		this.authorizedDate = authorizedDate;
	}

	public Date getInvoicedDate() {
		return invoicedDate;
	}

	public void setInvoicedDate(Date invoicedDate) {
		this.invoicedDate = invoicedDate;
	}

}
