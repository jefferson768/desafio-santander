package com.santander.desafio.external.simulacao.db;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.santander.desafio.core.simulacao.entity.SimulacaoEntity;
import com.santander.desafio.core.simulacao.repository.SimulacaoRepository;

@Repository
public class SimulacaoRepositoryMock implements SimulacaoRepository {
	
	private List<SimulacaoEntity> simulacoes = new ArrayList<>();
	
	@Override
	public void inserir(SimulacaoEntity simulacao) {
		simulacoes.add(simulacao);
	}

	@Override
	public List<SimulacaoEntity> buscarPorCliente(String documentoCliente) {
		return simulacoes
				.stream()
				.filter((SimulacaoEntity simulacao) -> simulacao.getCliente().getDocumento().equals(documentoCliente))
				.collect(Collectors.toList());
	}
}