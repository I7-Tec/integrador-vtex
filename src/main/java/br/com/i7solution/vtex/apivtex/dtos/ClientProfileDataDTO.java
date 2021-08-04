package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class ClientProfileDataDTO implements Serializable {

	private String id;
	private String email;
	private String firstName;
	private String lastName;
	private String documentType;
	private String document;
	private String phone;
	private String corporateName;
	private String tradeName;
	private String corporateDocument;
	private String stateInscription;
	private String corporatePhone;
	private Boolean isCorporate;
	private String userProfileId;
	private String customerClass;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCorporateName() {
		return corporateName;
	}

	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}

	public String getTradeName() {
		return tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}

	public String getCorporateDocument() {
		return corporateDocument;
	}

	public void setCorporateDocument(String corporateDocument) {
		this.corporateDocument = corporateDocument;
	}

	public String getStateInscription() {
		return stateInscription;
	}

	public void setStateInscription(String stateInscription) {
		this.stateInscription = stateInscription;
	}

	public String getCorporatePhone() {
		return corporatePhone;
	}

	public void setCorporatePhone(String corporatePhone) {
		this.corporatePhone = corporatePhone;
	}

	public Boolean getIsCorporate() {
		return isCorporate;
	}

	public void setIsCorporate(Boolean isCorporate) {
		this.isCorporate = isCorporate;
	}

	public String getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(String userProfileId) {
		this.userProfileId = userProfileId;
	}

	public String getCustomerClass() {
		return customerClass;
	}

	public void setCustomerClass(String customerClass) {
		this.customerClass = customerClass;
	}

}
