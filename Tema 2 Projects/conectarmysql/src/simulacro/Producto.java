package simulacro;

public class Producto {
    private int id;
    private String nombre;
    private String descripcion;
    private int precio;
    private String fabricante;
    private int n_serie;

    public Producto(int id, String nombre, String descripcion, String fabricante, int precio, int n_serie) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fabricante = fabricante;
        this.n_serie = n_serie;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public String getFabricante() {
        return fabricante;
    }
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    public int getN_serie() {
        return n_serie;
    }
    public void setN_serie(int n_serie) {
        this.n_serie = n_serie;
    }

}
