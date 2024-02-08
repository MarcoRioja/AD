package modelo;

import java.sql.Date;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;

public class Main {

	public static void main(String[] args) {
		// Configurar la sesión de Hibernate
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
		ThreadLocalSessionContext.bind(sessionFactory.openSession());
		try {
			// Crear objeto Clientente
			Cliente cliente = new Cliente("Maximilian", "Peru", Date.valueOf("1990-05-05"));

			// Obtener la sesión actual
			Session session = context.currentSession();
			// Iniciar transacción
			session.beginTransaction();
			// Guardar objeto en la base de datos
			session.save(cliente);

			// Hacer commit de la transacción
			session.getTransaction().commit();

			// Imprimir Clientente guardado en la base de datos
			System.out.println("Cliente: " + cliente);

			// Crear objeto Producto
			Producto producto = new Producto("Pulpo", 30, cliente);

			// Obtener la sesión actual
			Session session2 = context.currentSession();
			// Iniciar transacción
			session2.beginTransaction();
			// Guardar objeto en la base de datos
			session2.save(producto);

			// Hacer commit de la transacción
			session2.getTransaction().commit();

			// Imprimir Clientente guardado en la base de datos
			System.out.println("Producto: " + producto);

			// Crear objeto Compra
			Compra compra = new Compra(cliente,producto);

			// Obtener la sesión actual
			Session session3 = context.currentSession();
			// Iniciar transacción
			session3.beginTransaction();
			// Guardar objeto en la base de datos
			session3.save(compra);

			// Hacer commit de la transacción
			session3.getTransaction().commit();

			// Imprimir Clientente guardado en la base de datos
			System.out.println("Compra: " + compra);

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
