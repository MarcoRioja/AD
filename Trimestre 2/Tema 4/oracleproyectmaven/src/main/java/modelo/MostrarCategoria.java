package modelo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MostrarCategoria {
	 public static void mostrarRegistros() {
	        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	             Session session = sessionFactory.openSession()) {

	            // Consultar todos los registros de la tabla "Categoria"
	            session.beginTransaction();
	           
	            List<Categorias> categorias = session.createQuery("from Categorias", Categorias.class).list();

	            // Imprimir los resultados
	            for (Categorias categoria : categorias) {
	                System.out.println("ID: " + categoria.getId() + ", Categoría: " + categoria.getCategoria() + ", Categoría: " + categoria.getSubcategoria());
	            }

	            // Hacer commit de la transacción
	            session.getTransaction().commit();
	        } catch (Exception e) {
	            // Manejar la excepción de manera adecuada (mostrar mensaje o registrar en un sistema de registro)
	            e.printStackTrace();
	        }
	    }

	    public static void main(String[] args) {
	        // Ejemplo de uso
	        mostrarRegistros();
	    }
}
