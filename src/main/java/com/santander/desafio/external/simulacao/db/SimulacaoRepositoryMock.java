package com.santander.desafio.external.simulacao.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.santander.desafio.core.simulacao.entity.SimulacaoEntity;
import com.santander.desafio.core.simulacao.repository.SimulacaoRepository;

@Repository
public class SimulacaoRepositoryMock implements SimulacaoRepository {
	
	private Map<String, SimulacaoEntity> simulacoes = new HashMap<String, SimulacaoEntity>();

	@Override
	public void inserir(SimulacaoEntity simulacao) {
		simulacoes.put(simulacao.getCliente().getDocumento(), simulacao);
	}

	@Override
	public List<SimulacaoEntity> buscarPorCliente(String documentoCliente) {
		return simulacoes
				.entrySet()
				.stream()
				.filter(c -> c.getValue().getCliente().getDocumento().equals(documentoCliente))
				.map(map -> map.getValue())
				.collect(Collectors.toList());
	}
}