package com.jdc.dulcealmibar.service;

import com.jdc.dulcealmibar.entity.Rol;
import com.jdc.dulcealmibar.entity.Usuario;
import com.jdc.dulcealmibar.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario registrarCliente(Usuario usuario) {

        if (usuarioRepository.existsByCorreo(usuario.getCorreo())) {
            throw new RuntimeException("El correo ya está registrado");
        }

        usuario.setRol(Rol.CLIENTE);

        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    public Usuario validarLogin(String correo, String password) {

        Optional<Usuario> usuarioOptional = usuarioRepository.findByCorreo(correo);

        if (usuarioOptional.isEmpty()) {
            throw new RuntimeException("El correo no existe");
        }

        Usuario usuario = usuarioOptional.get();

        if (!usuario.getPassword().equals(password)) {
            throw new RuntimeException("La contraseña es incorrecta");
        }

        return usuario;
    }

    public Usuario crearAdministrador(Usuario usuario) {

        if (usuarioRepository.existsByCorreo(usuario.getCorreo())) {
            throw new RuntimeException("El correo ya está registrado");
        }

        usuario.setRol(Rol.ADMIN);

        return usuarioRepository.save(usuario);
    }
}