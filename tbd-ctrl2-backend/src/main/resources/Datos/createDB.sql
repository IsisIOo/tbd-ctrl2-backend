CREATE TABLE IF NOT EXISTS Usuario (
                        id_usuario SERIAL PRIMARY KEY,
                        nombre VARCHAR(100) NOT NULL,
                        email VARCHAR(150) NOT NULL UNIQUE,
                        contrasena VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS Nota (
                        id_nota SERIAL PRIMARY KEY,
                        nombre_nota VARCHAR(255) NOT NULL,
                        contenido_nota VARCHAR(255) NOT NULL,
                        fecha_nota DATE NOT NULL,
                        completa_check_nota BOOLEAN NOT NULL,
                        id_usuario INT NOT NULL,
                        FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
);

