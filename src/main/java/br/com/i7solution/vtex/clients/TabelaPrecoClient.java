package br.com.i7solution.vtex.clients;

import java.util.List;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import org.springframework.stereotype.Service;

import br.com.i7solution.vtex.clients.dtos.TabelaPrecoDTO;

@Service
public class TabelaPrecoClient {

	public List<TabelaPrecoDTO> getPrecosWinthor() {
		String url = DadosMicroServicos.urlCadastros + DadosMicroServicos.endPointPrecos;
		HttpResponse<List<TabelaPrecoDTO>> response = null;
		try {
			response = Unirest.get(url).header("Content-Type", "application/json")
					.asObject(new GenericType<List<TabelaPrecoDTO>>() {
					});
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		return response.getBody();
	}
}
