package com.santander.desafio.core.cliente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santander.desafio.core.cliente.entity.ClienteEntity;
import com.santander.desafio.core.cliente.repository.ClienteRepository;
import com.santander.desafio.core.shared.CasoUso;

@Service
public class BuscarClienteDocumentoService implements CasoUso<String, ClienteEntity> {
	
	@Autowired
	private ClienteRepository repository;

	@Override
	public ClienteEntity executar(String documento) {
		return repository.buscarPorDocumento(documento);
	}
}