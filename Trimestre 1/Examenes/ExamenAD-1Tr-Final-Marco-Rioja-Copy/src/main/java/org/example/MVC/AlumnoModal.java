package org.example.MVC;
import java.util.Date;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class AlumnoModal {
    private Connection conn;

    // Constructor que recibe la URL de la base de datos, el usuario y la contraseña
    public AlumnoModal(String dbURL, String dbUser, String dbPassword) throws SQLException {
        // Establece la conexión con la base de datos
        conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
    }

    // Método para obtener todos los clientes de la base de datos y devolverlos como una lista
    public List<Alumno> getAllAlumnos() throws SQLException {
        List<Alumno> alumnos = new ArrayList<>(); // Inicializa una lista para almacenar los clientes
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM alumno"); // Crea una declaración SQL

        // Ejecuta una consulta SQL para obtener todos los alumnos de la tabla "alumnos"
        ResultSet rs = stmt.executeQuery();

        // Itera a través de los resultados y crea objetos Alumno para cada fila
        while (rs.next()) {
            int idAlumno = rs.getInt("id");
            String nombre = rs.getString("nombre");
            String apellido1 = rs.getString("apellido1");
            String apellido2 = rs.getString("apellido2");
            String fechaNacimiento = rs.getString("fecha_nacimiento");
            String esRepartidor = rs.getString("es_repetidor");
            int telefono = rs.getInt("teléfono");
            alumnos.add(new Alumno(idAlumno, nombre, apellido1, apellido2, fechaNacimiento, esRepartidor, telefono)); // Agrega el alumno a la lista
        }

        stmt.close(); // Cierra la declaración
        rs.close(); // Cierra el resultado
        return alumnos; // Devuelve la lista de alumnos
    }

    // Método para cerrar la conexión a la base de datos
    public void close() throws SQLException {
        conn.close();
    }
}

