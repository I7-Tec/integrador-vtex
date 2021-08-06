package br.com.i7solution.vtex.apivtex;

import org.springframework.stereotype.Service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import br.com.i7solution.vtex.apivtex.dtos.SkuPriceDTO;

@Service
public class PriceClient {

	public SkuPriceDTO getPrecoPorSku(String skuId) {
		String url = DadosVtex.url + "/catalog/price/" + skuId + "?an=" + DadosVtex.sellers;
		Unirest.setTimeouts(0, 0);
		HttpResponse<SkuPriceDTO> response = null;
		try {
			response = Unirest.get(url).header("Content-Type", "application/json")
					.header("Authorization", DadosVtex.bearer).asObject(SkuPriceDTO.class);
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return response.getBody();
	}

	public SkuPriceDTO putPrecoPorSku(String skuId, SkuPriceDTO dados) {
		String url = DadosVtex.url + "/catalog/price/" + skuId + "?an=" + DadosVtex.sellers;
		Unirest.setTimeouts(0, 0);
		HttpResponse<SkuPriceDTO> response = null;
		try {
			response = Unirest.put(url).header("Content-Type", "application/json")
					.header("Authorization", DadosVtex.bearer).body(dados).asObject(SkuPriceDTO.class);
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return response.getBody();
	}
}
