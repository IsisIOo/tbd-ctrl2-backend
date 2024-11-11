package com.example.control2dba.repositories;

import com.example.control2dba.entities.UsuarioEntity;

import java.util.List;

public interface UsuarioRepositoryInt {
    UsuarioEntity saveUsuario(UsuarioEntity usuario);

    List<UsuarioEntity> getUsuarios();

    boolean deleteUsuario(Integer id);

    UsuarioEntity getUsuarioById(Integer id);

    boolean updateUsuario(UsuarioEntity usuario);
}
