package com.example.control2dba.services;

import com.example.control2dba.config.JwtUtil;
import com.example.control2dba.entities.UsuarioEntity;
import com.example.control2dba.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import com.example.control2dba.dtos.TokenResponseDTO;

@Service
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthService(AuthenticationManager authenticationManager, UsuarioRepository usuarioRepository, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
        this.jwtUtil = jwtUtil;
    }

    public TokenResponseDTO authenticate(String username, String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        UsuarioEntity user = usuarioRepository.getUsuarioId(username);
        String jwtToken = jwtUtil.create(username);
        String jwtRefreshToken = jwtUtil.createRefresh(username);
        return new TokenResponseDTO(jwtToken, jwtRefreshToken);

    }
}
