package modelo;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "productos")

public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nombre_producto")
	private String nombre_producto;

	@Column(name = "precio")
	private int precio;

	/* METER ID_cliente CON MOVIDAS LOCAS */

	@ManyToOne
	@JoinColumn(name = "id_cliente", nullable = false)
	private Cliente id_cliente;
	
	

	public Producto() {

	}

	public Producto(String nombre_producto, int precio, Cliente id_cliente) {
		this.nombre_producto = nombre_producto;
		this.precio = precio;
		this.id_cliente = id_cliente;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Cliente getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Cliente id_cliente) {
		this.id_cliente = id_cliente;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre_producto='" + nombre_producto + '\''+", precio=" + precio +", id_cliente="
				+ id_cliente + "]";
	}
	
	

}
