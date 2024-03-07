package com.santander.desafio.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/clientes")
public class ClienteController {
	
	@GetMapping
	public ResponseEntity teste() {
		
		Teste teste = Teste
				.builder()
				.nome("Teste")
				.email("Teste")
				.build();
		
		return ResponseEntity.ok(teste);
	}
}