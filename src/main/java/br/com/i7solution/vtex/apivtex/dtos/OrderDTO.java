package br.com.i7solution.vtex.apivtex.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderDTO implements Serializable {
    private String emailTracked;
    private Long id;
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
    private Double value;
    private Date creationDate;
    private String lastChange;
    private String orderGroup;
    private TotalsDTO[] totals;
    private ItemsDTO[] items;
    private String[] marketplaceItems;
    private ClientProfileDataDTO clientProfileData;
    private String giftRegistryData;
    private String marketingData;
    private RatesAndBenefitsDataDTO[] rateAndBenefitsIdentifiers;
    private ShippingDataDTO shippingData;
    private PaymentDataDTO paymentData;
    //private PackageAttachmentDTO[] packageAttachment;
    private SellersDTO[] sellers;
    private String callCenterOperatorData;
    private String followUpEmail;
    private String lastMessage;
    private String hostname;
    private InvoiceDataDTO[] invoiceData;
    private ChangesAttachmentDTO[] changesAttachment;
    private String openTextField;
    private Integer roundingError;
    private String orderFormId;
    private String commercialConditionData;
    private Boolean isCompleted;
    private String customData;
    private StorePreferencesDataDTO storePreferencesData;
    private Boolean allowCancellation;
    private Boolean allowEdition;
    private Boolean isCheckedIn;
    private MarketplaceDTO marketplace;
    private Date authorizedDate;
    private Date invoicedDate;
    private Double quantity;
}
