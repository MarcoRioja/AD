package Cliente;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.query.Query;

import Modulo.Autor;
import Modulo.Categoria;
import Modulo.Cliente;

import java.util.List;

public class ModificarDatos {

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

            // Modificar el nombre por "Jose David"
            String updateHql = "UPDATE Cliente SET Nombre = 'Alberto' WHERE id = 2";
            Query<?> updateQuery = session.createQuery(updateHql);
            updateQuery.executeUpdate();

            // Realizar una nueva consulta para obtener los datos actualizados
            String selectHql = "FROM Cliente WHERE id = 2";
            Query<Cliente> selectQuery = session.createQuery(selectHql, Cliente.class);
            List<Cliente> Cliente = selectQuery.list();

            // Imprimir resultados
            System.out.println("Registros en la tabla Cliente después de la actualización:");
            for (Cliente f : Cliente) {
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
