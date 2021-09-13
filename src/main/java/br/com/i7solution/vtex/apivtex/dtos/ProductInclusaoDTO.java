package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class ProductInclusaoDTO implements Serializable {

    private Long Id ;
    private String Name;
    private Long DepartmentId;
    private Long CategoryId;
    private Long BrandId;
    private String LinkId;
    private String  RefId;
    private Boolean IsVisible;
    private String Description;
    private String DescriptionShort;
    private String ReleaseDate;
    private String KeyWords;
    private String  Title;
    private Boolean IsActive;
    private String  TaxCode;
    private String MetaTagDescription;
    private Long  SupplierId;
    private Boolean ShowWithoutStock;
    private String AdWordsRemarketingCode;
    private String LomadeeCampaignCode;
    private Long Score;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

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

    @Override
    public String toString() {
        return "ProductInclusaoDTO{" +
                "Id:" + Id +
                ", Name:'" + Name + '\'' +
                ", DepartmentId:" + DepartmentId +
                ", CategoryId:" + CategoryId +
                ", BrandId:" + BrandId +
                ", LinkId:'" + LinkId + '\'' +
                ", RefId:'" + RefId + '\'' +
                ", IsVisible:" + IsVisible +
                ", Description:'" + Description + '\'' +
                ", DescriptionShort:'" + DescriptionShort + '\'' +
                ", ReleaseDate:'" + ReleaseDate + '\'' +
                ", KeyWords:'" + KeyWords + '\'' +
                ", Title:'" + Title + '\'' +
                ", IsActive:" + IsActive +
                ", TaxCode:'" + TaxCode + '\'' +
                ", MetaTagDescription:'" + MetaTagDescription + '\'' +
                ", SupplierId:" + SupplierId +
                ", ShowWithoutStock:" + ShowWithoutStock +
                ", AdWordsRemarketingCode:'" + AdWordsRemarketingCode + '\'' +
                ", LomadeeCampaignCode:'" + LomadeeCampaignCode + '\'' +
                ", Score:" + Score +
                '}';
    }
}
