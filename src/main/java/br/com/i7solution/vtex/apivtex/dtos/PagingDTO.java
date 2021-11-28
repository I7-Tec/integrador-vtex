package br.com.i7solution.vtex.apivtex.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class PagingDTO implements Serializable {
    private Integer total;
    private Integer pages;
    private Integer currentPage;
    private Integer perPage;
}
