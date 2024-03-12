package com.santander.desafio.cliente.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.santander.desafio.core.cliente.repository.ClienteRepository;
import com.santander.desafio.core.cliente.service.ExcluirClienteService;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ExcluirClienteServiceTest {
	
	@Mock
	private ClienteRepository repository;

	@InjectMocks
	ExcluirClienteService excluirClienteService;
	
	@Test
	public void shouldExecutar() throws IOException {
		excluirClienteService.executar("1234");
		verify(repository, times(1)).excluir("1234");
	}
}