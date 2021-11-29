package br.com.i7solution.vtex.apivtex.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class AdressDTO implements Serializable {
    private String addressId;
    private String addressType;
    private String receiverName;
    private String postalCode;
    private String city;
    private String state;
    private String country;
    private String street;
    private String number;
    private String neighborhood;
    private String complement;
    private String reference;
    private Double[] geoCoordinates;
}
