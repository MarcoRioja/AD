package vtx.mk.HospitalApp.Modelo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		
		ThreadLocalSessionContext context = new ThreadLocalSessionContext ((SessionFactoryImplementor) sessionFactory);
				context.bind(sessionFactory.openSession());
				showMenu(context);
	}

	private static void showMenu(ThreadLocalSessionContext context) {
		String choice = "0";
		while (!choice.equals("13")) {
			System.out.println("\u001B[33m"+"1. Crear Paciente"+"\u001B[0m");
			System.out.println("\u001B[33m"+"2. Crear Médico"+"\u001B[0m");
			System.out.println("\u001B[33m"+"3. Crear Cita"+"\u001B[0m");
			System.out.println("\u001B[33m"+"4. Mostrar Pacientes"+"\u001B[0m");
			System.out.println("\u001B[33m"+"5. Mostrar Médicos"+"\u001B[0m");
			System.out.println("\u001B[33m"+"6. Mostrar Citas"+"\u001B[0m");
			System.out.println("\u001B[33m"+"7. Modificar Paciente"+"\u001B[0m");
			System.out.println("\u001B[33m"+"8. Modificar Médico"+"\u001B[0m");
			System.out.println("\u001B[33m"+"9. Modificar Cita"+"\u001B[0m");
			System.out.println("\u001B[33m"+"10. Eliminar Paciente"+"\u001B[0m");
			System.out.println("\u001B[33m"+"11. Eliminar Médico"+"\u001B[0m");
			System.out.println("\u001B[33m"+"12. Eliminar Cita"+"\u001B[0m");
			System.out.println("\u001B[33m"+"13. Salir"+"\u001B[0m");
			choice = sc.nextLine();

			String nombre;
			String apellidos;
			String ciudad;
			String direccion;
			String telefono;
			byte edad;
			String historial;
			String especialidad;
			int id_paciente;
			int id_medico;
			String fecha;
			String hora;
			Session session = context.currentSession();
			String deleteHql;
			Query<?> deleteQuery;
			String updateHql;
			String hql;
			Query<Paciente> query_p;
			Query<Medico> query_m;
			Query<Cita> query_c;
			Query<?> updateQuery;
			Paciente paciente;
			Medico medico;
			Cita cita;

			switch (choice) {
				case "1":
					System.out.print("\u001B[34m"+"Introduce el nombre: "+"\u001B[0m");
					nombre = sc.nextLine();
					System.out.print("\u001B[34m"+"Introduce el apellidos: "+"\u001B[0m");
					apellidos = sc.nextLine();
					System.out.print("\u001B[34m"+"Introduce la ciudad: "+"\u001B[0m");
					ciudad = sc.nextLine();
					System.out.print("\u001B[34m"+"Introduce la dirección: "+"\u001B[0m");
					direccion = sc.nextLine();
					System.out.print("\u001B[34m"+"Introduce el telefono: "+"\u001B[0m");
					telefono = sc.nextLine();
					System.out.print("\u001B[34m"+"Introduce el edad: "+"\u001B[0m");
					edad = sc.nextByte();
					System.out.print("\u001B[34m"+"Introduce el historial: "+"\u001B[0m");
					historial = sc.nextLine();
					paciente= new Paciente (nombre,apellidos, ciudad, direccion, telefono, edad, historial);
					session.beginTransaction();
					session.save(paciente);
					session.getTransaction().commit();
					break;
				case "2":
					System.out.print("\u001B[34m"+"Introduce el nombre: "+"\u001B[0m");
					nombre = sc.nextLine();
					System.out.print("\u001B[34m"+"Introduce el apellidos: "+"\u001B[0m");
					apellidos = sc.nextLine();
					System.out.print("\u001B[34m"+"Introduce la especialidad: "+"\u001B[0m");
					especialidad = sc.nextLine();
					medico= new Medico (nombre, apellidos, especialidad);
					session.beginTransaction();
					session.save(medico);
					session.getTransaction().commit();
					break;
				case "3":
					System.out.print("\u001B[34m"+"Introduce la id del paciente: "+"\u001B[0m");
					id_paciente = sc.nextInt();
					System.out.print("\u001B[34m"+"Introduce la id del médico: "+"\u001B[0m");
					id_medico = sc.nextInt();
					System.out.print("\u001B[34m"+"Introduce la fecha (00-00-0000): "+"\u001B[0m");
					fecha = sc.nextLine();
					System.out.print("\u001B[34m"+"Introduce la hora (00:00): "+"\u001B[0m");
					hora = sc.nextLine();
					cita= new Cita (id_paciente, id_medico, fecha, hora);
					session.beginTransaction();
					session.save(cita);
					session.getTransaction().commit();
					break;
				case "4":
					session.beginTransaction();
					hql = "FROM Paciente";
					query_p = session.createQuery(hql, Paciente.class);
					List<Paciente> pacientes_s = query_p.list();
					for (Paciente i : pacientes_s) {
						System.out.println("\u001B[34m"+i.toString()+"\u001B[0m");
					}
					session.getTransaction().commit();
					break;
				case "5":
					session.beginTransaction();
					hql = "FROM Medico";
					query_m = session.createQuery(hql, Medico.class);
					List<Medico> medicos_s = query_m.list();
					for (Medico i : medicos_s) {
						System.out.println("\u001B[34m"+i.toString()+"\u001B[0m");
					}
					session.getTransaction().commit();
					break;
				case "6":
					session.beginTransaction();
					hql = "FROM Cita";
					query_c = session.createQuery(hql, Cita.class);
					List<Cita> citas_s = query_c.list();
					for (Cita i : citas_s) {
						System.out.println("\u001B[34m"+i.toString()+"\u001B[0m");
					}
					session.getTransaction().commit();
					break;
				case "7":
					System.out.print("\u001B[34m"+"Introduce la id del paciente a modificar: "+"\u001B[0m");
					int id = sc.nextInt();
					session.beginTransaction();
					hql = "FROM Paciente WHERE id = " + id;
					query_p = session.createQuery(hql, Paciente.class);
					List<Paciente> pacientes = query_p.list();
					if (pacientes != null && !pacientes.isEmpty()) {
						System.out.print("\u001B[34m"+"- Nuevos Datos del Paciente -"+"\u001B[0m");
						System.out.print("\u001B[34m"+"Introduce el nombre: "+"\u001B[0m");
						nombre = sc.nextLine();
						System.out.print("\u001B[34m"+"Introduce el apellidos: "+"\u001B[0m");
						apellidos = sc.nextLine();
						System.out.print("\u001B[34m"+"Introduce la ciudad: "+"\u001B[0m");
						ciudad = sc.nextLine();
						System.out.print("\u001B[34m"+"Introduce la dirección: "+"\u001B[0m");
						direccion = sc.nextLine();
						System.out.print("\u001B[34m"+"Introduce el telefono: "+"\u001B[0m");
						telefono = sc.nextLine();
						System.out.print("\u001B[34m"+"Introduce el edad: "+"\u001B[0m");
						edad = sc.nextByte();
						System.out.print("\u001B[34m"+"Introduce el historial: "+"\u001B[0m");
						historial = sc.nextLine();
						updateHql = "UPDATE Paciente SET nombre = '"+nombre+"', apellidos = '"+apellidos+"', ciudad = '"+ciudad+"'," +
								" direccion = '"+direccion+"', tlf = '"+telefono+"', edad = '"+edad+"', historial = '"+historial+"' WHERE id = "+id;
						updateQuery = session.createQuery(updateHql);
						updateQuery.executeUpdate();
					}
					session.getTransaction().commit();
					break;
				case "8":
					System.out.print("\u001B[34m"+"Introduce la id del medico a modificar: "+"\u001B[0m");
					id = sc.nextInt();
					session.beginTransaction();
					hql = "FROM Medico WHERE id = " + id;
					query_m = session.createQuery(hql, Medico.class);
					List<Medico> medicos = query_m.list();
					if (medicos != null && !medicos.isEmpty()) {
						System.out.print("\u001B[34m"+"Introduce el nombre: "+"\u001B[0m");
						nombre = sc.nextLine();
						System.out.print("\u001B[34m"+"Introduce el apellidos: "+"\u001B[0m");
						apellidos = sc.nextLine();
						System.out.print("\u001B[34m"+"Introduce la especialidad: "+"\u001B[0m");
						especialidad = sc.nextLine();
						updateHql = "UPDATE Medico SET nombre = '"+nombre+"', apellidos = '"+apellidos+"', especialidad = '"+especialidad+"' WHERE id = "+id;
						updateQuery = session.createQuery(updateHql);
						updateQuery.executeUpdate();
					}
					session.getTransaction().commit();
					break;
				case "9":
					System.out.print("\u001B[34m"+"Introduce la id de la cita a modificar: "+"\u001B[0m");
					id = sc.nextInt();
					session.beginTransaction();
					hql = "FROM Cita WHERE id = " + id;
					query_c = session.createQuery(hql, Cita.class);
					List<Cita> citas = query_c.list();
					if (citas != null && !citas.isEmpty()) {
						System.out.println(citas.get(0));
						System.out.println("\u001B[34m"+"- Nuevos Datos de la Cita -"+"\u001B[0m");
						System.out.print("\u001B[34m"+"Introduce la id del paciente: "+"\u001B[0m");
						id_paciente = sc.nextInt();
						System.out.print("\u001B[34m"+"Introduce la id del médico: "+"\u001B[0m");
						id_medico = sc.nextInt();
						System.out.print("\u001B[34m"+"Introduce la fecha (00-00-0000): "+"\u001B[0m");
						fecha = sc.nextLine();
						System.out.print("\u001B[34m"+"Introduce la hora (00:00): "+"\u001B[0m");
						hora = sc.nextLine();
						updateHql = "UPDATE Cita SET id_paciente = '"+id_paciente+"', id_medico = '"+id_medico+"', fecha = '"+fecha+"', hora = '"+hora+"' WHERE id = "+id;
						updateQuery = session.createQuery(updateHql);
						updateQuery.executeUpdate();
					}
					session.getTransaction().commit();
					break;
				case "10":
					System.out.print("\u001B[34m"+"Introduce la id del paciente a eliminar: "+"\u001B[0m");
					id = sc.nextInt();
					session.beginTransaction();
					deleteHql = "DELETE FROM Paciente WHERE id = " + id;
					deleteQuery = session.createQuery(deleteHql);
					deleteQuery.executeUpdate();
					session.getTransaction().commit();
					break;
				case "11":
					System.out.print("\u001B[34m"+"Introduce la id del medico a eliminar: "+"\u001B[0m");
					id = sc.nextInt();
					session.beginTransaction();
					deleteHql = "DELETE FROM Medico WHERE id = " + id;
					deleteQuery = session.createQuery(deleteHql);
					deleteQuery.executeUpdate();
					session.getTransaction().commit();
					break;
				case "12":
					System.out.print("\u001B[34m"+"Introduce la id de la cita a eliminar: "+"\u001B[0m");
					id = sc.nextInt();
					session.beginTransaction();
					deleteHql = "DELETE FROM Cita WHERE id = " + id;
					deleteQuery = session.createQuery(deleteHql);
					deleteQuery.executeUpdate();
					session.getTransaction().commit();
					break;
					case "13":
						System.out.println("\u001B[31m"+"Saliendo..."+"\u001B[0m");
						break;
				default:
					System.out.print("\u001B[31m"+"- //Error// Opcion desconocida, por favor eliga una de las instrucciones -"+"\u001B[0m");
			}
		}
	}

}