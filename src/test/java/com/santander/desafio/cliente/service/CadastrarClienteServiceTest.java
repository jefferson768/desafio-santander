package com.santander.desafio.cliente.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.santander.desafio.core.cliente.entity.ClienteEntity;
import com.santander.desafio.core.cliente.repository.ClienteRepository;
import com.santander.desafio.core.cliente.service.CadastrarClienteService;
import com.santander.desafio.utils.GenericUtils;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CadastrarClienteServiceTest {
	
	@Mock
	private ClienteRepository repository;

	@InjectMocks
	CadastrarClienteService cadastrarClienteService;
	
	@Test
	public void shouldExecutar() throws IOException {

		ClienteEntity cliente = GenericUtils.getMockContent("src/test/resources/json/cliente/incluirCliente.json", ClienteEntity.class);
	
		cadastrarClienteService.executar(cliente);
		
		assertThat(cliente.getId() != null);
	}
}
