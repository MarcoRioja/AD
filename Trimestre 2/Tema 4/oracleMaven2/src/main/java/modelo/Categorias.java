package modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Categorias {
	@Id
    private int id;
    private String categoria;
    private String subcategoria;
	public Categorias() {
		super();
	}
	public Categorias(int id, String categoria, String subcategoria) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.subcategoria = subcategoria;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getSubcategoria() {
		return subcategoria;
	}
	public void setSubcategoria(String subcategoria) {
		this.subcategoria = subcategoria;
	}
	@Override
	public String toString() {
		return "Categorias [id=" + id + ", categoria=" + categoria + ", subcategoria=" + subcategoria + "]";
	}

}
