package com.example.control2dba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.control2dba.entities.CategoriaEntity;
import com.example.control2dba.repositories.CategoriaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;

    public CategoriaEntity saveCategoria(CategoriaEntity categoria){
        return categoriaRepository.saveCategoria(categoria);
    }

    public ArrayList<CategoriaEntity> getCategorias(){
        return (ArrayList<CategoriaEntity>) categoriaRepository.getCategorias();
    }

    public CategoriaEntity getCategoryById(int id) {
        return categoriaRepository.findByIdCategoria(id);
    }  
     public List<CategoriaEntity> getAllCategorias() {
        return categoriaRepository.getCategorias();
    }

    public boolean updateCategoria(CategoriaEntity categoria) {
        // vemos si categoria existe en la base de datos
        if (categoriaRepository.findByIdCategoria(categoria.getId_categoria()) != null) {
            // actualizamos el categoria usando el método del repositorio
            return categoriaRepository.updateCategoria(categoria);
        }
        return false;
    }

    public boolean deleteCategoria(int id) throws Exception {
        try{
            categoriaRepository.deleteCategoria(id);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


}
