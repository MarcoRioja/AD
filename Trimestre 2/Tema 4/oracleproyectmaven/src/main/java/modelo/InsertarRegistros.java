package modelo;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertarRegistros {
    public static void insertarRegistros() {
        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            // Consultar todos los registros de la tabla "empresa"
            session.beginTransaction();
           Empresa empresa = new Empresa(10,"Juani","Argentina");
           session.save(empresa);
           session.getTransaction().commit();
           
        } catch (Exception e) {
            // Manejar la excepción de manera adecuada (mostrar mensaje o registrar en un sistema de registro)
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        insertarRegistros();
    }
}
