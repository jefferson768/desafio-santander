package com.santander.desafio.core.cliente.entity;

import java.util.UUID;

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
public class ClienteEntity {
	
	private UUID id;
	private String nome;
	private String tipo;
	private String documento;
}