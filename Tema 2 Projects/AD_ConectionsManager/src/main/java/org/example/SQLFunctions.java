package org.example;

import java.sql.*;

public class SQLFunctions {

    public Connection conn = null;
    public Statement stmt = null;
    public String sql;
    public ResultSet rs = null;

    public SQLFunctions() {
    }

    public void Connect(String url, String user, String password) throws SQLException {
        conn = DriverManager.getConnection(url, user, password);
        stmt = conn.createStatement();
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
        stmt.execute(sql);
        System.out.println(text);
    }

    public void executeQuery(String sql, String text) throws SQLException {
        stmt.executeQuery(sql);
        System.out.println(text);
    }

    public void executeUpdate(String sql, String text) throws SQLException {
        stmt.executeUpdate(sql);
        System.out.println(text);
    }
}
