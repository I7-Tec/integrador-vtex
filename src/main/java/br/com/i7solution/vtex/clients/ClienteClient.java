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
					.header("X-VTEX-API-AppKey", DadosVtex.appKey)
					.header("X-VTEX-API-AppToken",DadosVtex.appToken)
					.asObject(ClienteDTO.class);
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
					.header("X-VTEX-API-AppKey", DadosVtex.appKey)
					.header("X-VTEX-API-AppToken",DadosVtex.appToken)
					.body(dados).asObject(ClienteDTO.class);
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
					.header("X-VTEX-API-AppKey", DadosVtex.appKey)
					.header("X-VTEX-API-AppToken",DadosVtex.appToken)
					.body(dados).asObject(ClienteDTO.class);
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return response.getBody();
	}

}