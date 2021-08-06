package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class ToDTO implements Serializable {

	private String conversationRelatedTo;
	private String conversationSubject;
	private String emailAlias;
	private Integer aliasMaskType;
	private String email;
	private String name;
	private String role;

	public String getConversationRelatedTo() {
		return conversationRelatedTo;
	}

	public void setConversationRelatedTo(String conversationRelatedTo) {
		this.conversationRelatedTo = conversationRelatedTo;
	}

	public String getConversationSubject() {
		return conversationSubject;
	}

	public void setConversationSubject(String conversationSubject) {
		this.conversationSubject = conversationSubject;
	}

	public String getEmailAlias() {
		return emailAlias;
	}

	public void setEmailAlias(String emailAlias) {
		this.emailAlias = emailAlias;
	}

	public Integer getAliasMaskType() {
		return aliasMaskType;
	}

	public void setAliasMaskType(Integer aliasMaskType) {
		this.aliasMaskType = aliasMaskType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
