package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        SQLFunctions sqlFunction = new SQLFunctions();

        try {
            sqlFunction.Connect("jdbc:mysql://localhost/","root","");
            sqlFunction.createDatabse("simulacro");

            sqlFunction.showConnData();

            sqlFunction.execute("CREATE TABLE IF NOT EXISTS productos (" +
                                        "id INT PRIMARY KEY," +
                                        "nombre VARCHAR(255) NOT NULL," +
                                        "descripcion VARCHAR(255) NOT NULL," +
                                        "fabricante VARCHAR(255) NOT NULL," +
                                        "precio INT NOT NULL, " +
                                        "nserie VARCHAR(255) NOT NULL)",
                    "Tabla simulacro creada");

            sqlFunction.executeUpdate("INSERT INTO productos (id,nombre,descripcion,fabricante,precio,nserie) VALUES " +
                                            "(1, 'portatil1', 'portatilgamaalta', 'HP', 1500, 111)," +
                                            "(2, 'portatil2', 'portatilgamabaja', 'APPLE', 1000, 222)," +
                                            "(3, 'portatil3', 'portatilgamaalta', 'LG', 800, 333)," +
                                            "(4, 'portatil4', 'portatilgamabaja', 'HP', 200, 444)",
                    "Datos insertados");

            sqlFunction.showTableData("simulacro", "productos");

            sqlFunction.CloseConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}