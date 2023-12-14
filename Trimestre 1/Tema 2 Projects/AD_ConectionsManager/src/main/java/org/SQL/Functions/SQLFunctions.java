package org.SQL.Functions;

import javax.lang.model.element.VariableElement;
import java.sql.*;
import java.util.List;

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
        sql = "DROP DATABASE " + name;
        execute(sql, "La base de datos " + name + " ha sido borrada.");
        sql = "CREATE DATABASE " + name;
        execute(sql, "La base de datos " + name + " creada.");
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

    public void showTableData(String database, String table) throws SQLException {
        DatabaseMetaData dbmd = conn.getMetaData();
        rs = dbmd.getColumns(database, null, table, null);
        System.out.println(" -------------------------------- o --------------------------------- ");
        while (rs.next()) {
            String ccolumnName = rs.getString("COLUMN_NAME");
            String ccolumnType = rs.getString("TYPE_NAME");
        }
        System.out.println(" -------------------------------- o --------------------------------- ");

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

    public void createProcedure(String name, String toDo) throws SQLException {
        String sql = "DROP PROCEDURE IF EXISTS ObtenerClientes";
        executeUpdate(sql, "La procedimiento " + name + " ha sido eliminada.");
        sql = "CREATE PROCEDURE " + name + "BEGIN " + toDo + "END;";
        executeUpdate(sql, "La procedimiento " + name + " ha sido creada.");
    }

    public void executeProcedure2() throws SQLException {
        // Llamar al procedimiento almacenado
        cstmt = conn.prepareCall("call CalculaEdad1(?,?)");
        cstmt.setInt(1, 1977); //1 es el primer valor del argumento del procedimiento
        cstmt.registerOutParameter(2, Types.INTEGER);
        // Ejecutar el procedimiento
        cstmt.execute();

        // Obtener los resultados si el procedimiento devuelve algo
        int edad=cstmt.getInt(2);//el parametro dos es el que me tiene que devolver

        System.out.println("Procedimiento invocado");
        System.out.println("la edad es "+edad);
    }

    public void executeProcedure(String name) throws SQLException {
        cstmt = conn.prepareCall("call " + name);
        cstmt.execute();
        rs = cstmt.getResultSet();
        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            String precio = rs.getString("precio");
            String precioTotal = rs.getString("total");
            System.out.println("id: " + id + ", "
                    + "nombre: " + nombre + ", precio: " + precio + ", total: " + precioTotal);
        }
    }
}
