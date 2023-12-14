package simulacro;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class ProductoModel {
    private Connection conn;

    public ProductoModel(String dbURL, String dbUser, String dbPassword) throws SQLException {
        conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
    }

    public List<Producto> getAllProductos() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM productos");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            String descripcion = rs.getString("descripcion");
            String fabricante = rs.getString("fabricante");
            int precio = rs.getInt("precio");
            int n_serie = rs.getInt("nserie");
            productos.add(new Producto(id, nombre, descripcion, fabricante, precio, n_serie));
        }

        stmt.close();
        rs.close();
        return productos;
    }

    public void close() throws SQLException {
        conn.close();
    }
}

