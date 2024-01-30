package oracleconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InsertarRegistro {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Registrar el driver JDBC
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establecer la conexión con la base de datos
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String usuario = "SYSTEM";
            String contrasena = "316072";
            conn = DriverManager.getConnection(url, usuario, contrasena);

            // Iniciar la transacción
            conn.setAutoCommit(false);

            // Crear el objeto Empresa con los datos a insertar
            int id = 5;
            String nombre = "Alberto";
            String pais = "España";

            // Insertar el objeto en la tabla empresa
            String sql = "INSERT INTO empresa (id, nombre, pais) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, nombre);
            stmt.setString(3, pais);
            stmt.executeUpdate();

            // Mostrar todos los datos de la tabla empresa
            sql = "SELECT * FROM empresa";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_empresa = rs.getInt("id");
                String nombre_empresa = rs.getString("nombre");
                String pais_empresa = rs.getString("pais");
                System.out.println("ID: " + id_empresa + " | Nombre: " + nombre_empresa + " | País: " + pais_empresa);
            }

            // Hacer commit de la transacción
            conn.commit();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            // Si ocurre algún error, hacer rollback de la transacción
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            // Cerrar la conexión y los recursos
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
