package com.demo.apirestjerseyob.controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.springframework.stereotype.Component;

@Component
@Path("/")
public class MainController {
    @GET
    public String getMessage() {
            return "Hello, World!";
        }
}
