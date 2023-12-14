package org.SQL.Examen;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        SQLFunctions sqlFunction = new SQLFunctions();

        try {
            sqlFunction.Connect("jdbc:mysql://localhost/","root",""); // Conectar con la DB
            sqlFunction.createDatabse("dbgametop"); // Crear DB

            sqlFunction.dropTable("tvideojuegos"); // Eliminar la tabla

            sqlFunction.execute("CREATE TABLE IF NOT EXISTS tvideojuegos (" + // Crear la tabla
                            "idjuego INT PRIMARY KEY," +
                            "nombre VARCHAR(50) NOT NULL," +
                            "anio INT," +
                            "compania VARCHAR(50)," +
                            "precio DECIMAL(10,2), " +
                            "sinopsis VARCHAR(150), " +
                            "plataforma VARCHAR(50))",
                    "Tabla tvideojuegos creada");
            // O se puede usar sqlFunction.createDatabse();

            sqlFunction.executeUpdate("INSERT INTO tvideojuegos (idjuego,nombre,anio,compania,precio,sinopsis,plataforma) VALUES " + // Insertar datos en la tabla
                            "(1, 'The Legend of Zelda: Breath of the Wild', 2017, 'Nintendo', 59.99, 'Aventura epica', 'Nintendo Switch')," +
                            "(2, 'Red Dead Redemption 2', 2018, 'Rockstar Games', 49.99, 'Aventura del viejo oeste', 'PlayStation 4')," +
                            "(3, 'Minecraft', 2011, 'Mojanj', 29.99, 'Mundo Abierto y construccion', 'Multiplataforma')",
                    "Datos insertados");
            // O se puede usar sqlFunction.insertarDatos();

            sqlFunction.createProcedure("nombrejuego()", "SELECT * FROM tvideojuegos;"); // Crear el procedimiento
            sqlFunction.executeNombreProcedure(); // Ejecutar el procedimiento

            sqlFunction.CloseConnection(); // Cerrar la conexión
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
