package org.SQL.MVC;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost/dbgametop"; // URL de la base de datos
        String dbUser = "root"; // Usuario de la base de datos
        String dbPassword = ""; // Contraseña del usuario

        try {
            GameController controller = new GameController(dbURL, dbUser, dbPassword); // Crea una instancia del controlador
            controller.mostrarGames(); // Llama al método del controlador para mostrar los clientes
            controller.cerrarConexion(); // Llama al método del controlador para cerrar la conexión a la base de datos
        } catch (SQLException e) {
            e.printStackTrace(); // Maneja las excepciones de SQL imprimiendo el error
        }
    }
}

