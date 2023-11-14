package com.clientePersona.service.repositorios;


import com.clientePersona.service.modelos.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
