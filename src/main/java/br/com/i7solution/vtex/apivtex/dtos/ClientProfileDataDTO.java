package br.com.i7solution.vtex.apivtex.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClientProfileDataDTO implements Serializable {
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String documentType;
    private String document;
    private String phone;
    private String corporateName;
    private String tradeName;
    private String corporateDocument;
    private String stateInscription;
    private String corporatePhone;
    private Boolean isCorporate;
    private String userProfileId;
    private String customerClass;
}
