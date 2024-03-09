package com.santander.desafio.core.produto.repository;

import com.santander.desafio.core.produto.entity.ProdutoEntity;

public interface ProdutoRepository {

	void inserir(ProdutoEntity cliente);
	void alterar(ProdutoEntity cliente);
	void excluir(String codigo);
	ProdutoEntity buscarPorCodigo(String codigo);
}