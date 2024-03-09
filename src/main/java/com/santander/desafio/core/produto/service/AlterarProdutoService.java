package com.santander.desafio.core.produto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santander.desafio.core.produto.entity.ProdutoEntity;
import com.santander.desafio.core.produto.repository.ProdutoRepository;
import com.santander.desafio.core.shared.CasoUso;

@Service
public class AlterarProdutoService implements CasoUso<ProdutoEntity, Void> {
	
	@Autowired
	private ProdutoRepository repository;

	@Override
	public Void executar(ProdutoEntity produto) {
		
		repository.alterar(produto);
		
		return null;
	}
}