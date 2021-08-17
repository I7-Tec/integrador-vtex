package br.com.i7solution.vtex.apivtex;

import org.springframework.stereotype.Service;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import br.com.i7solution.vtex.apivtex.dtos.BrandDTO;
import br.com.i7solution.vtex.apivtex.dtos.CategoryDTO;
import br.com.i7solution.vtex.apivtex.dtos.ProductDTO;
import br.com.i7solution.vtex.apivtex.dtos.SkuDTO;

@Service
public class CatalogClient {

	public CategoryDTO getCategorias() {
		String url = DadosVtex.url + "/catalog/category/?an=" + DadosVtex.sellers;

		HttpResponse<CategoryDTO> response = null;
		try {
			response = Unirest.get(url).header("Content-Type", "application/json")
					.header("Authorization", DadosVtex.bearer).asObject(CategoryDTO.class);
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return response.getBody();
	}

	public CategoryDTO getCategoriaPorId(String id) {
		String url = DadosVtex.url + "/catalog/category/" + id + "?an=" + DadosVtex.sellers;

		HttpResponse<CategoryDTO> response = null;
		try {
			response = Unirest.get(url).header("Content-Type", "application/json")
					.header("Authorization", DadosVtex.bearer).asObject(CategoryDTO.class);
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return response.getBody();
	}

	public BrandDTO getMarcas() {
		String url = DadosVtex.url + "/catalog/brand/?an=" + DadosVtex.sellers;
		HttpResponse<BrandDTO> response = null;
		try {
			response = Unirest.get(url).header("Content-Type", "application/json")
					.header("Authorization", DadosVtex.bearer).asObject(BrandDTO.class);
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return response.getBody();
	}

	public BrandDTO getMarcaPorId(String id) {
		String url = DadosVtex.url + "/catalog/brand/" + id + "?an=" + DadosVtex.sellers;
		HttpResponse<BrandDTO> response = null;
		try {
			response = Unirest.get(url).header("Content-Type", "application/json")
					.header("Authorization", DadosVtex.bearer).asObject(BrandDTO.class);
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return response.getBody();
	}

	public ProductDTO getProdutoPorId(String id) {
		String url = DadosVtex.url + "/catalog/product/" + id + "?an=" + DadosVtex.sellers;
		HttpResponse<ProductDTO> response = null;
		try {
			response = Unirest.get(url).header("Content-Type", "application/json")
					.header("Authorization", DadosVtex.bearer).asObject(ProductDTO.class);
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return response.getBody();
	}

	public SkuDTO getSKUs() {
		String url = DadosVtex.url + "/catalog/skus/?an=" + DadosVtex.sellers;
		HttpResponse<SkuDTO> response = null;
		try {
			response = Unirest.get(url).header("Content-Type", "application/json")
					.header("Authorization", DadosVtex.bearer).asObject(SkuDTO.class);
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return response.getBody();
	}

	public SkuDTO getSKUPorId(String id) {
		String url = DadosVtex.url + "/catalog/sku/" + id + "?an=" + DadosVtex.sellers;
		HttpResponse<SkuDTO> response = null;
		try {
			response = Unirest.get(url).header("Content-Type", "application/json")
					.header("Authorization", DadosVtex.bearer).asObject(SkuDTO.class);
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return response.getBody();
	}

	public SkuDTO postSku(SkuDTO dados) {
		String url = DadosVtex.url + "/catalog/sku?an=" + DadosVtex.sellers;
		HttpResponse<SkuDTO> response = null;
		try {
			response = Unirest.post(url).header("Content-Type", "application/json")
					.header("Authorization", DadosVtex.bearer).body(dados).asObject(SkuDTO.class);
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return response.getBody();
	}
}
