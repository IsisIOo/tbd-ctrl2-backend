-- 1. Drop database si ya existe (opcional)
DROP DATABASE IF EXISTS tareasdb;


-- 2. Crear la base de datos si no existe
CREATE DATABASE tareasdb
   WITH
   OWNER = postgres
   ENCODING = 'UTF8'
   LC_COLLATE = 'English_United States.1252'
   LC_CTYPE = 'English_United States.1252'
   TABLESPACE = pg_default
   CONNECTION LIMIT = -1
   IS_TEMPLATE = False;


-- Usar la base de datos creada
\c tareasdb;


--- Tabla ----



CREATE TABLE IF NOT EXISTS usuario (
                                        id_usuario SERIAL PRIMARY KEY,
                                        nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL
    );

CREATE TABLE IF NOT EXISTS nota (
                                     id_nota SERIAL PRIMARY KEY,
                                     id_usuario INTEGER NOT NULL,
                                     nombre_nota VARCHAR(255) NOT NULL,
    contenido_nota TEXT,
    fecha_nota DATE,
    completa_check_nota BOOLEAN DEFAULT FALSE,
    CONSTRAINT fk_usuario
    FOREIGN KEY(id_usuario)
    REFERENCES usuario(id_usuario)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );



