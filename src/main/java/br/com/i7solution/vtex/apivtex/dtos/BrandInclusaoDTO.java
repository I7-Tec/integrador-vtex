package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class BrandInclusaoDTO implements Serializable {
    private Long Id; //	integer	Brand’s numerical identifier
    private String Name;//Name	string	Brand’s name
    private String Text; //	string	Brand’s description
    private String Keywords; //	string	Substitutes words for the Brand
    private String SiteTitle; //SiteTitle	string	Brand’s page title
    private Boolean Active; //	boolean	If the Brand is active
    private Boolean MenuHome; //MenuHome	boolean	If the Brand shows on the home menu or not
    private String AdWordsRemarketingCode; //AdWordsRemarketingCode	string	Shows the specific code for the AdWords remarketing platform
    private String LomadeeCampaignCode; //LomadeeCampaignCode	string	Shows the specific code for the LomadeeCampaig
    private Long Score; //Score	integer	Score for search ordination
    private String LinkId; //LinkId	string	Brand’s link ID

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

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public String getKeywords() {
        return Keywords;
    }

    public void setKeywords(String keywords) {
        Keywords = keywords;
    }

    public String getSiteTitle() {
        return SiteTitle;
    }

    public void setSiteTitle(String siteTitle) {
        SiteTitle = siteTitle;
    }

    public Boolean getActive() {
        return Active;
    }

    public void setActive(Boolean active) {
        Active = active;
    }

    public Boolean getMenuHome() {
        return MenuHome;
    }

    public void setMenuHome(Boolean menuHome) {
        MenuHome = menuHome;
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

    public String getLinkId() {
        return LinkId;
    }

    public void setLinkId(String linkId) {
        LinkId = linkId;
    }
}
