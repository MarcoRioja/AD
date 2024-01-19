package modelo;

import javax.persistence.*;

@Entity
@Table(name = "productos")

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "precio")
    private float precio;
    @Column(name = "fabricante")
    private String fabricante;
    @Column(name = "unidades")
    private int unidades;

    public Producto() {
    }

    public Producto(String nombre, String descripcion, float precio, String fabricante, int unidades) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fabricante = fabricante;
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return String.format("Prodcuto{nombre= %s, descripcion= %s, precio= %.2f, fabricante= %s, unidades= %d}",nombre,descripcion,precio,fabricante,unidades);
    }
}

