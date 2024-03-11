package com.santander.desafio.external.formalizacao.db;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.santander.desafio.core.formalizacao.entity.FormalizacaoEntity;
import com.santander.desafio.core.formalizacao.repository.FormalizacaoRepository;

@Repository
public class FormalizacaoRepositoryMock implements FormalizacaoRepository {
	
	private List<FormalizacaoEntity> formalizacoes = new ArrayList<>();
	
	@Override
	public void inserir(FormalizacaoEntity formalizacao) {
		formalizacoes.add(formalizacao);
	}

	@Override
	public List<FormalizacaoEntity> buscarPorCliente(String documentoCliente) {
		return formalizacoes
				.stream()
				.filter((FormalizacaoEntity formalizacao) -> formalizacao.getCliente().getDocumento().equals(documentoCliente))
				.collect(Collectors.toList());
	}
}