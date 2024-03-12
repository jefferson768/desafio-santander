package com.santander.desafio.controller;

import java.net.URI;

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
import com.santander.desafio.core.shared.PathConstants;

@RestController
@RequestMapping(PathConstants.V1_CLIENTE)
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
	public ResponseEntity<ClienteEntity> salvar(@RequestBody ClienteEntity cliente) {
		
		cadastrarClienteService.executar(cliente);
		
		return buildResponse(cliente);
	}
	
	@PutMapping
	@ResponseStatus(code = HttpStatus.OK)
	public void editar(@RequestBody ClienteEntity cliente) {
		alterarClienteService.executar(cliente);
	}
	
	@DeleteMapping("{documento}")
	@ResponseStatus(code = HttpStatus.OK)
	public void excluir(@PathVariable String documento) {
		excluirClienteService.executar(documento);
	}
	
	@GetMapping("{documento}")
	public ResponseEntity<ClienteEntity> buscarPorDocumento(@PathVariable String documento) {
		
		ClienteEntity cliente = buscarClienteDocumentoClienteService.executar(documento);
		return ResponseEntity.ok(cliente);
	}
	
	private ResponseEntity<ClienteEntity> buildResponse(ClienteEntity cliente) {
		return ResponseEntity.created(URI.create(PathConstants.V1_CLIENTE.concat("/").concat(cliente.getDocumento()))).build();
	}
}