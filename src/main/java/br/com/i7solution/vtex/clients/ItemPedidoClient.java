package br.com.i7solution.vtex.clients;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import br.com.i7solution.vtex.apivtex.DadosVtex;
import br.com.i7solution.vtex.clients.dtos.ItemPedidoDTO;

public class ItemPedidoClient {
	
		
		public ItemPedidoDTO getItemPedidoPorId(String idProduto) {
			String url = DadosVtex.url + "/catalog/category/" + idProduto + "?an=" + DadosVtex.sellers;
			Unirest.setTimeouts(0, 0);
			HttpResponse<ItemPedidoDTO> response = null;
			try {
				response = Unirest.get(url).header("Content-Type", "application/json")
						.header("Authorization", DadosVtex.bearer).asObject(ItemPedidoDTO.class);
			} catch (UnirestException e) {
				e.printStackTrace();
			}

			return response.getBody();
		}

		public ItemPedidoDTO putItemPedidoPorId(String idProduto, ItemPedidoDTO dados) {
			String url = DadosVtex.url + "/catalog/price/" + idProduto + "?an=" + DadosVtex.sellers;
			Unirest.setTimeouts(0, 0);
			HttpResponse<ItemPedidoDTO> response = null;
			try {
				response = Unirest.put(url).header("Content-Type", "application/json")
						.header("Authorization", DadosVtex.bearer).body(dados).asObject(ItemPedidoDTO.class);
			} catch (UnirestException e) {
				e.printStackTrace();
			}

			return response.getBody();
		}

		public ItemPedidoDTO postItemPedidoPorId(String idProduto, ItemPedidoDTO dados) {
			String url = DadosVtex.url + "/catalog/price/" + idProduto + "?an=" + DadosVtex.sellers;
			Unirest.setTimeouts(0, 0);
			HttpResponse<ItemPedidoDTO> response = null;
			try {
				response = Unirest.post(url).header("Content-Type", "application/json")
						.header("Authorization", DadosVtex.bearer).body(dados).asObject(ItemPedidoDTO.class);
			} catch (UnirestException e) {
				e.printStackTrace();
			}

			return response.getBody();
		}


}
