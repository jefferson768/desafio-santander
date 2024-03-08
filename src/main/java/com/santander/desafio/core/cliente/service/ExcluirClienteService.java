package com.santander.desafio.core.cliente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santander.desafio.core.cliente.repository.ClienteRepository;
import com.santander.desafio.core.shared.CasoUso;

@Service
public class ExcluirClienteService implements CasoUso<String, Void> {
	
	@Autowired
	private ClienteRepository repository;

	@Override
	public Void executar(String documento) {
		
		repository.excluir(documento);
		
		return null;
	}
}