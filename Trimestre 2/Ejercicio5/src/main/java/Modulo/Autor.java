package Modulo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "autor")
public class Autor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDAutor")
	private int IDAutor;

	@Column(name = "Nombre")
	private String nombre;

	@Column(name = "Apellido")
	private String apellido;
	
	@OneToMany(mappedBy = "IDAutor", cascade = CascadeType.ALL)
    private List<Autor> autores = new ArrayList<>();
	
	public Autor() {
	}

	public Autor(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public int getIDAutor() {
		return IDAutor;
	}

	public void setIDAutor(int IDAutor) {
		this.IDAutor = IDAutor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	@Override
	public String toString() {
		return "Autor{"+
				"IDAutor="+IDAutor+
				", Nombre='"+nombre+
				", Apellido="+apellido+'\''+
				'}';
	}
	
}
