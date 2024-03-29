package com.santander.desafio.core.simulacao.repository;

import java.util.List;

import com.santander.desafio.core.simulacao.entity.SimulacaoEntity;

public interface SimulacaoRepository {
	
	void inserir(SimulacaoEntity simulacao);
	List<SimulacaoEntity> buscarPorCliente(String documentoCliente);
}