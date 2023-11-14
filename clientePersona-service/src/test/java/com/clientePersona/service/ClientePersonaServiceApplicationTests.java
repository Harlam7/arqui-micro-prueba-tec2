package com.clientePersona.service;

import com.clientePersona.service.modelos.Cliente;
import com.clientePersona.service.repositorios.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class ClientePersonaServiceApplicationTests {

//	@Test
//	void contextLoads() {
//	}

	//#F5: Pruebas unitarias: Implementar 1 prueba unitaria para la entidad de dominio Cliente

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
	//#F6: Pruebas de Integración: Implementar 1 prueba de integración.

	//@Autowired
	private ClienteRepository clienteRepository;

	@Test
	public void testCrearCliente() {
		// Crear un objeto Cliente
		Cliente cliente = new Cliente();
		cliente.setId(Long.valueOf("11112785"));
		cliente.setContrasena("1234");
		cliente.setEstado("Activo");

		// Guardar el cliente en la base de datos
		clienteRepository.save(cliente);

		// Recuperar el cliente de la base de datos
		Cliente clienteRecuperado = (Cliente) clienteRepository.findByClienteId(Long.valueOf("123")).orElse(null);

		// Verificar que el cliente recuperado sea igual al cliente original
		assertEquals("password", clienteRecuperado.getContrasena());
		assertEquals("activo", clienteRecuperado.getEstado());
	}



}
