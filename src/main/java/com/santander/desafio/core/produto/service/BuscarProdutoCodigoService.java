package com.santander.desafio.core.produto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santander.desafio.core.produto.entity.ProdutoEntity;
import com.santander.desafio.core.produto.repository.ProdutoRepository;
import com.santander.desafio.core.shared.CasoUso;

@Service
public class BuscarProdutoCodigoService implements CasoUso<String, ProdutoEntity> {
	
	@Autowired
	private ProdutoRepository repository;

	@Override
	public ProdutoEntity executar(String codigo) {
		return repository.buscarPorCodigo(codigo);
	}
}