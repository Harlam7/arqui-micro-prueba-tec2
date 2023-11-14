package com.clientePersona.service.repositorios;


import com.clientePersona.service.modelos.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Object> findByClienteId(Long aLong);
}
