package org.SQL.MVC;

public class Game {
    private int idjuego;
    private String nombre;
    private int anio;
    private String compania;
    private float precio;
    private String sinopsis;
    private String plataforma;

    public Game(int idjuego, String nombre, int anio, String compania, float precio, String sinopsis, String plataforma) {
        this.idjuego = idjuego;
        this.nombre = nombre;
        this.anio = anio;
        this.compania = compania;
        this.precio = precio;
        this.sinopsis = sinopsis;
        this.plataforma = plataforma;
    }

    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public String getSinopsis() {
        return sinopsis;
    }
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
    public String getPlataforma() {
        return plataforma;
    }
    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
    public int getIdjuego() {
        return idjuego;
    }
    public void setIdjuego(int idjuego) {
        this.idjuego = idjuego;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getAnio() {
        return anio;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }
    public String getCompania() {
        return compania;
    }
    public void setCompania(String compania) {
        this.compania = compania;
    }
    @Override
    public String toString() {
        return "Game{" +
                "idjuego=" + idjuego +
                ", nombre='" + nombre + '\'' +
                ", anio=" + anio +
                ", compania='" + compania + '\'' +
                ", precio=" + precio +
                ", sinopsis='" + sinopsis + '\'' +
                ", plataforma='" + plataforma + '\'' +
                '}';
    }
}
