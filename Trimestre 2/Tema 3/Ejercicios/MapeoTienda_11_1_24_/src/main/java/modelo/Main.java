package modelo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;

public class Main {

    public static void main(String[] args) {

// Configurar la sesin de Hibernate
        SessionFactory sessionFactory = new Configuration().configure()
//llama al fichero hibernate.cfg.xml

// .configure("hibernate.cfg.xml") // Ruta del archivo de configuracin de Hibernate
                .buildSessionFactory(); // Construir la sesin de Hibernate

// Configurar la sesin en el contexto actual
        ThreadLocalSessionContext context =
                new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
        context.bind(sessionFactory.openSession());

        try {
// Crear objeto fabricante
            Fabricante fabrica = new Fabricante("GOOGLE ESPAÑA");


// Obtener la sesión actual
            Session session = context.currentSession();

// Iniciar transacción
            session.beginTransaction();

// Guardar objeto en la base de datos
            session.save(fabrica);




// Hacer commit de la transacción
            session.getTransaction().commit();

// Imprimir fabricante guardado en la base de datos
            System.out.println("Cliente: " + fabrica);



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
// Desligar la sesión del contexto
            ThreadLocalSessionContext.unbind(sessionFactory);
// Cerrar la sesión de Hibernate
            sessionFactory.close();
        }
    }
}