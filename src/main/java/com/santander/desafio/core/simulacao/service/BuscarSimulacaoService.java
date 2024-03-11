package com.santander.desafio.core.simulacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santander.desafio.core.shared.CasoUso;
import com.santander.desafio.core.simulacao.entity.SimulacaoEntity;
import com.santander.desafio.core.simulacao.repository.SimulacaoRepository;

@Service
public class BuscarSimulacaoService implements CasoUso<String, List<SimulacaoEntity>> {
	
	@Autowired
	private SimulacaoRepository repository;

	@Override
	public List<SimulacaoEntity> executar(String documentoCliente) {
		return repository.buscarPorCliente(documentoCliente);
	}
}