package Categoria;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.query.Query;

import Modulo.Autor;
import Modulo.Categoria;

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
            String updateHql = "UPDATE Categoria SET NombreCategoria = 'Aventura' WHERE id = 2";
            Query<?> updateQuery = session.createQuery(updateHql);
            updateQuery.executeUpdate();

            // Realizar una nueva consulta para obtener los datos actualizados
            String selectHql = "FROM Categoria WHERE id = 2";
            Query<Categoria> selectQuery = session.createQuery(selectHql, Categoria.class);
            List<Categoria> Categoria = selectQuery.list();

            // Imprimir resultados
            System.out.println("Registros en la tabla Categoria después de la actualización:");
            for (Categoria f : Categoria) {
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
