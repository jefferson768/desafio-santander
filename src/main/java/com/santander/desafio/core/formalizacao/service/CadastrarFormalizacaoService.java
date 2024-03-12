package com.santander.desafio.core.formalizacao.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santander.desafio.core.formalizacao.entity.FormalizacaoEntity;
import com.santander.desafio.core.formalizacao.repository.FormalizacaoRepository;
import com.santander.desafio.core.shared.CasoUso;

@Service
public class CadastrarFormalizacaoService implements CasoUso<FormalizacaoEntity, Void> {
	
	@Autowired
	private FormalizacaoRepository repository;

	@Override
	public Void executar(FormalizacaoEntity formalizacao) {
		
		formalizacao.setId(UUID.randomUUID());
		repository.inserir(formalizacao);
		
		return null;
	}
}