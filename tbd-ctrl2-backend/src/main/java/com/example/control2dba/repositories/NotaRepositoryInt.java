package com.example.control2dba.repositories;

import com.example.control2dba.entities.NotaEntity;

import java.util.List;

public interface NotaRepositoryInt {
    // Método para guardar una nota
    NotaEntity saveNota(NotaEntity nota);

    // Método para obtener todas las categorías
    List<NotaEntity> getNotas();

    // Método para encontrar una categoría por su ID
    NotaEntity findByIdNota(Integer id);

    // Metodo para encontrar las tareas por el id del usuario
    List<NotaEntity> findByIdUsuario(Integer id_usuario);

    // Método para eliminar una categoría por su ID
    boolean deleteNota(Integer id);

    // Método para actualizar una categoría
    boolean updateNota(NotaEntity nota);

    List<NotaEntity> buscarPorFiltros(Boolean check, String nombre, String contenido, Integer id_usuario);
}
