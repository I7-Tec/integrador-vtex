package br.com.i7solution.vtex.clients;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import br.com.i7solution.vtex.apivtex.DadosVtex;
import br.com.i7solution.vtex.clients.dtos.EnderecoDTO;

public class EnderecoClient {

	public EnderecoDTO getEnderecoPorId(String id) {
		String url = DadosVtex.url + "/catalog/category/" + id + "?an=" + DadosVtex.sellers;
		Unirest.setTimeouts(0, 0);
		HttpResponse<EnderecoDTO> response = null;
		try {
			response = Unirest.get(url).header("Content-Type", "application/json")
					.header("Authorization", DadosVtex.bearer).asObject(EnderecoDTO.class);
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return response.getBody();
	}

	public EnderecoDTO putEnderecoPorId(String id, EnderecoDTO dados) {
		String url = DadosVtex.url + "/catalog/price/" + id + "?an=" + DadosVtex.sellers;
		Unirest.setTimeouts(0, 0);
		HttpResponse<EnderecoDTO> response = null;
		try {
			response = Unirest.put(url).header("Content-Type", "application/json")
					.header("Authorization", DadosVtex.bearer).body(dados).asObject(EnderecoDTO.class);
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return response.getBody();
	}

	public EnderecoDTO postEnderecoPorId(String id, EnderecoDTO dados) {
		String url = DadosVtex.url + "/catalog/price/" + id + "?an=" + DadosVtex.sellers;
		Unirest.setTimeouts(0, 0);
		HttpResponse<EnderecoDTO> response = null;
		try {
			response = Unirest.post(url).header("Content-Type", "application/json")
					.header("Authorization", DadosVtex.bearer).body(dados).asObject(EnderecoDTO.class);
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return response.getBody();
	}

}