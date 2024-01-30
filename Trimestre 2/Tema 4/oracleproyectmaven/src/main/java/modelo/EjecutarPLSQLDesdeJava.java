package modelo;
// codigo a revisar
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
                // Configura el bloque PL/SQL
                String bloquePLSQL =
                        "DECLARE " +
                                "  Interes NUMBER(5,3); " +
                                "  Descripcion VARCHAR2(50) := 'inicial'; " +
                                "  Fecha_max DATE; " +
                                "  Contabilizado BOOLEAN := TRUE; " +
                                "  PI CONSTANT REAL := 3.14159; " +
                                "BEGIN " +
                                "  DBMS_OUTPUT.PUT_LINE('Interes: ' || Interes); " +
                                "  DBMS_OUTPUT.PUT_LINE('Descripcion: ' || Descripcion); " +
                                "  DBMS_OUTPUT.PUT_LINE('Fecha_max: ' || TO_CHAR(Fecha_max, 'DD-MON-YYYY')); " +
                                "  DBMS_OUTPUT.PUT_LINE('Contabilizado: ' || CASE WHEN Contabilizado THEN 'TRUE' ELSE 'FALSE' END); " +
                                "  DBMS_OUTPUT.PUT_LINE('PI: ' || PI); " +
                                "END; ";

                // Ejecuta el bloque PL/SQL
                try (CallableStatement statement = connection.prepareCall(bloquePLSQL)) {
                    // Registra la salida para capturar los mensajes de DBMS_OUTPUT.PUT_LINE
                    statement.registerOutParameter(1, Types.VARCHAR);

                    // Ejecuta el bloque PL/SQL
                    statement.execute();

                    // Obtiene la salida
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
