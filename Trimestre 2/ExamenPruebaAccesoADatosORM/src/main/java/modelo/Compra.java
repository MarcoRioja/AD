package modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
@Entity
@Table(name ="compras")

public class Compra  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_compra")
	private int id_compra;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente", nullable = false)
	private Cliente id_cliente;
	
	@ManyToOne
	@JoinColumn(name = "id_producto", nullable = false)
	private Producto id_producto;

	public Compra() {
		
	}
	
	public Compra(Cliente id_cliente,Producto id_producto) {
		this.id_cliente=id_cliente;
		this.id_producto=id_producto;
		
	}

	public int getId_compra() {
		return id_compra;
	}

	public void setId_compra(int id_compra) {
		this.id_compra = id_compra;
	}

	public Cliente getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Cliente id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Producto getId_producto() {
		return id_producto;
	}

	public void setId_producto(Producto id_producto) {
		this.id_producto = id_producto;
	}

	@Override
	public String toString() {
		return "Compra [id_compra=" + id_compra + ", id_cliente=" + id_cliente + ", id_producto=" + id_producto + "]";
	}
	
	
}
