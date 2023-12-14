package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        String sql="CREATE DATABASE empresa1;";

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/","root","");
            stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("Creada la base de datos empresa1");

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/empresa1","root","");
            stmt = conn.createStatement();

            sql="CREATE TABLE clientes (id INT PRIMARY KEY,"
                    + "nif VARCHAR(10) NOT NULL,"
                    + "nombre VARCHAR(60) NOT NULL, "
                    + "Edad VARCHAR(2))";
            stmt.execute(sql);
            System.out.println("Creada la tabla clientes");

            sql = "INSERT INTO clientes (id, nif, nombre, edad) " +
                    "VALUES (1, '11111', 'Alberto', 40)";
            stmt.executeUpdate(sql);
            System.out.println("Datos insertados en la tabla clientes");

            sql = "SELECT * FROM clientes";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nif = rs.getString("nif");
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                System.out.println("id: " + id + ", nif: " + nif +
                        ", nombre: " + nombre + ", edad: " + edad);
            }
            rs.close();


            conn.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}