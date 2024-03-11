package com.santander.desafio.core.simulacao.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santander.desafio.core.shared.CasoUso;
import com.santander.desafio.core.simulacao.entity.SimulacaoEntity;
import com.santander.desafio.core.simulacao.repository.SimulacaoRepository;

@Service
public class CadastrarSimulacaoService implements CasoUso<SimulacaoEntity, Void> {
	
	@Autowired
	private SimulacaoRepository repository;

	@Override
	public Void executar(SimulacaoEntity simulacao) {
		
		simulacao.setId(UUID.randomUUID());
		repository.inserir(simulacao);
		
		return null;
	}
}