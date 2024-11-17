CREATE TABLE IF NOT EXISTS Usuario (
                                       id_usuario SERIAL PRIMARY KEY,
                                       nombre VARCHAR(100) NOT NULL,
                                       email VARCHAR(150) NOT NULL UNIQUE,
                                       contrasena VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS Nota (
                            id_nota SERIAL PRIMARY KEY,
                            nombre VARCHAR(255) NOT NULL,
                            contenido VARCHAR(255) NOT NULL,
                            fecha DATE NOT NULL,
                            completa_check BOOLEAN NOT NULL,
                            id_usuario INT NOT NULL,
                            FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
);

-- (nombre, id_usuario, contenido, fecha, completa_check)
