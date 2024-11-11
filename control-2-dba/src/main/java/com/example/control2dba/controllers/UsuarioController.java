package com.example.control2dba.controllers;

import com.example.control2dba.entities.UsuarioEntity;
import com.example.control2dba.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // crea un usuario
    @PostMapping("/")
    public ResponseEntity<UsuarioEntity> saveUsuario(@RequestBody UsuarioEntity usuario) {
        UsuarioEntity NewUsuario = usuarioService.createUsuario(usuario);
        return ResponseEntity.ok(NewUsuario);
    }
    // obtiene todos los clientes ingresados en la base de datos
    @GetMapping("/")
    public ResponseEntity<List<UsuarioEntity>> listUsuario() {
        List<UsuarioEntity> usuarios = usuarioService.getAllUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    // Obtiene un cliente específico por su ID
    @GetMapping("/id-usuario/{id}")
    public ResponseEntity<UsuarioEntity> getUsuarioById(@PathVariable Integer id) {
        UsuarioEntity usuario = usuarioService.getUsuarioById(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // actualiza cliente

    @PutMapping("/")
    public ResponseEntity<UsuarioEntity> updateUsuario(@RequestBody UsuarioEntity usuario) {
        boolean isUpdated = usuarioService.updateUsuario(usuario);
        if (isUpdated) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Borra un cliente específico por su ID
    @DeleteMapping("/delete-usuario/{id}")
    public ResponseEntity<Void> deleteUsuarioById(@PathVariable Integer id) throws Exception {
        boolean isDeleted = usuarioService.deleteUsuario(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
