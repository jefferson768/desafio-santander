package com.santander.desafio.core.cliente.repository;

import com.santander.desafio.core.cliente.entity.ClienteEntity;

public interface ClienteRepository {

	void inserir(ClienteEntity cliente);
	void alterar(ClienteEntity cliente);
	void excluir(String documento);
	ClienteEntity buscarPorDocumento(String documento);
}