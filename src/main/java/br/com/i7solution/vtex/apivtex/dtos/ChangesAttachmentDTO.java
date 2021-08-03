package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class ChangesAttachmentDTO implements Serializable{

	private String id;
	private ChangesDataDTO changesData[];

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ChangesDataDTO[] getChangesData() {
		return changesData;
	}

	public void setChangesData(ChangesDataDTO[] changesData) {
		this.changesData = changesData;
	}

}
