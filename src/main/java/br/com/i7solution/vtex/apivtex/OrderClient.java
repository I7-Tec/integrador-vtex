package br.com.i7solution.vtex.apivtex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import br.com.i7solution.vtex.apivtex.dtos.OrderDTO;
import br.com.i7solution.vtex.apivtex.dtos.OrdersDTO;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

@Service
public class OrderClient {

	public OrderDTO getPedidoPorId(String orderId) {
		String url = DadosVtex.url + DadosVtex.endPointProduto + orderId.toString() + "?an=" + DadosVtex.sellers;
		HttpResponse<OrderDTO> response = null;
		try {
			response = Unirest.get(url).header("Content-Type", "application/json")
					.header("Authorization", DadosVtex.bearer).asObject(OrderDTO.class);
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return response.getBody();
	}

	public List<OrderDTO> getPedidosPorStatus(String status) {
		List<OrderDTO> result = new ArrayList<>();
		HttpResponse<OrdersDTO> response = null;
		try {
			var temPedidos = true;
			int pag = 1;
			while (temPedidos) {
				String url = DadosVtex.url + DadosVtex.endPointProduto + DadosVtex.sellers + "&perPage=50&page=" + pag
						+ "&status=" + status;

				response = Unirest.get(url).header("Content-Type", "application/json")
						.header("Authorization", DadosVtex.bearer).asObject(OrdersDTO.class);

				Arrays.stream(response.getBody().getOrders()).map(result::add);

				++pag;
				temPedidos = !(response.getBody().getPageCount() < response.getBody().getPerPage());
			}
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return result;
	}
	 public List<OrderDTO> getPedidosPorData(String dataIni, String dataFim) {
	        List<OrderDTO> result = new ArrayList<>();
	        HttpResponse<OrdersDTO> response = null;
	        try {
	            var temPedidos = true;
	            int pag = 1;
	            while (temPedidos) {
	                String url = DadosVtex.url + DadosVtex.endPointProduto + DadosVtex.sellers + "&perPage=50&page=" + pag +
	                        "&creationDateStart=" + dataIni + "&creationDateEnd=" + dataFim;

	                response = Unirest.get(url)
	                        .header("Content-Type", "application/json")
	                        .header("Authorization", DadosVtex.bearer)
	                        .asObject(OrdersDTO.class);

	                Arrays.stream(response.getBody().getOrders())
	                        .map(result::add);

	                ++pag;
	                temPedidos = !(response.getBody().getPageCount() < response.getBody().getPerPage());
	            }
	        } catch (UnirestException e) {
	            e.printStackTrace();
	        }

	        return result;
	    }

}
