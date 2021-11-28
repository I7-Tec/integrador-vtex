package br.com.i7solution.vtex.apivtex.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrdersDTO implements Serializable {
	private OrderDTO list[];
    private PagingDTO paging;
}

