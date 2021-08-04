package br.com.i7solution.vtex.apivtex;

import org.springframework.stereotype.Service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import br.com.i7solution.vtex.apivtex.dtos.BrandDTO;
import br.com.i7solution.vtex.apivtex.dtos.ItemsDTO;
import br.com.i7solution.vtex.apivtex.dtos.ProductCategoriesDTO;

@Service
public class CatalogClient {

	public ProductCategoriesDTO getCategorias() {
		String url = DadosVtex.url + "/catalog/category/?an=" + DadosVtex.sellers;
		Unirest.setTimeouts(0, 0);
		HttpResponse<ProductCategoriesDTO> response = null;
		try {
			response = Unirest.get(url).header("Content-Type", "application/json")
					.header("Authorization", DadosVtex.bearer).asObject(ProductCategoriesDTO.class);
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return response.getBody();
	}

	public ItemsDTO getItems() {
		String url = DadosVtex.url + "/catalog/category/?an=" + DadosVtex.sellers;
		Unirest.setTimeouts(0, 0);
		HttpResponse<ItemsDTO> response = null;
		try {
			response = Unirest.get(url).header("Content-Type", "application/json")
					.header("Authorization", DadosVtex.bearer).asObject(ItemsDTO.class);
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return response.getBody();
	}

	public BrandDTO getMarcas() {
		String url = DadosVtex.url + "/catalog/category/?an=" + DadosVtex.sellers;
		Unirest.setTimeouts(0, 0);
		HttpResponse<BrandDTO> response = null;
		try {
			response = Unirest.get(url).header("Content-Type", "application/json")
					.header("Authorization", DadosVtex.bearer).asObject(BrandDTO.class);
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return response.getBody();
	}

}
