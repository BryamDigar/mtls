package com.example.clienteseguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class ControllerCliente{
    @Autowired
    WebClient webClient;

    @GetMapping("/https")
    public String obtenerSaludo() {
        return webClient.get()
                .uri("https://localhost:8075/hello")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    // Endpoint que puede ser consumido por otros servicios para probar la conexión mTLS
    @GetMapping("/connect")
    public String testConnection() {
        return "Conexión mTLS establecida con éxito desde el puerto " ;
    }
}