package simulacro;
import java.util.List;

public class ProductoView {
    public void mostrarProductos(List<Producto> productos) {
        for (Producto producto : productos) {
            System.out.println("ID: " + producto.getId());
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Descripcion: " + producto.getDescripcion());
            System.out.println("Fabricante: " + producto.getFabricante());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("N Serie: " + producto.getN_serie());
            System.out.println();
        }
    }
}
