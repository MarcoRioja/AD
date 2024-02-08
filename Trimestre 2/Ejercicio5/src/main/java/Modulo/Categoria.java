package Modulo;

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
@Table(name = "categoria")

public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDCategoria")
	private int IDCategoria;

	@Column(name = "NombreCategoria")
	private String NombreCategoria;
	
	@OneToMany(mappedBy = "IDCategoria", cascade = CascadeType.ALL)
    private List<Categoria> categorias = new ArrayList<>();
	
	@OneToMany(mappedBy = "IDAutor", cascade = CascadeType.ALL)
    private List<Autor> autores = new ArrayList<>();
	
	public Categoria() {
	}

	public Categoria(String nombreCategoria) {
		this.NombreCategoria = nombreCategoria;
	}

	public int getIDCategoria() {
		return IDCategoria;
	}

	public void setIDCategoria(int idCategoria) {
		this.IDCategoria = idCategoria;
	}

	public String getNombreCategoria() {
		return NombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.NombreCategoria = nombreCategoria;
	}
	
	@Override
	public String toString() {
		return "Categoria {"+
				"IDCategoria="+IDCategoria+
				", NombreCategoria='"+NombreCategoria+'\''+
				'}';
	}

}
