package com.example.control2dba.controllers;

import com.example.control2dba.dtos.TokenResponseDTO;
import com.example.control2dba.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDTO> login(@RequestBody Map<String, Object> payload){
        TokenResponseDTO tokenResponseDTO = authService.authenticate(
                (String) payload.get("username"),
                (String) payload.get("password")
        );
        return ResponseEntity.ok(tokenResponseDTO);
    }
}
