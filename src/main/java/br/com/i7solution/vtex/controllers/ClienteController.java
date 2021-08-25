package br.com.i7solution.vtex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.i7solution.vtex.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	public ClienteService clienteService;

	@GetMapping("/clientes")
	public void buscarPorId(String id) {
		clienteService.buscarPorId(id);
	}

}
