package br.com.i7solution.vtex.apivtex.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class InvoiceDataDTO implements Serializable {
    private Date date;
    private String orderId;
    private String receipt;
}
