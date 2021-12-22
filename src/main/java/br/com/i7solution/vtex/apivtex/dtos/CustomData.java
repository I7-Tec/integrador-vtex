package br.com.i7solution.vtex.apivtex.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class CustomData implements Serializable {
    private CustomApp[] customApps;
}
