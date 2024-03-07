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
		clientes.put(cliente.getNome(), cliente);
		
	}

	@Override
	public void alterar(ClienteEntity cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(ClienteEntity cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClienteEntity buscarPorNome(String nome) {
		return clientes.get(nome);
	}
}