package phoneland;
import java.util.List;

public class ProductoView {
    public void mostrarProductos(List<Producto> productos) {
        for (Producto producto : productos) {
            System.out.println("ID PRODUCTO: " + producto.getId_PRODUCTO());
            System.out.println("FABRICANTE: " + producto.getFABRICANTE());
            System.out.println("NOMBRE: " + producto.getNOMBRE());
            System.out.println("PRECIO: " + producto.getPRECIO());
            System.out.println("PVP: " + producto.getPVP());
            System.out.println("Descripcion: " + producto.getDescripcion());
            System.out.println();
        }
    }
}
