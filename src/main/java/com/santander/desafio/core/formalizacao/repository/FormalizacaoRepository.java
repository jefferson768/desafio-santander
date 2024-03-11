package com.santander.desafio.core.formalizacao.repository;

import java.util.List;

import com.santander.desafio.core.formalizacao.entity.FormalizacaoEntity;

public interface FormalizacaoRepository {
	
	void inserir(FormalizacaoEntity formalizacao);
	List<FormalizacaoEntity> buscarPorCliente(String documentoCliente);
}