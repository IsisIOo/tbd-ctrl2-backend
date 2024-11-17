package com.example.control2dba.entities;

import lombok.Data;

import java.time.LocalDate;


@Data
public class NotaEntity {

    private Integer id_nota;

    private Integer id_usuario;

    private String nombre_nota;

    private String contenido_nota;

    private LocalDate fecha_nota;

    private Boolean completa_check_nota;

}
