package oracleconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleConnect {

    public static void main(String[] args) {
        try {
            String url = "jdbc:oracle:thin:@//localhost:1521/xe";
            String username = "SYSTEM";
            String password = "316072";
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "SELECT id, nombre, pais FROM empresa";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String pais = rs.getString("pais");
                // Procesar los datos aquí
                System.out.println("id: " + id + ", nombre: " + nombre + ", pais: " + pais);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

