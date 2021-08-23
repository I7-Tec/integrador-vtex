package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;

public class InventoryDTO implements Serializable {

    private String skuId;
    private BalanceDTO balance[];


    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public BalanceDTO[] getBalance() {
        return balance;
    }

    public void setBalance(BalanceDTO balance[]) {
        this.balance = balance;
    }

}