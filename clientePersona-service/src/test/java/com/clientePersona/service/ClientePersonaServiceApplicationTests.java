package com.clientePersona.service;

import com.clientePersona.service.modelos.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class ClientePersonaServiceApplicationTests {

//	@Test
//	void contextLoads() {
//	}

	@Test
	public void testCliente() {
		// Crear una instancia de Cliente simulada con Mockito
		Cliente cliente = Mockito.spy(new Cliente());

		// Configurar el comportamiento simulado
		Mockito.doReturn("1234").when(cliente).getContrasena();
		Mockito.doReturn("activo").when(cliente).getEstado();

		// Verificar los valores utilizando AssertJ
		assertThat(cliente.getContrasena()).isEqualTo("1234");
		assertThat(cliente.getEstado()).isEqualTo("activo");
	}


}
