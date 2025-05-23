package com.example.seguridad;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controllersaludar {
    @GetMapping("/saludo") //imperativo
    public String saludar() {
        return "Hola, bienvenido a la aplicación de saludo1!";
    }


    @GetMapping(value = "/hello", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> hello(@RequestHeader(name = HttpHeaders.FROM, required = false) String from) {
        return from == null ? ResponseEntity.ok("Hello") : ResponseEntity.ok(String.format("Hello %s!", from));
    }
}
