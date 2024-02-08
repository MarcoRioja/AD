package Cliente;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.query.Query;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Modulo.Autor;
import Modulo.Categoria;
import Modulo.Cliente;
public class VerDatos {

	public static void main(String[] args) {
		// Configurar la sesión de Hibernate
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
		context.bind(sessionFactory.openSession());
		try {

			// Obtener la sesión actual
			Session session = context.currentSession();
			// Iniciar transacción
			session.beginTransaction();
			
			// Crear consulta HQL para seleccionar todos los registros de la tabla fabricante
            String hql = "FROM Cliente";
            Query<Cliente> query = session.createQuery(hql, Cliente.class);


            // Ejecutar consulta y obtener resultados
            List<Cliente> Cliente = query.list();


            // Imprimir resultados
            System.out.println("Registros en la tabla Cliente:");
            for (Cliente f : Cliente) {
                System.out.println(f.toString());
            }

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
