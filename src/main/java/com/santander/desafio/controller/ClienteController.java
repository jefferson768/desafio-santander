package com.santander.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.santander.desafio.core.cliente.entity.ClienteEntity;
import com.santander.desafio.core.cliente.service.BuscarClienteNomeService;
import com.santander.desafio.core.cliente.service.CadastrarClienteService;

@RestController
@RequestMapping("/v1/clientes")
public class ClienteController {
	
	@Autowired
	private CadastrarClienteService cadastrarClienteService;
	
	@Autowired
	private BuscarClienteNomeService buscarClienteNomeClienteService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void salvar(@RequestBody ClienteEntity cliente) {
		cadastrarClienteService.executar(cliente);
	}
	
	@GetMapping("{nome}")
	public ResponseEntity<ClienteEntity> buscarPorNome(@PathVariable String nome) {
		
		ClienteEntity cliente = buscarClienteNomeClienteService.executar(nome); 
		return ResponseEntity.ok(cliente);
	}
}