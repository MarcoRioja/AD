package modelo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class EjecutarPLSQLDesdeJava {
    public static void main(String[] args) {
        // Configura la sesión de Hibernate
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            // Usa Session.doWork para ejecutar SQL nativo
            session.doWork(connection -> {
                // Configura la llamada al procedimiento almacenado
                String procedimientoAlmacenado = "{ CALL ejecutar_bloque_plsql(?) }";

                // Ejecuta el procedimiento almacenado
                try (CallableStatement statement = connection.prepareCall(procedimientoAlmacenado)) {
                    // Registra el parámetro de salida
                    statement.registerOutParameter(1, Types.VARCHAR);

                    // Ejecuta el procedimiento almacenado
                    statement.execute();

                    // Obtiene el valor del parámetro de salida
                    String output = statement.getString(1);

                    // Muestra la salida
                    System.out.println(output);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cierra la sesión de Hibernate al finalizar
            sessionFactory.close();
        }
    }
}
