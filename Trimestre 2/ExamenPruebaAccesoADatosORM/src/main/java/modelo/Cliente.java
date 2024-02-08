package modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
@Entity
@Table(name ="clientes")

public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cliente")
	private int id_cliente;
	
	@Column(name="nombre_cliente")
	private String nombre_cliente;
	
	@Column(name ="ciudad")
	private String ciudad;
	
	@Column(name ="fecha")
	private Date fecha;
	
	@OneToMany(mappedBy = "id_cliente", cascade = CascadeType.ALL)
    private List<Producto> productos = new ArrayList<>();
	
	public Cliente() {
		
	}
	
	public Cliente(String nombre_cliente,String ciudad,Date fecha) {
		
		this.nombre_cliente=nombre_cliente;
		this.ciudad=ciudad;
		this.fecha=fecha;
		
		
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Cliente [id_cliente=" + id_cliente + ", nombre_cliente='" + nombre_cliente + '\''+", ciudad='" + ciudad
				+ '\''+", fecha=" + fecha + "]";
	}
	
	

	
}
