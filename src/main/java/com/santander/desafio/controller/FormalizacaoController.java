package com.santander.desafio.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santander.desafio.core.formalizacao.entity.FormalizacaoEntity;
import com.santander.desafio.core.formalizacao.service.BuscarFormalizacaoService;
import com.santander.desafio.core.formalizacao.service.CadastrarFormalizacaoService;
import com.santander.desafio.core.shared.PathConstants;

@RestController
@RequestMapping(PathConstants.V1_FORMALIZACAO)
public class FormalizacaoController {
	
	@Autowired
	private CadastrarFormalizacaoService cadastrarFormalizacaoService;
	
	@Autowired
	private BuscarFormalizacaoService buscarFormalizacaoService;
	
	@PostMapping
	public ResponseEntity<FormalizacaoEntity> salvar(@RequestBody FormalizacaoEntity formalizacao) {
		
		cadastrarFormalizacaoService.executar(formalizacao);
		
		return buildResponse(formalizacao);
	}
	
	@GetMapping("{documentoCliente}")
	public ResponseEntity<List<FormalizacaoEntity>> buscarPorDocumento(@PathVariable String documentoCliente) {
		
		List<FormalizacaoEntity> formalizacoes = buscarFormalizacaoService.executar(documentoCliente);
		return ResponseEntity.ok(formalizacoes);
	}
	
	private ResponseEntity<FormalizacaoEntity> buildResponse(FormalizacaoEntity formalizacao) {
		return ResponseEntity.created(URI.create(PathConstants.V1_FORMALIZACAO.concat("/").concat(formalizacao.getCliente().getDocumento()))).build();
	}
}