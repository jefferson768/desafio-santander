package com.santander.desafio.cliente.service;

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
import com.santander.desafio.core.cliente.service.BuscarClienteDocumentoService;
import com.santander.desafio.utils.GenericUtils;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class BuscarClienteDocumentoServiceTest {
	
	@Mock
	private ClienteRepository repository;

	@InjectMocks
	BuscarClienteDocumentoService buscarClienteDocumentoService;
	
	@Test
	public void shouldExecutar() throws IOException {
		
		ClienteEntity cliente = GenericUtils.getMockContent("src/test/resources/json/cliente/consultarCliente.json", ClienteEntity.class);

		when(repository.buscarPorDocumento(any())).thenReturn((cliente));

		ClienteEntity clienteSalvo = buscarClienteDocumentoService.executar("1234");

		assertEquals(clienteSalvo.getDocumento(), "1234");
	}
}
