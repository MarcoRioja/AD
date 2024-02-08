-- Crear la base de datos
drop database tiendaLibros;
CREATE DATABASE tiendaLibros;
USE tiendaLibros;

-- Crear tabla Autores
CREATE TABLE autor (
    IDAutor INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(50),
    Apellido VARCHAR(50)
);

-- Crear tabla Categorias
CREATE TABLE categoria (
    IDCategoria INT PRIMARY KEY AUTO_INCREMENT,
    NombreCategoria VARCHAR(50)
);

-- Crear tabla Libros
CREATE TABLE libro (
    IDLibro INT PRIMARY KEY AUTO_INCREMENT,
    Titulo VARCHAR(100),
    ISBN VARCHAR(20),
    Precio DECIMAL(10, 2),
    Stock INT,
    IDAutor INT,
    IDCategoria INT,
    FOREIGN KEY (IDAutor) REFERENCES Autor(IDAutor),
    FOREIGN KEY (IDCategoria) REFERENCES Categoria(IDCategoria)
);

-- Crear tabla Clientes
CREATE TABLE cliente (
    IDCliente INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(50),
    Apellido VARCHAR(50),
    Email VARCHAR(100)
    -- Otras columnas relacionadas con los clientes
);

-- Crear tabla Pedidos
CREATE TABLE pedido (
    IDPedido INT PRIMARY KEY AUTO_INCREMENT,
    IDCliente INT,
    FechaPedido DATE,
    Descuento DECIMAL(5, 2),  -- Agrega el campo para el descuento total en el pedido
    FOREIGN KEY (IDCliente) REFERENCES cliente(IDCliente)
    -- Otras columnas relacionadas con los pedidos
);

-- Crear tabla DetallesPedido para controlar la cantidad de libros en cada pedido
CREATE TABLE detallePedido (
    IDDetalle INT PRIMARY KEY AUTO_INCREMENT,
    IDPedido INT,
    IDLibro INT,
    Cantidad INT,
    PrecioUnitario DECIMAL(10, 2),
    Descuento DECIMAL(5, 2),  -- Agrega el campo para el descuento en el detalle del pedido
    FOREIGN KEY (IDPedido) REFERENCES pedido(IDPedido),
    FOREIGN KEY (IDLibro) REFERENCES libro(IDLibro)
);

-- Buscar libros por título
SELECT * FROM libro WHERE Titulo LIKE '%<título_buscado>%';

-- Implemento una funcionalidad de busqueda para encontrar libros por titulo, autor...

/*SELECT libro.*
FROM libro
JOIN autor ON libro.IDAutor = autor.IDAutor
WHERE autor.Nombre LIKE '%<nombre_autor_buscado>%' OR Autor.Apellido LIKE '%<apellido_autor_buscado>%';*/

