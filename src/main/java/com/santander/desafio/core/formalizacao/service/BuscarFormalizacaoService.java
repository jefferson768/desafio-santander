package com.santander.desafio.core.formalizacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santander.desafio.core.formalizacao.entity.FormalizacaoEntity;
import com.santander.desafio.core.formalizacao.repository.FormalizacaoRepository;
import com.santander.desafio.core.shared.CasoUso;

@Service
public class BuscarFormalizacaoService implements CasoUso<String, List<FormalizacaoEntity>> {
	
	@Autowired
	private FormalizacaoRepository repository;

	@Override
	public List<FormalizacaoEntity> executar(String documentoCliente) {
		return repository.buscarPorCliente(documentoCliente);
	}
}