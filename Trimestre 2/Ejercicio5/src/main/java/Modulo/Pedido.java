package Modulo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")

public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDPedido")
	private int IDPedido;

	@Column(name = "FechaPedido")
	private Date FechaPedido;

	@Column(name = "Descuento")
	private float Descuento;
	
	@ManyToOne
	@JoinColumn(name = "IDCliente", nullable = false)
	private Cliente IDCliente;
	
	public Pedido() {
	}

	public Pedido(Date FechaPedido, float Descuento, Cliente IDCliente) {
		this.FechaPedido = FechaPedido;
		this.Descuento = Descuento;
		this.IDCliente = IDCliente;

	}

	public int getIDPedido() {
		return IDPedido;
	}

	public void setIDPedido(int iDPedido) {
		this.IDPedido = iDPedido;
	}

	public Date getFechaPedido() {
		return FechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.FechaPedido = fechaPedido;
	}

	public float getDescuento() {
		return Descuento;
	}

	public void setDescuento(float descuento) {
		this.Descuento = descuento;
	}

	public Cliente getIDCliente() {
		return IDCliente;
	}

	public void setIDCliente(Cliente iDCliente) {
		this.IDCliente = iDCliente;
	}
	
	@Override
	public String toString() {
		return "Pedido{"+
				"IDPedido="+IDPedido+
				", FechaPedido='"+FechaPedido+
				", Descuento="+Descuento+
				", IDCliente="+IDCliente+'\''+
				'}'; 
	}
}


