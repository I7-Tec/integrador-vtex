package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class SkusDTO implements Serializable {
    private SkuDTO skus[];

    public SkuDTO[] getSkus() {
        return skus;
    }

    public void setSkus(SkuDTO[] skus) {
        this.skus = skus;
    }
}

