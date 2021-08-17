package br.com.i7solution.vtex.clients;

import java.util.List;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import org.springframework.stereotype.Service;
import br.com.i7solution.vtex.apivtex.DadosVtex;
import br.com.i7solution.vtex.clients.dtos.EstoqueDTO;

@Service
public class EstoqueClient {

	public List<EstoqueDTO> getEstoque() {
		String url = DadosMicroServicos.urlCadastros + DadosMicroServicos.endPointProdutos;
		HttpResponse<List<EstoqueDTO>> response = null;
		try {
			response = Unirest.get(url).header("Content-Type", "application/json")
					.asObject(new GenericType<List<EstoqueDTO>>() {
					});
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return response.getBody();
	}

	public EstoqueDTO getEstoquePorId(String id) {
		String url = DadosVtex.url + "/catalog/estoque/" + id + "?an=" + DadosVtex.sellers;
		HttpResponse<EstoqueDTO> response = null;
		try {
			response = Unirest.get(url).header("Content-Type", "application/json")
					.header("Authorization", DadosVtex.bearer).asObject(EstoqueDTO.class);
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return response.getBody();
	}

	public EstoqueDTO getEstoquePorIds(String idProduto, String idFilial) {
		String url = DadosVtex.url + "/catalog/estoque/" + idProduto + idFilial + "?an=" + DadosVtex.sellers;
		// Unirest.setTimeouts(0, 0);
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
		String url = DadosVtex.url + "/catalog/estoque/" + idProduto + idFilial + "?an=" + DadosVtex.sellers;
		// Unirest.setTimeouts(0, 0);
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
		String url = DadosVtex.url + "/catalog/estoque/" + idProduto + idFilial + "?an=" + DadosVtex.sellers;
		// Unirest.setTimeouts(0, 0);
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
