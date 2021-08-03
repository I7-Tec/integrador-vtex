package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class ImagesDTO implements Serializable {

	private String imageUrl;
	private String imageName;
	private String fileId;

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

}
