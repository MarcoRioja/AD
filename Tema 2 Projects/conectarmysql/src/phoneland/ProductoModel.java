package phoneland;
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
            int id = rs.getInt("id_PRODUCTO");
            int id_proveedor = rs.getInt("id_proveedor");
            String nombre = rs.getString("NOMBRE");
            String fabricante = rs.getString("FABRICANTE");
            String precio = rs.getString("PRECIO");
            float pvp = rs.getFloat("PVP");
            String descripcion = rs.getString("Descripcion");
            productos.add(new Producto(id, id_proveedor, nombre, fabricante, precio, pvp, descripcion));
        }

        stmt.close();
        rs.close();
        return productos;
    }

    public void close() throws SQLException {
        conn.close();
    }
}

