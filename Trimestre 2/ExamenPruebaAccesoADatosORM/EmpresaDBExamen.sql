DROP DATABASE IF EXISTS  EmpresaDB;
CREATE DATABASE EmpresaDB;

-- Usar la base de datos creada
USE EmpresaDB;

-- Crear la tabla de clientes
CREATE TABLE clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre_cliente VARCHAR(50),
    ciudad VARCHAR(50),	
    fecha DATE
);

CREATE TABLE productos(
id_producto INT auto_increment PRIMARY KEY,
nombre_producto varchar(50),
precio int,
id_cliente int ,
foreign key (id_cliente)references clientes(id_cliente)
);

CREATE TABLE compras(
id_compra INT auto_increment PRIMARY KEY,
id_cliente int,
id_producto int,
foreign key (id_cliente)references clientes(id_cliente),
foreign key (id_producto)references productos(id_producto)
);

