package br.com.i7solution.vtex.apivtex.dtos;

import java.io.Serializable;



public class OrdersDTO implements Serializable {
   
	private OrderDTO orders[];
    private Long page;
    private Long pageCount;
    private Long perPage;

    public OrderDTO[] getOrders() {
        return orders;
    }

    public void setOrders(OrderDTO[] orders) {
        this.orders = orders;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getPageCount() {
        return pageCount;
    }

    public void setPageCount(Long pageCount) {
        this.pageCount = pageCount;
    }

    public Long getPerPage() {
        return perPage;
    }

    public void setPerPage(Long perPage) {
        this.perPage = perPage;
    }
}

