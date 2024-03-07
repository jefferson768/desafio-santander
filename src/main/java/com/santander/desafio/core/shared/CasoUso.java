package com.santander.desafio.core.shared;

public interface CasoUso<E, S> {

	S executar(E entrada);
}