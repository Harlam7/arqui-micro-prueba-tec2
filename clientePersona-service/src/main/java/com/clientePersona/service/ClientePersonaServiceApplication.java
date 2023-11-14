package com.clientePersona.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.core.KafkaTemplate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@SpringBootApplication
@ComponentScan(basePackages = "com.clientePersona.service.kafka")
public class ClientePersonaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientePersonaServiceApplication.class, args);

		Connection bd = ConectarBD();
	}

	@Bean
	CommandLineRunner init(KafkaTemplate<String, String> kafkaTemplate){
		return args -> {
			kafkaTemplate.send("clientePersona-topic", "Hola, funcionando desde clientePersona");
		};
	}

	public static Connection ConectarBD() {
		Connection conexion;
		String host = "jdbc:postgresql://localhost/"; //dependendio de la ip}
		String user = "postgres";
		String pass = "12345";
		String bd = "BaseDatos";

		System.out.println("Conectando...");

		try {
			conexion = DriverManager.getConnection(host+bd, user, pass);
			System.out.println("Se ha hecho la conexión");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
		return conexion;
	}

}
