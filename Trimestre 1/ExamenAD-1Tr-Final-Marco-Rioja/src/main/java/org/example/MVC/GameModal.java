package org.SQL.MVC;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class GameModal {
    private Connection conn;

    // Constructor que recibe la URL de la base de datos, el usuario y la contraseña
    public GameModal(String dbURL, String dbUser, String dbPassword) throws SQLException {
        // Establece la conexión con la base de datos
        conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
    }

    // Método para obtener todos los clientes de la base de datos y devolverlos como una lista
    public List<Game> getAllGames() throws SQLException {
        List<Game> games = new ArrayList<>(); // Inicializa una lista para almacenar los clientes
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tvideojuegos"); // Crea una declaración SQL

        // Ejecuta una consulta SQL para obtener todos los clientes de la tabla "clientes"
        ResultSet rs = stmt.executeQuery();

        // Itera a través de los resultados y crea objetos Cliente para cada fila
        while (rs.next()) {
            int idjuego = rs.getInt("idjuego"); // Obtiene el id del j
            String nombre = rs.getString("nombre"); // Obtiene el nombre del j
            int anio = rs.getInt("anio"); // Obtiene el año del j
            String compania = rs.getString("compania"); // Obtiene la compañía del j
            float precio = rs.getFloat("precio"); // Obtiene el precio del j
            String sinopsis = rs.getString("sinopsis"); // Obtiene la sinopsis del j
            String plataforma = rs.getString("plataforma"); // Obtiene la plataforma del j
            games.add(new Game(idjuego, nombre, anio, compania, precio, sinopsis, plataforma)); // Agrega el cliente a la lista
        }

        stmt.close(); // Cierra la declaración
        rs.close(); // Cierra el resultado
        return games; // Devuelve la lista de clientes
    }

    // Método para cerrar la conexión a la base de datos
    public void close() throws SQLException {
        conn.close();
    }
}

