package br.com.i7solution.vtex.clients;

import br.com.i7solution.vtex.config.PropertiesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.i7solution.vtex.apivtex.DadosVtex;
import br.com.i7solution.vtex.clients.dtos.ClienteDTO;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

import java.io.IOException;

@Service
public class ClienteClient {

	@Autowired
	private PropertiesConfig properties;

	public ClienteDTO getClientePorId(String id) throws IOException {
		var props = properties.getProperties();
		String url = DadosMicroServicos.endPointClientes;
		HttpResponse<ClienteDTO> response = null;
		try {
			response = Unirest.get(url)
					.header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + props.getProperty("properties.token"))
					.queryString("idProdutoI7", DadosMicroServicos.idProdutoI7)
					.queryString("idClienteI7", props.getProperty("properties.idcliente"))
					.asObject(ClienteDTO.class);
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return response.getBody();
	}

	public ClienteDTO putClientePorId(String id, ClienteDTO dados) throws IOException {
		var props = properties.getProperties();
		String url = DadosMicroServicos.endPointClientes + id + "?an=" + DadosVtex.sellers;
		HttpResponse<ClienteDTO> response = null;
		try {
			response = Unirest.put(url)
					.header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + props.getProperty("properties.token"))
					.queryString("idProdutoI7", DadosMicroServicos.idProdutoI7)
					.queryString("idClienteI7", props.getProperty("properties.idcliente"))
					.body(dados).asObject(ClienteDTO.class);
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return response.getBody();
	}

	public ClienteDTO postClientePorId(String id, ClienteDTO dados) throws IOException {
		var props = properties.getProperties();
		String url = DadosMicroServicos.endPointClientes + id + "?an=" + DadosVtex.sellers;
		HttpResponse<ClienteDTO> response = null;
		try {
			response = Unirest.post(url)
					.header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + props.getProperty("properties.token"))
					.queryString("idProdutoI7", DadosMicroServicos.idProdutoI7)
					.queryString("idClienteI7", props.getProperty("properties.idcliente"))
					.body(dados).asObject(ClienteDTO.class);
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return response.getBody();
	}

}