package modelo;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class EmpresaDAOHibernate implements EmpresaDAO {

    private final SessionFactory sessionFactory;

    public EmpresaDAOHibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void agregarEmpresa(Empresa empresa) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(empresa);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Empresa> obtenerTodasLasEmpresas() {
        try (Session session = sessionFactory.openSession()) {
            Query<Empresa> query = session.createQuery("from Empresa", Empresa.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Devuelve una lista vacía o maneja el error de otra manera según tus necesidades.
        }
    }

    @Override
    public void actualizarEmpresa(Empresa empresa) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.update(empresa);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void eliminarEmpresa(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Empresa empresa = session.get(Empresa.class, id);
            if (empresa != null) {
                session.delete(empresa);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public Empresa obtenerEmpresa(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Empresa.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

