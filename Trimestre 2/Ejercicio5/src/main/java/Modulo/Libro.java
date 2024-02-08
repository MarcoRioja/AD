package Modulo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "libro")

public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDLibro")
	private int IDLibro;

	@Column(name = "Titulo")
	private String Titulo;

	@Column(name = "ISBN")
	private String ISBN;
	
	@Column(name = "Precio")
	private float Precio;
	
	@Column(name = "Stock")
	private int Stock;

	@ManyToOne
	@JoinColumn(name = "IDAutor", nullable = false)
	private Autor IDAutor;
	
	@ManyToOne
	@JoinColumn(name = "IDCategoria", nullable = false)
	private Categoria IDCategoria;
	
	public Libro() {
    }

    // Constructor para crear un objeto de tipo Clientes con un nombre y una ciudad espec�ficos
    public Libro(String Titulo, String ISBN, float Precio, int Stock, Autor IDAutor, Categoria IDCategoria) {
        this.Titulo = Titulo;
        this.ISBN=ISBN;
        this.Precio=Precio;
        this.Stock=Stock;
        this.IDAutor=IDAutor;
        this.IDCategoria=IDCategoria;       
    }

	public int getIDLibro() {
		return IDLibro;
	}

	public void setIDLibro(int iDLibro) {
		this.IDLibro = iDLibro;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		this.Titulo = titulo;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		this.ISBN = iSBN;
	}

	public float getPrecio() {
		return Precio;
	}

	public void setPrecio(float precio) {
		this.Precio = precio;
	}

	public int getStock() {
		return Stock;
	}

	public void setStock(int stock) {
		this.Stock = stock;
	}

    
	public Autor getIDAutor() {
		return IDAutor;
	}

	public void setIDAutor(Autor iDAutor) {
		this.IDAutor = iDAutor;
	}

	public Categoria getIDCategoria() {
		return IDCategoria;
	}

	public void setIDCategoria(Categoria iDCategoria) {
		this.IDCategoria = iDCategoria;
	}

	@Override
	public String toString() {
		return "Libro{"+
				"IDLibro="+IDLibro+
				", Titulo='"+Titulo+
				", ISBN="+ISBN+
				", Precio="+Precio+
				", Stock="+Stock+
				", IDAutor="+IDAutor+
				", IDCategoria="+IDCategoria+'\''+
				'}'; 
	}
    
}
