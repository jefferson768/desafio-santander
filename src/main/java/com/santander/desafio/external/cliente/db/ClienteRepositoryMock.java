package com.santander.desafio.external.cliente.db;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.santander.desafio.core.cliente.entity.ClienteEntity;
import com.santander.desafio.core.cliente.repository.ClienteRepository;

@Repository
public class ClienteRepositoryMock implements ClienteRepository {
	
	private Map<String, ClienteEntity> clientes = new HashMap<String, ClienteEntity>();

	@Override
	public void inserir(ClienteEntity cliente) {
		clientes.put(cliente.getDocumento(), cliente);
	}

	@Override
	public void alterar(ClienteEntity cliente) {
		clientes.replace(cliente.getDocumento(), cliente);
	}

	@Override
	public void excluir(String documento) {
		clientes.remove(documento);
		
	}

	@Override
	public ClienteEntity buscarPorDocumento(String documento) {
		return clientes.get(documento);
	}
}