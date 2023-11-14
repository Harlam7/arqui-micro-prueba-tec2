package com.clientePersona.service.servicios;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PersonaClienteConsumer {

    @KafkaListener(topics = "clientePersona-topic", groupId = "clientePersona")
    public void recibirMensaje(String mensaje) {
        // Lógica para procesar el mensaje recibido
        System.out.println("Mensaje recibido en clientePersona-service: " + mensaje);
    }

}
