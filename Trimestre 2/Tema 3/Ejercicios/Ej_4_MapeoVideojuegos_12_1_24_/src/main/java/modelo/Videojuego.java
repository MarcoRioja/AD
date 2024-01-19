package modelo;

import javax.persistence.*;

@Entity
@Table(name = "tvideojuegos")

public class Videojuego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idjuego")
    private int idjuego;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "anio")
    private int anio;
    @Column(name = "empresa")
    private String empresa;
    @Column(name = "precio")
    private float precio;
    @Column(name = "sinopsis")
    private String sinopsis;
    @Column(name = "plataforma")
    private String plataforma;

    public Videojuego() {}

    public Videojuego(String nombre, int anio, String empresa, float precio, String sinopsis, String plataform) {
        this.nombre = nombre;
        this.anio = anio;
        this.empresa = empresa;
        this.precio = precio;
        this.sinopsis = sinopsis;
        this.plataforma = plataform;
    }

    @Override
    public String toString() {
        return String.format("Videojuego {%d, %s, %d, %s, %f€, %s, %s}", idjuego, nombre, anio, empresa, precio, sinopsis, plataforma);
    }
}

