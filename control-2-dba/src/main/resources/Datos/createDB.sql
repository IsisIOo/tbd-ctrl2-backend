CREATE TABLE IF NOT EXISTS Categoria (
                           id_categoria INT PRIMARY KEY,
                           nombre VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS Usuario (
                         id_cliente INT PRIMARY KEY,
                         nombre VARCHAR(100) NOT NULL,
                         email VARCHAR(150) NOT NULL UNIQUE,
                         contrasena VARCHAR(100) NOT NULL
);
