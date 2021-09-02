package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class CategoryInclusaoDTO implements Serializable {
    private Long Id; //	integer	Category ID	No
    private String Name; //	string	Category name (150 characters max)	Yes
    private String Keywords; //	string	Substitute words for the Category	No
    private String Title; //	string	Text used in title tag for Category page	No
    private String Description; //	string	Text used in meta description tag for Category page	No
    private String AdWordsRemarketingCode; //	string	Shows the specific code for the AdWords remarketing platform	No
    private String LomadeeCampaignCode; //	string	Shows the specific code for the LomadeeCampaign	No
    private Long FatherCategoryId; //	integer	ID of the parent category, apply in case of category and subcategory	No
    private Long GlobalCategoryId; //	integer	google_product_category for Google Merchant Center	No
    private Boolean ShowInStoreFront; //	boolean	If true, Category is shown in the top and side menu	No
    private Boolean IsActive; //	boolean	If true, Category page becomes available in store	No
    private Boolean ActiveStoreFrontLink; //	boolean	If true, Category links become active in store	No
    private Boolean ShowBrandFilter; //	boolean	If true, Category page displays a Brand filter	No
    private Long Score; //integer	Score for search sorting order	No
    private String StockKeepingUnitSelectionMode; //	string	Product display mode (see table below)	No

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

    public String getKeywords() {
        return Keywords;
    }

    public void setKeywords(String keywords) {
        Keywords = keywords;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
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

    public Long getFatherCategoryId() {
        return FatherCategoryId;
    }

    public void setFatherCategoryId(Long fatherCategoryId) {
        FatherCategoryId = fatherCategoryId;
    }

    public Long getGlobalCategoryId() {
        return GlobalCategoryId;
    }

    public void setGlobalCategoryId(Long globalCategoryId) {
        GlobalCategoryId = globalCategoryId;
    }

    public Boolean getShowInStoreFront() {
        return ShowInStoreFront;
    }

    public void setShowInStoreFront(Boolean showInStoreFront) {
        ShowInStoreFront = showInStoreFront;
    }

    public Boolean getActive() {
        return IsActive;
    }

    public void setActive(Boolean active) {
        IsActive = active;
    }

    public Boolean getActiveStoreFrontLink() {
        return ActiveStoreFrontLink;
    }

    public void setActiveStoreFrontLink(Boolean activeStoreFrontLink) {
        ActiveStoreFrontLink = activeStoreFrontLink;
    }

    public Boolean getShowBrandFilter() {
        return ShowBrandFilter;
    }

    public void setShowBrandFilter(Boolean showBrandFilter) {
        ShowBrandFilter = showBrandFilter;
    }

    public Long getScore() {
        return Score;
    }

    public void setScore(Long score) {
        Score = score;
    }

    public String getStockKeepingUnitSelectionMode() {
        return StockKeepingUnitSelectionMode;
    }

    public void setStockKeepingUnitSelectionMode(String stockKeepingUnitSelectionMode) {
        StockKeepingUnitSelectionMode = stockKeepingUnitSelectionMode;
    }
}
