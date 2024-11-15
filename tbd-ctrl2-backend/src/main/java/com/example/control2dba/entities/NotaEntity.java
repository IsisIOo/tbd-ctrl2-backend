package com.example.control2dba.entities;

import lombok.Data;

@Data
public class NotaEntity {

    private Integer id_nota;

    private Integer id_usuario;

    private String nombre_notas;

    private String contenido;

    private String fecha;

    private Boolean completa_check;

}
