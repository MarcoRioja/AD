package modelo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.query.Query;

import java.util.List;

public class Eliminar {

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

            // Realizar una consulta para obtener los datos antes de la eliminación
            String selectHqlBeforeDelete = "FROM fabricante WHERE id = 12";
            Query<Fabricante> selectQueryBeforeDelete = session.createQuery(selectHqlBeforeDelete, Fabricante.class);
            List<Fabricante> fabricantesBeforeDelete = selectQueryBeforeDelete.list();

            // Imprimir resultados antes de la eliminación
            System.out.println("Registros en la tabla fabricante antes de la eliminación:");
            for (Fabricante f : fabricantesBeforeDelete) {
                System.out.println(f.toString());
            }

            // Eliminar el registro
            String deleteHql = "DELETE FROM fabricante WHERE id = 12";
            Query<?> deleteQuery = session.createQuery(deleteHql);
            deleteQuery.executeUpdate();

            // Realizar una nueva consulta para obtener los datos después de la eliminación
            String selectHqlAfterDelete = "FROM fabricante";
            Query<Fabricante> selectQueryAfterDelete = session.createQuery(selectHqlAfterDelete, Fabricante.class);
            List<Fabricante> fabricantesAfterDelete = selectQueryAfterDelete.list();

            // Imprimir resultados después de la eliminación
            System.out.println("Registros en la tabla fabricante después de la eliminación:");
            for (Fabricante f : fabricantesAfterDelete) {
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
