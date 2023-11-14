package com.clientePersona.service.controladores;

import com.clientePersona.service.modelos.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.clientePersona.service.servicios.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Manejo del verbo GET
    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @GetMapping("/{id}")
    public Cliente getCliente(@PathVariable Long id) {
        return clienteService.getCliente(id);
    }

    // Manejo del verbo POST
    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteService.createCliente(cliente);
    }

    // Manejo del verbo PUT
    @PutMapping("/{id}")
    public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.updateCliente(id, cliente);
    }

    // Manejo del verbo PATCH
    @PatchMapping("/{id}")
    public Cliente partialUpdateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.partialUpdateCliente(id, cliente);
    }

    // Manejo del verbo DELETE
    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
    }
}
