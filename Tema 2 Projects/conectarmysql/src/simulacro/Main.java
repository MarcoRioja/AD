package simulacro;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost/simulacro";
        String dbUser = "root";
        String dbPassword = "";

        try {
            ProductoController controller = new ProductoController(dbURL, dbUser, dbPassword);
            controller.mostrarProductos();
            controller.cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

