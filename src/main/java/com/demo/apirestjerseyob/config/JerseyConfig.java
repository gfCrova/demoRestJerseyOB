package com.demo.apirestjerseyob.config;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@ApplicationPath("/") // Define la ruta base para los recursos REST
@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        // Registrar los paquetes donde se encuentran los recursos REST
        packages("com.demo.apirestjerseyob.controllers");
    }
}
