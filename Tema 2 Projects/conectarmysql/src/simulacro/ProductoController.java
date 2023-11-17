package simulacro;
import java.util.List;
import java.sql.*;

public class ProductoController {
    private ProductoModel model;
    private ProductoView view;

    public ProductoController(String dbURL, String dbUser, String dbPassword) throws SQLException {
        model = new ProductoModel(dbURL, dbUser, dbPassword);
        view = new ProductoView();
    }

    public void mostrarProductos() throws SQLException {
        List<Producto> productos = model.getAllProductos();
        view.mostrarProductos(productos);
    }

    public void cerrarConexion() throws SQLException {
        model.close();
    }
}
