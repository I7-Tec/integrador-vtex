package br.com.i7solution.vtex.clients;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import br.com.i7solution.vtex.apivtex.DadosVtex;
import br.com.i7solution.vtex.clients.dtos.EstoqueDTO;

public class EstoqueClient {

	public EstoqueDTO getEstoquePorIds(String idProduto, String idFilial) {
		String url = DadosVtex.url + "/catalog/category/" + idProduto + idFilial + "?an=" + DadosVtex.sellers;
		Unirest.setTimeouts(0, 0);
		HttpResponse<EstoqueDTO> response = null;
		try {
			response = Unirest.get(url).header("Content-Type", "application/json")
					.header("Authorization", DadosVtex.bearer).asObject(EstoqueDTO.class);
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return response.getBody();
	}

	public EstoqueDTO putEstoquePorIds(String idProduto, String idFilial, EstoqueDTO dados) {
		String url = DadosVtex.url + "/catalog/price/" + idProduto + idFilial + "?an=" + DadosVtex.sellers;
		Unirest.setTimeouts(0, 0);
		HttpResponse<EstoqueDTO> response = null;
		try {
			response = Unirest.put(url).header("Content-Type", "application/json")
					.header("Authorization", DadosVtex.bearer).body(dados).asObject(EstoqueDTO.class);
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return response.getBody();
	}

	public EstoqueDTO postEstoquePorIds(String idProduto, String idFilial, EstoqueDTO dados) {
		String url = DadosVtex.url + "/catalog/price/" + idProduto + idFilial + "?an=" + DadosVtex.sellers;
		Unirest.setTimeouts(0, 0);
		HttpResponse<EstoqueDTO> response = null;
		try {
			response = Unirest.post(url).header("Content-Type", "application/json")
					.header("Authorization", DadosVtex.bearer).body(dados).asObject(EstoqueDTO.class);
		} catch (UnirestException e) {
			e.printStackTrace();

		}
		return response.getBody();

	}
}
