package com.santander.desafio.core.produto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santander.desafio.core.produto.repository.ProdutoRepository;
import com.santander.desafio.core.shared.CasoUso;

@Service
public class ExcluirProdutoService implements CasoUso<String, Void> {
	
	@Autowired
	private ProdutoRepository repository;

	@Override
	public Void executar(String codigo) {
		
		repository.excluir(codigo);
		
		return null;
	}
}