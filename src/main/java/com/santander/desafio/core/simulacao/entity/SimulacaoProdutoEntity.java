package com.santander.desafio.core.simulacao.entity;

import java.util.UUID;

import com.santander.desafio.core.cliente.entity.ClienteEntity;
import com.santander.desafio.core.produto.entity.ProdutoEntity;

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
public class SimulacaoProdutoEntity {
	
	private UUID id;
	
	private String taxa;
	
	private ClienteEntity cliente;
	
	private ProdutoEntity produto;
}