package com.santander.desafio.external.produto.db;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.santander.desafio.core.produto.entity.ProdutoEntity;
import com.santander.desafio.core.produto.repository.ProdutoRepository;

@Repository
public class ProdutoRepositoryMock implements ProdutoRepository {
	
	private Map<String, ProdutoEntity> produtos = new HashMap<String, ProdutoEntity>();

	@Override
	public void inserir(ProdutoEntity produto) {
		produtos.put(produto.getCodigo(), produto);
	}

	@Override
	public void alterar(ProdutoEntity produto) {
		produtos.replace(produto.getCodigo(), produto);
	}

	@Override
	public void excluir(String codigo) {
		produtos.remove(codigo);
		
	}

	@Override
	public ProdutoEntity buscarPorCodigo(String codigo) {
		return produtos.get(codigo);
	}
}