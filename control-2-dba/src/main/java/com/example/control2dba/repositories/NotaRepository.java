package com.example.control2dba.repositories;

import com.example.control2dba.entities.NotaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class NotaRepository implements NotaRepositoryInt {

    @Autowired
    private Sql2o sql2o;

    public NotaEntity saveNota(NotaEntity nota) {
        String sql = "INSERT INTO nota (nombre) VALUES (:nombre)";
        try (Connection con = sql2o.open()) {
            // Cambiar Long a Integer
            Integer id = (Integer) con.createQuery(sql, true)
                    .addParameter("nombre", nota.getNombre_notas())
                    .executeUpdate()
                    .getKey();

            // Establecer el id en la entidad, ahora el id es de tipo int
            nota.setId_nota(id); // idCategoria ahora es un int en la entidad
            return nota;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<NotaEntity> getNotas() {
        String sql = "SELECT * FROM categoria";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(NotaEntity.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public NotaEntity findByIdNota(Integer id) { // Cambiar Long a int
        String sql = "SELECT * FROM notas WHERE id_nota = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(NotaEntity.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean deleteNota(Integer id) { // Cambiar Long a int
        String sql = "DELETE FROM nota WHERE id_nota = :id";
        try (Connection con = sql2o.open()) {
            int affectedRows = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate()
                    .getResult();
            return affectedRows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateNota(NotaEntity nota) {
        String sql = "UPDATE categoria SET nombre = :nombre WHERE id_categoria = :id";
        try (Connection con = sql2o.open()) {
            int affectedRows = con.createQuery(sql)
                    .addParameter("nombre", nota.getNombre_notas())
                    .addParameter("id", nota.getId_nota()) // idCategoria ahora es un int en la entidad
                    .executeUpdate()
                    .getResult();
            return affectedRows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}