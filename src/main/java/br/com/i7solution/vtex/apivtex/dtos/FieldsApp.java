package br.com.i7solution.vtex.apivtex.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class FieldsApp implements Serializable {
    private String quantity;
    private String interestRate;
    private String deadlines_1;
    private String deadlines_2;
    private String deadlines_3;
}
