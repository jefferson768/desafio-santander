package com.santander.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.santander.desafio.core.cliente.entity.ClienteEntity;
import com.santander.desafio.core.cliente.service.AlterarClienteService;
import com.santander.desafio.core.cliente.service.BuscarClienteDocumentoService;
import com.santander.desafio.core.cliente.service.CadastrarClienteService;
import com.santander.desafio.core.cliente.service.ExcluirClienteService;

@RestController
@RequestMapping("/v1/cliente")
public class ClienteController {
	
	@Autowired
	private CadastrarClienteService cadastrarClienteService;
	
	@Autowired
	private BuscarClienteDocumentoService buscarClienteDocumentoClienteService;
	
	@Autowired
	private AlterarClienteService alterarClienteService;
	
	@Autowired
	private ExcluirClienteService excluirClienteService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void salvar(@RequestBody ClienteEntity cliente) {
		cadastrarClienteService.executar(cliente);
	}
	
	@PutMapping
	@ResponseStatus(code = HttpStatus.OK)
	public void editar(@RequestBody ClienteEntity cliente) {
		alterarClienteService.executar(cliente);
	}
	
	@DeleteMapping("{documento}")
	@ResponseStatus(code = HttpStatus.OK)
	public void editar(@PathVariable String documento) {
		excluirClienteService.executar(documento);
	}
	
	@GetMapping("{documento}")
	public ResponseEntity<ClienteEntity> buscarPorNome(@PathVariable String documento) {
		
		ClienteEntity cliente = buscarClienteDocumentoClienteService.executar(documento);
		return ResponseEntity.ok(cliente);
	}
}