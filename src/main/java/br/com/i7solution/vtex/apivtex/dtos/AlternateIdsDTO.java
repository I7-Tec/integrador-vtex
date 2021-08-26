package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class AlternateIdsDTO implements Serializable {

    private String ean;
    private String refId;

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

}
