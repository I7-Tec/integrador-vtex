package br.com.i7solution.vtex.clients;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

import br.com.i7solution.vtex.apivtex.DadosVtex;
import br.com.i7solution.vtex.clients.dtos.EnderecoDTO;

public class EnderecoClient {

	public EnderecoDTO getEnderecoPorId(String id) {
		String url = DadosMicroServicos.urlCadastros + DadosMicroServicos.endPointEnderecos+ id + "?an=" ;
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
		String url = DadosMicroServicos.urlCadastros + DadosMicroServicos.endPointEnderecos + id + "?an=" ;
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
		String url = DadosMicroServicos.urlCadastros + DadosMicroServicos.endPointEnderecos + id + "?an=" ;
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