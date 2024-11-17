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
    @PostMapping("/register")
    public ResponseEntity<UsuarioEntity> saveUsuario(@RequestBody UsuarioEntity usuario) {
        try {
            UsuarioEntity NewUsuario = usuarioService.createUsuario(usuario);
            if (NewUsuario != null) {
                return ResponseEntity.ok(NewUsuario);
            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

    }
    // obtiene todos los clientes ingresados en la base de datos
    @GetMapping("/")
    public ResponseEntity<List<UsuarioEntity>> listUsuario() {
        try {
            List<UsuarioEntity> usuarios = usuarioService.getAllUsuarios();
            if (usuarios.isEmpty()) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.ok(usuarios);
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // Obtiene un cliente específico por su ID
    @GetMapping("/id-usuario/{id}")
    public ResponseEntity<UsuarioEntity> getUsuarioById(@PathVariable Integer id) {
        try {
            UsuarioEntity usuario = usuarioService.getUsuarioById(id);
            if (usuario != null) {
                return ResponseEntity.ok(usuario);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // actualiza cliente

    @PutMapping("/")
    public ResponseEntity<UsuarioEntity> updateUsuario(@RequestBody UsuarioEntity usuario) {
        try {
            boolean isUpdated = usuarioService.updateUsuario(usuario);
            if (isUpdated) {
                return ResponseEntity.ok(usuario);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // Borra un cliente específico por su ID
    @DeleteMapping("/delete-usuario/{id}")
    public ResponseEntity<Void> deleteUsuarioById(@PathVariable Integer id) throws Exception {
        try {
            boolean isDeleted = usuarioService.deleteUsuario(id);
            if (isDeleted) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

}
