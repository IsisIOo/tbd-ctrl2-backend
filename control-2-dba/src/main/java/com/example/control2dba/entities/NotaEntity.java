package com.example.control2dba.entities;

import lombok.Data;

@Data
public class NotaEntity {

    private Integer id_nota;

    private String nombre_notas;

    private String contenido;

    private String fecha;
}
