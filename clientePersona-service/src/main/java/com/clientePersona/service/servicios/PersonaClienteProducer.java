package com.clientePersona.service.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PersonaClienteProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void enviarMensaje(String mensaje) {
        kafkaTemplate.send("clientePersona-topic", mensaje);
    }



}

