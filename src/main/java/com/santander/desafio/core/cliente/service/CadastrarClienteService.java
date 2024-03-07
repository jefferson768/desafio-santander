package com.santander.desafio.core.cliente.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santander.desafio.core.cliente.entity.ClienteEntity;
import com.santander.desafio.core.cliente.repository.ClienteRepository;
import com.santander.desafio.core.shared.CasoUso;

@Service
public class CadastrarClienteService implements CasoUso<ClienteEntity, Void> {
	
	@Autowired
	private ClienteRepository repository;

	@Override
	public Void executar(ClienteEntity cliente) {
		
		cliente.setId(UUID.randomUUID());
		repository.inserir(cliente);
		
		return null;
	}
}