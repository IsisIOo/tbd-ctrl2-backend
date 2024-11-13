package com.example.control2dba.services;

import com.example.control2dba.entities.NotaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.control2dba.repositories.NotaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotaService {
    @Autowired
    NotaRepository notaRepository;

    public NotaEntity saveNota(NotaEntity nota){
        return notaRepository.saveNota(nota);
    }

    public ArrayList<NotaEntity> getNotas(){
        return (ArrayList<NotaEntity>) notaRepository.getNotas();
    }

    public NotaEntity getNotaById(int id) {
        return notaRepository.findByIdNota(id);
    }  
     public List<NotaEntity> getAllNotas() {
        return notaRepository.getNotas();
    }

    public boolean updateNota(NotaEntity nota) {
        // vemos si nota existe en la base de datos
        if (notaRepository.findByIdNota(nota.getId_nota()) != null) {
            // actualizamos el categoria usando el método del repositorio
            return notaRepository.updateNota(nota);
        }
        return false;
    }

    public boolean deleteNota(int id) throws Exception {
        try{
            notaRepository.deleteNota(id);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


}
