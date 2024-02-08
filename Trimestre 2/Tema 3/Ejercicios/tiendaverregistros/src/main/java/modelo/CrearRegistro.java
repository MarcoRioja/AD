package modelo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.query.Query;

import java.util.List;

public class CrearRegistro {

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

            // Realizar una consulta para obtener los datos antes de la inserción
            String selectHqlBeforeInsert = "FROM Fabricante";
            Query<Fabricante> selectQueryBeforeInsert = session.createQuery(selectHqlBeforeInsert, Fabricante.class);
            List<Fabricante> fabricantesBeforeInsert = selectQueryBeforeInsert.list();

            // Imprimir resultados antes de la inserción
            System.out.println("Registros en la tabla fabricante antes de la inserción:");
            for (Fabricante f : fabricantesBeforeInsert) {
                System.out.println(f.toString());
            }

            // Añadir un nuevo registro
            Fabricante nuevoFabricante = new Fabricante();
            nuevoFabricante.setNombre("Aragorn");
            // Configura otros atributos según la estructura de tu entidad fabricante

            session.save(nuevoFabricante);

            // Realizar una nueva consulta para obtener los datos después de la inserción
            String selectHqlAfterInsert = "FROM Fabricante";
            Query<Fabricante> selectQueryAfterInsert = session.createQuery(selectHqlAfterInsert, Fabricante.class);
            List<Fabricante> fabricantesAfterInsert = selectQueryAfterInsert.list();

            // Imprimir resultados después de la inserción
            System.out.println("Registros en la tabla fabricante después de la inserción:");
            for (Fabricante f : fabricantesAfterInsert) {
                System.out.println(f.toString());
            }

            // Hacer commit de la transacción
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            context.unbind(sessionFactory);
            sessionFactory.close();
        }
    }
}

