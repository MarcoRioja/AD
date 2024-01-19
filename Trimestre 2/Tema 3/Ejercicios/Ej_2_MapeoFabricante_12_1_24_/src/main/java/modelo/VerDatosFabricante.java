package modelo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.query.Query;

import java.util.List;

public class VerDatosFabricante {

    public static void main(String[] args) {

        // Configurar la sesión de Hibernate
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();

        // Configurar la sesión en el contexto actual
        ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
        context.bind(sessionFactory.openSession());

        try {
            // Obtener la sesión actual
            Session session = context.currentSession();

            // Iniciar transacción
            session.beginTransaction();

            // Crear consulta HQL para seleccionar todos los registros de la tabla Fabricante
            String hql = "FROM Fabricante";
            Query<Fabricante> query = session.createQuery(hql, Fabricante.class);

            // Ejecutar consulta y obtener resultados
            List<Fabricante> Fabricantes = query.list();

            // Imprimir resultados
            System.out.println("Registros en la tabla Fabricante:");
            for (Fabricante f : Fabricantes) {
                System.out.println(f.toString());
            }
//solo nombres
            //String hql = "SELECT f.nombre FROM Fabricante f WHERE f.id = 12";
            //Query<String> query = session.createQuery(hql, String.class);

            // Ejecutar consulta y obtener resultados
            //List<String> nombres = query.list();

            // Imprimir resultados
            //System.out.println("Nombres en la tabla Fabricante:");
            //for (String nombre : nombres) {
            //    System.out.println(nombre);
           // }
            
            // Hacer commit de la transacción
            // si tuvieramos dos campos nombre y apellidos
            //for (Object[] resultado : resultados) {
            //    String nombre = (String) resultado[0];
            //    String apellidos = (String) resultado[1];
            //    System.out.println("Nombre: " + nombre + ", Apellidos: " + apellidos);
            //}
            
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            context.unbind(sessionFactory);
            sessionFactory.close();
        }
    }
}
