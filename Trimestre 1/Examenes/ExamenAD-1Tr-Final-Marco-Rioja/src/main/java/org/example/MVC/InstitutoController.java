package org.example.MVC;
import java.util.List;
import java.sql.*;

public class InstitutoController {
    private AlumnoModal model; // Instancia del modelo
    private InstitutoView view;   // Instancia de la vista

    // Constructor que recibe la URL de la base de datos, el usuario y la contraseña
    public InstitutoController(String dbURL, String dbUser, String dbPassword) throws SQLException {
        model = new AlumnoModal(dbURL, dbUser, dbPassword); // Inicializa el modelo con la conexión a la base de datos
        view = new InstitutoView(); // Inicializa la vista
    }

    // Método para mostrar los clientes
    public void mostrarAlumnos() throws SQLException {
        List<Alumno> alumnos = model.getAllAlumnos(); // Obtiene la lista de clientes desde el modelo
        view.mostrarAlumnos(alumnos); // Muestra los clientes en la vista
    }

    // Método para cerrar la conexión a la base de datos
    public void cerrarConexion() throws SQLException {
        model.close(); // Cierra la conexión en el modelo
    }
}
