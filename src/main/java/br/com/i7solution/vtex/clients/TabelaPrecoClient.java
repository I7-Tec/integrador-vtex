package br.com.i7solution.vtex.clients;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import br.com.i7solution.vtex.apivtex.DadosVtex;
import br.com.i7solution.vtex.clients.dtos.TabelaPrecoDTO;

public class TabelaPrecoClient {
	
	public TabelaPrecoDTO getTabelaPrecoPorIds(String idProduto , String idFilial) {
		String url = DadosVtex.url + "/catalog/category/" + idProduto+ idFilial + "?an=" + DadosVtex.sellers;
		Unirest.setTimeouts(0, 0);
		HttpResponse<TabelaPrecoDTO> response = null;
		try {
			response = Unirest.get(url).header("Content-Type", "application/json")
					.header("Authorization", DadosVtex.bearer).asObject(TabelaPrecoDTO.class);
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return response.getBody();
	}

	public TabelaPrecoDTO putTabelaPrecoPorIds(String idProduto , String idFilial, TabelaPrecoDTO dados) {
		String url = DadosVtex.url + "/catalog/price/" + idProduto+ idFilial + "?an=" + DadosVtex.sellers;
		Unirest.setTimeouts(0, 0);
		HttpResponse<TabelaPrecoDTO> response = null;
		try {
			response = Unirest.put(url).header("Content-Type", "application/json")
					.header("Authorization", DadosVtex.bearer).body(dados).asObject(TabelaPrecoDTO.class);
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return response.getBody();
	}

	public TabelaPrecoDTO postTabelaPrecoPorIds(String idProduto , String idFilial, TabelaPrecoDTO dados) {
		String url = DadosVtex.url + "/catalog/price/" + idProduto + idFilial + "?an=" + DadosVtex.sellers;
		Unirest.setTimeouts(0, 0);
		HttpResponse<TabelaPrecoDTO> response = null;
		try {
			response = Unirest.post(url).header("Content-Type", "application/json")
					.header("Authorization", DadosVtex.bearer).body(dados).asObject(TabelaPrecoDTO.class);
		} catch (UnirestException e) {
			e.printStackTrace();

		}
		return response.getBody();

	}
}
