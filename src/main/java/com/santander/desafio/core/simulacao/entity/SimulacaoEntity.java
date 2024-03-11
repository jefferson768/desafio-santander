package com.santander.desafio.core.simulacao.entity;

import java.util.List;
import java.util.UUID;

import com.santander.desafio.core.cliente.entity.ClienteEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SimulacaoEntity {
	
	private UUID id;
	
	private ClienteEntity cliente;
	
	private List<SimulacaoProdutoEntity> simulacoes;
}