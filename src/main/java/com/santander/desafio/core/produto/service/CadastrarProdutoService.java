package com.santander.desafio.core.produto.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santander.desafio.core.produto.entity.ProdutoEntity;
import com.santander.desafio.core.produto.repository.ProdutoRepository;
import com.santander.desafio.core.shared.CasoUso;

@Service
public class CadastrarProdutoService implements CasoUso<ProdutoEntity, Void> {
	
	@Autowired
	private ProdutoRepository repository;

	@Override
	public Void executar(ProdutoEntity produto) {
		
		produto.setId(UUID.randomUUID());
		repository.inserir(produto);
		
		return null;
	}
}