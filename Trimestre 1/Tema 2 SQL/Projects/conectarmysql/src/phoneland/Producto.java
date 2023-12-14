package phoneland;

public class Producto {
    private int id_PRODUCTO;
    private int id_proveedor;
    private String NOMBRE;
    private String FABRICANTE;
    private String PRECIO;
    private float PVP;
    private String Descripcion;

    public Producto(int id_PRODUCTO, int id_proveedor, String NOMBRE, String FABRICANTE, String PRECIO, float PVP, String descripcion) {
        this.id_PRODUCTO = id_PRODUCTO;
        this.id_proveedor = id_proveedor;
        this.NOMBRE = NOMBRE;
        this.FABRICANTE = FABRICANTE;
        this.PRECIO = PRECIO;
        this.PVP = PVP;
        this.Descripcion = descripcion;
    }

    public int getId_PRODUCTO() {
        return id_PRODUCTO;
    }
    public void setId_PRODUCTO(int id_PRODUCTO) {
        this.id_PRODUCTO = id_PRODUCTO;
    }
    public int getId_proveedor() {
        return id_proveedor;
    }
    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }
    public String getNOMBRE() {
        return NOMBRE;
    }
    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }
    public String getFABRICANTE() {
        return FABRICANTE;
    }
    public void setFABRICANTE(String FABRICANTE) {
        this.FABRICANTE = FABRICANTE;
    }
    public String getPRECIO() {
        return PRECIO;
    }
    public void setPRECIO(String PRECIO) {
        this.PRECIO = PRECIO;
    }
    public float getPVP() {
        return PVP;
    }
    public void setPVP(float PVP) {
        this.PVP = PVP;
    }
    public String getDescripcion() {
        return Descripcion;
    }
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

}
