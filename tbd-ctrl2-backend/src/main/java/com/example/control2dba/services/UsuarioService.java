package com.example.control2dba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.control2dba.entities.UsuarioEntity;
import com.example.control2dba.repositories.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioEntity createUsuario(UsuarioEntity usuario) {
        return usuarioRepository.saveUsuario(usuario);
    }

    public List<UsuarioEntity> getAllUsuarios() {
        return usuarioRepository.getUsuarios();
    }

    public UsuarioEntity getUsuarioById(Integer id) {
        UsuarioEntity usuario = usuarioRepository.getUsuarioById(id);
        return usuario;
    }

    public boolean deleteUsuario(Integer id) throws Exception {
        try {
            Boolean response = usuarioRepository.deleteUsuario(id);
            if (response) {
                return true;
            } else {
                throw new Exception("No se pudo eliminar el usuario");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateUsuario(UsuarioEntity usuario) {
        // vemos si el cliente existe en la base de datos
        if (usuarioRepository.getUsuarioById(usuario.getId_usuario()) != null) {
            // actualizamos el cliente usando el método del repositorio
            return usuarioRepository.updateUsuario(usuario);
        }
        return false;
    }

}