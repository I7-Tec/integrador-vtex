package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class ProductInclusaoDTO implements Serializable {

    private Long Id ;// Product Id

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    private String Name; //	string	Product Name
    private Long DepartmentId;//	integer	Product Department ID
    private Long CategoryId;	//integer	Product Category ID
    private Long BrandId; //	integer	Product Brand ID
    private String LinkId; //	string	Text Link
    private String  RefId; //	string	Product Referecial Code
    private Boolean IsVisible;	//boolean	If the Product is visible on the store
    private String Description;	//string	Product Description
    private String DescriptionShort	; //string	Complement Name
    private String ReleaseDate ; //	string	Product Release Date
    private String KeyWords; //	string	Substitutes words for the Product
    private String  Title;	//string	Tag Title
    private Boolean IsActive; //	boolean	If the Product is active or not
    private String  TaxCode; //	string	Product Fiscal Code
    private String MetaTagDescription; //	string	Meta Tag Description
    private Long  SupplierId; //	integer	Product Supplier ID
    private Boolean ShowWithoutStock;	//boolean	Defines if the Product will remain being shown in the store even if it’s out of stock
    private String AdWordsRemarketingCode; //	string	Code specific for AdWords Remarketing
    private String LomadeeCampaignCode; //	string	Code specific for Lomadee Campaign
    private Long Score; //	integer	Value used for Product search ordenation

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Long getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(Long departmentId) {
        DepartmentId = departmentId;
    }

    public Long getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(Long categoryId) {
        CategoryId = categoryId;
    }

    public Long getBrandId() {
        return BrandId;
    }

    public void setBrandId(Long brandId) {
        BrandId = brandId;
    }

    public String getLinkId() {
        return LinkId;
    }

    public void setLinkId(String linkId) {
        LinkId = linkId;
    }

    public String getRefId() {
        return RefId;
    }

    public void setRefId(String refId) {
        RefId = refId;
    }

    public Boolean getVisible() {
        return IsVisible;
    }

    public void setVisible(Boolean visible) {
        IsVisible = visible;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDescriptionShort() {
        return DescriptionShort;
    }

    public void setDescriptionShort(String descriptionShort) {
        DescriptionShort = descriptionShort;
    }

    public String getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        ReleaseDate = releaseDate;
    }

    public String getKeyWords() {
        return KeyWords;
    }

    public void setKeyWords(String keyWords) {
        KeyWords = keyWords;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Boolean getActive() {
        return IsActive;
    }

    public void setActive(Boolean active) {
        IsActive = active;
    }

    public String getTaxCode() {
        return TaxCode;
    }

    public void setTaxCode(String taxCode) {
        TaxCode = taxCode;
    }

    public String getMetaTagDescription() {
        return MetaTagDescription;
    }

    public void setMetaTagDescription(String metaTagDescription) {
        MetaTagDescription = metaTagDescription;
    }

    public Long getSupplierId() {
        return SupplierId;
    }

    public void setSupplierId(Long supplierId) {
        SupplierId = supplierId;
    }

    public Boolean getShowWithoutStock() {
        return ShowWithoutStock;
    }

    public void setShowWithoutStock(Boolean showWithoutStock) {
        ShowWithoutStock = showWithoutStock;
    }

    public String getAdWordsRemarketingCode() {
        return AdWordsRemarketingCode;
    }

    public void setAdWordsRemarketingCode(String adWordsRemarketingCode) {
        AdWordsRemarketingCode = adWordsRemarketingCode;
    }

    public String getLomadeeCampaignCode() {
        return LomadeeCampaignCode;
    }

    public void setLomadeeCampaignCode(String lomadeeCampaignCode) {
        LomadeeCampaignCode = lomadeeCampaignCode;
    }

    public Long getScore() {
        return Score;
    }

    public void setScore(Long score) {
        Score = score;
    }
}
