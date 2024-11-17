package com.example.control2dba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import com.example.control2dba.dtos.TokenResponseDTO;

@Service
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtUtil;

    @Autowired
    public AuthService(AuthenticationManager authenticationManager, JwtService jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    public TokenResponseDTO authenticate(String username, String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username,
                        password
                )
        );

        String jwtToken = jwtUtil.generateToken(username);
        String jwtRefreshToken = jwtUtil.generateRefreshToken(username);
        return new TokenResponseDTO(jwtToken, jwtRefreshToken);

    }
}
