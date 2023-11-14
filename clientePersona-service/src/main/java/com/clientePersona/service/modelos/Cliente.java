package com.clientePersona.service.modelos;

import javax.persistence.*;

// Clase Cliente que hereda de Persona
@Entity
@Table(name = "cliente")
@PrimaryKeyJoinColumn(name = "clienteid")
public class Cliente extends Persona {

    @Column(nullable = false)
    private String contrasena;

    @Column(nullable = false)
    private String estado;

    // getters y setters

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
