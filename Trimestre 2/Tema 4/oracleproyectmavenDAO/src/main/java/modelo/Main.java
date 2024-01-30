package modelo;


import modelo.EmpresaDAO;
import modelo.EmpresaDAOHibernate;
import modelo.Empresa;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        // Configurar la sesión de Hibernate
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // Crear el DAO de Empresa
        EmpresaDAO empresaDAO = new EmpresaDAOHibernate(sessionFactory);

        // Obtener y mostrar todas las empresas
        System.out.println("Empresas existentes:");
        empresaDAO.obtenerTodasLasEmpresas().forEach(empresa -> {
            System.out.println("ID: " + empresa.getId() + ", Nombre: " + empresa.getNombre() + ", País: " + empresa.getPais());
        });

        // Cerrar la sesión de Hibernate
        sessionFactory.close();
    }
}
