package Modulo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detallepedido")

public class DetallePedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDDetalle")
	private int IDDetalle;

	@Column(name = "Cantidad")
	private int Cantidad;

	@Column(name = "PrecioUnitario")
	private float PrecioUnitario;
	
	@ManyToOne
	@JoinColumn(name = "IDPedido", nullable = false)
	private Pedido IDPedido;
	
	@ManyToOne
	@JoinColumn(name = "IDLibro", nullable = false)
	private Libro IDLibro;
	
	public DetallePedido() {
	}

	public DetallePedido(int Cantidad, float PrecioUnitario, Pedido IDPedido, Libro IDLibro) {
		this.Cantidad = Cantidad;
		this.PrecioUnitario = PrecioUnitario;
		this.IDPedido=IDPedido;
		this.IDLibro=IDLibro;
		
	}

	public int getIDDetalle() {
		return IDDetalle;
	}

	public void setIDDetalle(int iDDetalle) {
		this.IDDetalle = iDDetalle;
	}

	public int getCantidad() {
		return Cantidad;
	}

	public void setCantidad(int cantidad) {
		this.Cantidad = cantidad;
	}

	public float getPrecioUnitario() {
		return PrecioUnitario;
	}

	public void setPrecioUnitario(float precioUnitario) {
		this.PrecioUnitario = precioUnitario;
	}

	
	
	public Pedido getIDPedido() {
		return IDPedido;
	}

	public void setIDPedido(Pedido iDPedido) {
		this.IDPedido = iDPedido;
	}

	public Libro getIDLibro() {
		return IDLibro;
	}

	public void setIDLibro(Libro iDLibro) {
		this.IDLibro = iDLibro;
	}
	
	@Override
	public String toString() {
		return "DetallePedido{"+
				"IDDetalle="+IDDetalle+
				", PrecioUnitario='"+PrecioUnitario+
				", IDPedido="+IDPedido+
				", IDLibro="+IDLibro+'\''+
				'}';
	}
	
}
