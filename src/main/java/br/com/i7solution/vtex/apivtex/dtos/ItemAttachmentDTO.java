package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class ItemAttachmentDTO implements Serializable {

	private String content;
	private String name;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
