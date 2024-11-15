package com.example.control2dba.controllers;

import com.example.control2dba.entities.NotaEntity;
import com.example.control2dba.services.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nota")
@CrossOrigin("*")
public class NotaController {

    @Autowired
    private NotaService notaService;

    // crea un usuario
    @PostMapping("/")
    public ResponseEntity<NotaEntity> saveNota(@RequestBody NotaEntity nota) {
        NotaEntity NewNota = notaService.saveNota(nota);
        return ResponseEntity.ok(NewNota);
    }

    // obtiene todos los clientes ingresados en la base de datos
    @GetMapping("/")
    public ResponseEntity<List<NotaEntity>> listNota() {
        List<NotaEntity> notas = notaService.getAllNotas();
        return ResponseEntity.ok(notas);
    }

    // Obtiene un cliente específico por su ID
    @GetMapping("/id-usuario/{id}")
    public ResponseEntity<NotaEntity> getNotaById(@PathVariable Integer id) {
        NotaEntity nota = notaService.getNotaById(id);
        if (nota != null) {
            return ResponseEntity.ok(nota);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // actualiza cliente

    @PutMapping("/")
    public ResponseEntity<NotaEntity> updateNota(@RequestBody NotaEntity nota) {
        boolean isUpdated = notaService.updateNota(nota);
        if (isUpdated) {
            return ResponseEntity.ok(nota);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Borra un cliente específico por su ID
    @DeleteMapping("/delete-nota/{id}")
    public ResponseEntity<Void> deleteUsuarioById(@PathVariable Integer id) throws Exception {
        boolean isDeleted = notaService.deleteNota(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

