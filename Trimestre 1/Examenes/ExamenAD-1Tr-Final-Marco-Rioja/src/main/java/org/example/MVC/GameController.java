package org.SQL.MVC;
import java.util.List;
import java.sql.*;

public class GameController {
    private GameModal model; // Instancia del modelo
    private GameView view;   // Instancia de la vista

    // Constructor que recibe la URL de la base de datos, el usuario y la contraseña
    public GameController(String dbURL, String dbUser, String dbPassword) throws SQLException {
        model = new GameModal(dbURL, dbUser, dbPassword); // Inicializa el modelo con la conexión a la base de datos
        view = new GameView(); // Inicializa la vista
    }

    // Método para mostrar los clientes
    public void mostrarGames() throws SQLException {
        List<Game> games = model.getAllGames(); // Obtiene la lista de clientes desde el modelo
        view.mostrarGames(games); // Muestra los clientes en la vista
    }

    // Método para cerrar la conexión a la base de datos
    public void cerrarConexion() throws SQLException {
        model.close(); // Cierra la conexión en el modelo
    }
}
