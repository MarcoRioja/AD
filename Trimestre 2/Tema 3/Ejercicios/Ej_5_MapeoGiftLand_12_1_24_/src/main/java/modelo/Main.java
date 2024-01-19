package modelo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;

public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory(); // Construir la sesin de Hibernate

        ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
        context.bind(sessionFactory.openSession());

        try {
            Producto producto = new Producto("Portatil Omnio", "Portatil 64GB", 1200.0f, "HP", 20);

            Session session = context.currentSession();

            session.beginTransaction();

            session.save(producto);

            session.getTransaction().commit();

            System.out.println("modelo.Producto: " + producto);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            ThreadLocalSessionContext.unbind(sessionFactory);

            sessionFactory.close();
        }
    }
}