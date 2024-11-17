package com.example.control2dba.entities;

import lombok.Data;


@Data
public class UsuarioEntity {

    private Integer id_usuario;

    private String nombre;

    private String email;

    private String contrasena;
}
