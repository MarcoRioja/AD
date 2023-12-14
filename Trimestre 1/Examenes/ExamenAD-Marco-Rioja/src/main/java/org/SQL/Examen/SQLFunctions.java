package org.SQL.Examen;

import java.sql.*;

public class SQLFunctions {

    public Connection conn = null;
    public PreparedStatement stmt = null;
    CallableStatement cstmt = null;
    public String sql;
    public ResultSet rs = null;

    public SQLFunctions() {
    }

    public void Connect(String url, String user, String password) throws SQLException {
        conn = DriverManager.getConnection(url, user, password);
    }

    public void CloseConnection() throws SQLException {
        stmt.close();
        conn.close();
    }

    public void createDatabse(String name) throws SQLException {
        sql = "CREATE DATABASE IF NOT EXISTS " + name;
        execute(sql, "La base de datos " + name + " ha sido creada.");
        sql = "USE " + name;
        execute(sql, "La base de datos " + name + " ha sido seleccionada.");
    }

    public void showConnData() throws SQLException {
        DatabaseMetaData dbmd = conn.getMetaData();
        System.out.println(" -------------------------------- o --------------------------------- ");
        System.out.println("Nombre: " + dbmd.getDatabaseProductName());
        System.out.println("Versión: " + dbmd.getDatabaseProductVersion());
        System.out.println("Servidor: " + dbmd.getURL());
        System.out.println("Usuario: " + dbmd.getUserName());
        System.out.println(" -------------------------------- o --------------------------------- ");
    }

    /**
     * Funcion para mostrar todos los datos de la tabla
     * @param table
     * @throws SQLException
     */
    public void showTableData(String table) throws SQLException {
        sql = "SELECT * FROM " + table;
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        System.out.println(" -------------------------------- o --------------------------------- ");
        while (rs.next()) {
            int idjuego = rs.getInt("idjuego");
            String nombre = rs.getString("nombre");
            int anio = rs.getInt("anio");
            String compania = rs.getString("compania");
            double precio = rs.getDouble("precio");
            String sinopsis = rs.getString("sinopsis");
            String plataforma = rs.getString("plataforma");
            System.out.println(idjuego + " - " + nombre + " - " + anio + " - " + compania + " - " + precio + " - " + sinopsis + " - " + plataforma);
        }
        System.out.println(" -------------------------------- o --------------------------------- ");

    }

    public void dropTable(String table) throws SQLException {
        sql = "DROP TABLE IF EXISTS " + table;
        execute(sql, "La tabla " + table + " ha sido eliminada.");
    }

    public void execute(String sql, String text) throws SQLException {
        stmt = conn.prepareStatement(sql);
        stmt.execute(sql);
        System.out.println(text);
    }

    public void executeQuery(String sql, String text) throws SQLException {
        stmt = conn.prepareStatement(sql);
        stmt.executeQuery(sql);
        System.out.println(text);
    }

    public void executeUpdate(String sql, String text) throws SQLException {
        stmt = conn.prepareStatement(sql);
        stmt.executeUpdate(sql);
        System.out.println(text);
    }

    /**
     * Crea un nuevo procedimiento con nombre @name y ejecuta @toDo.
     * @param name
     * @param toDo
     * @throws SQLException
     */
    public void createProcedure(String name, String toDo) throws SQLException {
        String sql = "DROP PROCEDURE IF EXISTS nombrejuego";
        executeUpdate(sql, "La procedimiento " + name + " ha sido eliminada.");
        sql = "CREATE PROCEDURE " + name + "BEGIN " + toDo + "END;";
        executeUpdate(sql, "La procedimiento " + name + " ha sido creada.");
    }

    /**
     * Ejecuta el procedimiento de mostrar todos los juegos
     * @throws SQLException
     */
    public void executeNombreProcedure() throws SQLException {
        cstmt = conn.prepareCall("call nombrejuego()");
        cstmt.execute();
        rs = cstmt.getResultSet();
        showTableData("tvideojuegos");
    }

    // - Funciones de Atajo - //
    public void insertarDatos() throws SQLException {
        executeUpdate("INSERT INTO tvideojuegos (idjuego,nombre,anio,compania,precio,sinopsis,plataforma) VALUES " + // Insertar datos en la tabla
                        "(1, 'The Legend of Zelda: Breath of the Wild', 2017, 'Nintendo', 59.99, 'Aventura epica', 'Nintendo Switch')," +
                        "(2, 'Red Dead Redemption 2', 2018, 'Rockstar Games', 49.99, 'Aventura del viejo oeste', 'PlayStation 4')," +
                        "(3, 'Minecraft', 2011, 'Mojanj', 29.99, 'Mundo Abierto y construccion', 'Multiplataforma')",
                "Datos insertados");
    }

    public void createDatabase() throws SQLException {
        execute("CREATE TABLE IF NOT EXISTS tvideojuegos (" + // Crear la tabla
                        "idjuego INT PRIMARY KEY," +
                        "nombre VARCHAR(50) NOT NULL," +
                        "anio INT," +
                        "compania VARCHAR(50)," +
                        "precio DECIMAL(10,2), " +
                        "sinopsis VARCHAR(150), " +
                        "plataforma VARCHAR(50))",
                "Tabla tvideojuegos creada");
    }
}
