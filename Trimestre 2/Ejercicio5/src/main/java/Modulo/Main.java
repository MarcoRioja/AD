package Modulo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;

public class Main {

	public static void main(String[] args) {
SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		
		ThreadLocalSessionContext context = new ThreadLocalSessionContext ((SessionFactoryImplementor) sessionFactory);
				context.bind(sessionFactory.openSession());
				try {
					Autor autor=new Autor ("Daniel","Vargas");
					
					Session session = context.currentSession();
					
					session.beginTransaction();
					
					session.save(autor);
					
					session.getTransaction().commit();
					
					//-----------------------------------------------------
					
					Categoria categoria=new Categoria("Acción");
					Session session1 = context.currentSession();
					session1.beginTransaction();
					session1.save(categoria);
					session1.getTransaction().commit();
					
					//------------------------------------------------------
					Libro libro= new Libro("Las arenas del tiempo", "10: 9875800864", 15.99f, 100, autor ,categoria);
					
					Session session2 = context.currentSession();
					session2.beginTransaction();
					session2.save(libro);
					session2.getTransaction().commit();
					
					//-----------------------------------------------------
					
					Cliente cliente= new Cliente("Ruperto", "Alcaráz", "RupertoAlcaraz@hotmail.com");
					
					Session session3 = context.currentSession();
					session3.beginTransaction();
					session3.save(cliente);
					session3.getTransaction().commit();
					
					//----------------------------------------------------------
					
					Pedido pedido= new Pedido(Date.valueOf("2024-01-03"), 22.15f, cliente);
					
					Session session4 = context.currentSession();
					session4.beginTransaction();
					session4.save(pedido);
					session4.getTransaction().commit();
					
					//----------------------------------------------------------
					
					DetallePedido detallePedido= new DetallePedido(22, 34.99f, pedido, libro);
					
					Session session5 = context.currentSession();
					session5.beginTransaction();
					session5.save(detallePedido);
					session5.getTransaction().commit();
					
					System.out.println("Autor: "+autor);
					System.out.println("Categoria: "+categoria);
					System.out.println("Libro: "+libro);
					System.out.println("Cliente: "+cliente);
					System.out.println("Pedido: "+pedido);
					System.out.println("DetallePedido: "+detallePedido);
					
					
					
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					ThreadLocalSessionContext.unbind(sessionFactory);
					sessionFactory.close();

				}

	}

}