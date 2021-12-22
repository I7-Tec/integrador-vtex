package br.com.i7solution.vtex.apivtex.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class CustomApp implements Serializable {
    private String id;
    private Double major;
    private FieldsApp fields;
}
