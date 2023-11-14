package com.clientePersona.service.controladores;

import com.clientePersona.service.modelos.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.clientePersona.service.servicios.PersonaService;

import java.util.List;

//@RestController
//@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public List<Persona> getAllPersonas() {
        return personaService.getAllPersonas();
    }

    @GetMapping("/{id}")
    public Persona getPersona(@PathVariable String id) {
        return personaService.getPersona(id);
    }

    @PostMapping
    public Persona createPersona(@RequestBody Persona persona) {
        return personaService.createPersona(persona);
    }

    @PutMapping("/{id}")
    public Persona updatePersona(@PathVariable String id, @RequestBody Persona persona) {
        return personaService.updatePersona(id, persona);
    }

    @PatchMapping("/{id}")
    public Persona partialUpdatePersona(@PathVariable String id, @RequestBody Persona persona) {
        return personaService.partialUpdatePersona(id, persona);
    }

    @DeleteMapping("/{id}")
    public void deletePersona(@PathVariable String id) {
        personaService.deletePersona(id);
    }
}

