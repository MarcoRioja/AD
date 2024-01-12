package modelo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;

public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
        context.bind(sessionFactory.openSession());

        try {
            Videojuego videojuego = new Videojuego("The Legend of Zelda: Tears of the Kingdom",2023,
                    "Nintendo", 69.99f, "...", "Nintendo Switch" );

            Session session = context.currentSession();
            session.beginTransaction();
            session.save(videojuego);
            session.getTransaction().commit();

            System.out.println("Videojuego: " + videojuego);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ThreadLocalSessionContext.unbind(sessionFactory);
            sessionFactory.close();
        }
    }
}