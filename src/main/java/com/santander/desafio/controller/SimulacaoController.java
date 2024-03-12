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

import com.santander.desafio.core.shared.PathConstants;
import com.santander.desafio.core.simulacao.entity.SimulacaoEntity;
import com.santander.desafio.core.simulacao.service.BuscarSimulacaoService;
import com.santander.desafio.core.simulacao.service.CadastrarSimulacaoService;

@RestController
@RequestMapping(PathConstants.V1_SIMULACAO)
public class SimulacaoController {
	
	@Autowired
	private CadastrarSimulacaoService cadastrarSimulacaoService;
	
	@Autowired
	private BuscarSimulacaoService buscarSimulacaoService;
	
	@PostMapping
	public ResponseEntity<SimulacaoEntity> salvar(@RequestBody SimulacaoEntity simulacao) {
		
		cadastrarSimulacaoService.executar(simulacao);
		
		return buildResponse(simulacao);
	}
	
	@GetMapping("{documentoCliente}")
	public ResponseEntity<List<SimulacaoEntity>> buscarPorDocumento(@PathVariable String documentoCliente) {
		
		List<SimulacaoEntity> simulacoes = buscarSimulacaoService.executar(documentoCliente);
		return ResponseEntity.ok(simulacoes);
	}
	
	private ResponseEntity<SimulacaoEntity> buildResponse(SimulacaoEntity simulacao) {
		return ResponseEntity.created(URI.create(PathConstants.V1_SIMULACAO.concat("/").concat(simulacao.getCliente().getDocumento()))).build();
	}
}