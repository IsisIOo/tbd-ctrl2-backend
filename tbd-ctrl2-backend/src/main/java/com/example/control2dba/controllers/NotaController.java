package com.example.control2dba.controllers;

import com.example.control2dba.entities.NotaEntity;
import com.example.control2dba.services.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/nota")
@CrossOrigin("*")
public class NotaController {

    @Autowired
    private NotaService notaService;

    @PostMapping("/")
    public ResponseEntity<NotaEntity> saveNota(@RequestBody NotaEntity nota) {
        try {
            NotaEntity NewNota = notaService.saveNota(nota);
            if (NewNota == null) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(NewNota);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // Obtiene todos los clientes ingresados en la base de datos
    @GetMapping("/")
    public ResponseEntity<List<NotaEntity>> listNota() {
        try {
            List<NotaEntity> notas = notaService.getNotas();
            return ResponseEntity.ok(notas);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // Obtiene nota por un ID de nota
    @GetMapping("/id-nota/{id}")
    public ResponseEntity<NotaEntity> getNotaById(@PathVariable Integer id) {
        try {
            NotaEntity nota = notaService.getNotaById(id);
            if (nota != null) {
                return ResponseEntity.ok(nota);
            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // Actualiza nota
    @PutMapping("/")
    public ResponseEntity<NotaEntity> updateNota(@RequestBody NotaEntity nota) {
        try {
            boolean isUpdated = notaService.updateNota(nota);
            if (isUpdated) {
                return ResponseEntity.ok(nota);
            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // Borra un cliente específico por su ID
    @DeleteMapping("/delete-nota/{id}")
    public ResponseEntity<Void> deleteUsuarioById(@PathVariable Integer id) throws Exception {
        try {
            boolean isDeleted = notaService.deleteNota(id);
            if (isDeleted) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


    // Devuelve todas las notas de un cliente
    @GetMapping("/notas-usuario/{id}")
    public ResponseEntity<List<NotaEntity>> getNotasByCliente(@PathVariable Integer id) {
        try {
            List<NotaEntity> notas = notaService.findByIdUsuario(id);
            return ResponseEntity.ok(notas);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // Busca tareas por filtros
    @PostMapping("/buscar-tareas")
    public ResponseEntity<List<NotaEntity>> buscarTareas(@RequestBody Map<String, Object> body) {
        try {
            // Obtener los valores del cuerpo de la solicitud con valores predeterminados
            Boolean completaCheckNota = body.containsKey("completa_check_nota") ? (Boolean) body.get("completa_check_nota") : null;
            String nombreNota = (String) body.getOrDefault("nombre_nota", "");
            String contenidoNota = (String) body.getOrDefault("contenido_nota", "");
            Integer idUsuario = (Integer) body.getOrDefault("id_usuario", null);

            // Validar el parámetro idUsuario
            if (idUsuario == null) {
                return ResponseEntity.badRequest().body(null);
            }

            System.out.println("completaCheckNota: " + completaCheckNota);
            System.out.println("nombreNota: " + nombreNota);
            System.out.println("contenidoNota: " + contenidoNota);
            System.out.println("idUsuario: " + idUsuario);

            // Llamar al servicio
            List<NotaEntity> notas = notaService.buscarTareas(completaCheckNota, nombreNota, contenidoNota, idUsuario);
            return ResponseEntity.ok(notas);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}

