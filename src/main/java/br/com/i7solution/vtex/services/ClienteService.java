package br.com.i7solution.vtex.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.i7solution.vtex.clients.ClienteClient;
import br.com.i7solution.vtex.clients.dtos.ClienteDTO;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteClient clienteClient;

	public ClienteDTO buscarPorId(String id) {
		return clienteClient.getClientePorId(id);
	}

}