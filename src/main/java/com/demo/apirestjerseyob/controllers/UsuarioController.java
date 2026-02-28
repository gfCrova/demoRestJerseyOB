package com.demo.apirestjerseyob.controllers;

import com.demo.apirestjerseyob.models.Usuario;
import com.demo.apirestjerseyob.services.UsuarioService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController // Anotación para indicar que esta clase es un controlador REST
@Path("/")
public class UsuarioController {

    private final UsuarioService usuarioService; // Inyección de dependencia del servicio de usuario

    // Constructor para inyectar el servicio de usuario
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
        // Algunos usuarios de ejemplo al servicio
        this.usuarioService.addUser(new Usuario("Juan", "Perez", 34));
        this.usuarioService.addUser(new Usuario("Florencia", "Fernandez", 19));
        this.usuarioService.addUser(new Usuario("Viktor", "Moreno", 41));
        this.usuarioService.addUser(new Usuario("Natalia", "Sosa", 28));
    }

    // Metodo para obtener todos los usuarios utilizando el metodo GET
    @GET
    @Path("/usuarios")
    @Produces("application/json") // Especifica que la respuesta será en formato JSON
    public List<Usuario> getUsuario() {
        return usuarioService.getAllUsers();
    }

    // Metodo para obtener un usuario por su nombre utilizando un parámetro de ruta
    @GET
    @Path("/usuarios/{nombre}")
    @Produces("application/json")
    public Response getUsuarioByNombre(@PathParam("nombre") String nombre) {
        Usuario usuario = usuarioService.getUserByName(nombre);
        if (usuario != null) {
            return Response.ok(usuario).build(); // Devuelve código 200 OK con el usuario encontrado
        }
        return Response.status(Response.Status.NOT_FOUND).build(); // Devuelve código 404 Not Found
    }

    // Metodo para agregar un nuevo usuario utilizando el metodo POST
    @POST
    @Path("/usuarios")
    @Produces("application/json")
    @Consumes("application/json")
    public Response addUsuario(Usuario usuario) {
        usuarioService.addUser(usuario);
        return Response.created(
                URI.create("/usuarios/" + usuario.getNombre() + "-" + usuario.getApellido() + "-" + usuario.getEdad())
        ).build(); // Devuelve una respuesta con el código 201 Created
    }
}
