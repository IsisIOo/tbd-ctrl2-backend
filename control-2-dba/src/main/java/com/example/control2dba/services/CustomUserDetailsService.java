package com.example.control2dba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.control2dba.entities.UsuarioEntity;
import com.example.control2dba.repositories.UsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioEntity usuarioEntity = usuarioRepository.getUsuarioId(username);
        if (usuarioEntity == null) {
            throw new UsernameNotFoundException("User not found.");
        }
        return User.builder()
                .username(usuarioEntity.getNombre())
                .password(usuarioEntity.getContrasena()) // Asegúrate de que la contraseña esté encriptada
                .build();
    }
}