package br.com.i7solution.vtex.apivtex;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import br.com.i7solution.vtex.apivtex.dtos.SkuDTO;

public class InventoryClient {

	public SkuDTO getSkuPorId(String skuId) {
		String url = DadosVtex.url + "/catalog/inventory/" + skuId + "?an=" + DadosVtex.sellers;
		Unirest.setTimeouts(0, 0);
		HttpResponse<SkuDTO> response = null;
		try {
			response = Unirest.get(url).header("Content-Type", "application/json")
					.header("Authorization", DadosVtex.bearer).asObject(SkuDTO.class);
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return response.getBody();
	}

	public SkuDTO getSellerSku(String skuSellers) {
		String url = DadosVtex.url + "/catalog/inventory/" + skuSellers + "?an=" + DadosVtex.sellers;
		Unirest.setTimeouts(0, 0);
		HttpResponse<SkuDTO> response = null;
		try {
			response = Unirest.get(url).header("Content-Type", "application/json")
					.header("Authorization", DadosVtex.bearer).asObject(SkuDTO.class);
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return response.getBody();
	}

}
