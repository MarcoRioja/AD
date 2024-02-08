package modelo;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.query.Query;

public class MostrarCliente {

	public static void main(String[] args) {
		// Configurar la sesión de Hibernate
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
		ThreadLocalSessionContext.bind(sessionFactory.openSession());
		try {
		

			// Obtener la sesión actual
			Session session = context.currentSession();
			// Iniciar transacción
			session.beginTransaction();
			// Guardar objeto en la base de datos
			
			String hql = "FROM Cliente";
            Query<Cliente> query = session.createQuery(hql, Cliente.class);


            // Ejecutar consulta y obtener resultados
            List<Cliente> Clientes = query.list();


            // Imprimir resultados
            System.out.println("Registros en la tabla Cliente:");
            for (Cliente f : Clientes) {
                System.out.println(f.toString());
            }


			// Hacer commit de la transacción
			session.getTransaction().commit();

			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// Desligar la sesión del contexto
			ThreadLocalSessionContext.unbind(sessionFactory);

			// Cerrar la sesión del Hibernate
			sessionFactory.close();
		}
	}
}
