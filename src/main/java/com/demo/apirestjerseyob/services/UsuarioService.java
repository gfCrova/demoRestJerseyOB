package com.demo.apirestjerseyob.services;

import com.demo.apirestjerseyob.models.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    private final List<Usuario> users = new ArrayList<>(); // Lista para almacenar los usuarios

    public List<Usuario> getAllUsers() {
        return users; // Devuelve la lista de usuarios
    }

    public Usuario getUserByName(String nombre) {
        for (Usuario usuario : users) {
            if (usuario.getNombre().equalsIgnoreCase(nombre)) {
                return usuario; // Devuelve el usuario encontrado
            }
        }
        return null;
    }

    public void addUser(Usuario usuario) {
        users.add(usuario); // Agrega un nuevo usuario a la lista
    }
}
