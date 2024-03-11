package com.santander.desafio.controller;

import java.util.List;

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

import com.santander.desafio.core.simulacao.entity.SimulacaoEntity;
import com.santander.desafio.core.simulacao.service.BuscarSimulacaoService;
import com.santander.desafio.core.simulacao.service.CadastrarSimulacaoService;

@RestController
@RequestMapping("/v1/simulacao")
public class SimulacaoController {
	
	@Autowired
	private CadastrarSimulacaoService cadastrarSimulacaoService;
	
	@Autowired
	private BuscarSimulacaoService buscarSimulacaoService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void salvar(@RequestBody SimulacaoEntity simulacao) {
		cadastrarSimulacaoService.executar(simulacao);
	}
	
	
	@GetMapping("{documentoCliente}")
	public ResponseEntity<List<SimulacaoEntity>> buscarPorDocumento(@PathVariable String documentoCliente) {
		
		List<SimulacaoEntity> simulacoes = buscarSimulacaoService.executar(documentoCliente);
		return ResponseEntity.ok(simulacoes);
	}
}