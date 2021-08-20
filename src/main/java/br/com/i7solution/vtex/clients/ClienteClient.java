package br.com.i7solution.vtex.clients;

import org.springframework.stereotype.Service;

import br.com.i7solution.vtex.apivtex.DadosVtex;
import br.com.i7solution.vtex.clients.dtos.ClienteDTO;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

@Service
public class ClienteClient {

	public ClienteDTO getClientePorId(String id) {
		String url = DadosMicroServicos.urlCadastros + DadosMicroServicos.endPointClientes+ id + "?an=" + DadosVtex.sellers;
		HttpResponse<ClienteDTO> response = null;
		try {
			response = Unirest.get(url).header("Content-Type", "application/json")
					.header("Authorization", DadosVtex.bearer).asObject(ClienteDTO.class);
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return response.getBody();
	}

	public ClienteDTO putClientePorId(String id, ClienteDTO dados) {
		String url = DadosMicroServicos.urlCadastros +  DadosMicroServicos.endPointClientes + id + "?an=" + DadosVtex.sellers;
		HttpResponse<ClienteDTO> response = null;
		try {
			response = Unirest.put(url).header("Content-Type", "application/json")
					.header("Authorization", DadosVtex.bearer).body(dados).asObject(ClienteDTO.class);
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return response.getBody();
	}

	public ClienteDTO postClientePorId(String id, ClienteDTO dados) {
		String url = DadosMicroServicos.urlCadastros+  DadosMicroServicos.endPointClientes + id + "?an=" + DadosVtex.sellers;
		HttpResponse<ClienteDTO> response = null;
		try {
			response = Unirest.post(url).header("Content-Type", "application/json")
					.header("Authorization", DadosVtex.bearer).body(dados).asObject(ClienteDTO.class);
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return response.getBody();
	}

}