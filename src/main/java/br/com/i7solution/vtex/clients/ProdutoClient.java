package br.com.i7solution.vtex.clients;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import br.com.i7solution.vtex.apivtex.DadosVtex;
import br.com.i7solution.vtex.clients.dtos.ProdutoDTO;

public class ProdutoClient {

	public ProdutoDTO getProdutoPorId(String id) {
		String url = DadosVtex.url + "/catalog/category/" + id + "?an=" + DadosVtex.sellers;
		Unirest.setTimeouts(0, 0);
		HttpResponse<ProdutoDTO> response = null;
		try {
			response = Unirest.get(url).header("Content-Type", "application/json")
					.header("Authorization", DadosVtex.bearer).asObject(ProdutoDTO.class);
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return response.getBody();
	}

	public ProdutoDTO putProdutoPorId(String id, ProdutoDTO dados) {
		String url = DadosVtex.url + "/catalog/price/" + id + "?an=" + DadosVtex.sellers;
		Unirest.setTimeouts(0, 0);
		HttpResponse<ProdutoDTO> response = null;
		try {
			response = Unirest.put(url).header("Content-Type", "application/json")
					.header("Authorization", DadosVtex.bearer).body(dados).asObject(ProdutoDTO.class);
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return response.getBody();
	}

	public ProdutoDTO postProdutoPorId(String id, ProdutoDTO dados) {
		String url = DadosVtex.url + "/catalog/price/" + id + "?an=" + DadosVtex.sellers;
		Unirest.setTimeouts(0, 0);
		HttpResponse<ProdutoDTO> response = null;
		try {
			response = Unirest.post(url).header("Content-Type", "application/json")
					.header("Authorization", DadosVtex.bearer).body(dados).asObject(ProdutoDTO.class);
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return response.getBody();
	}

}
