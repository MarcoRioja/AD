package modelovistacontrolador;
import java.util.List;
import java.sql.Connection;

public class ClienteView {
    // Método para mostrar los clientes en la vista
    public void mostrarClientes(List<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            System.out.println("ID: " + cliente.getId()); // Imprime el ID del cliente
            System.out.println("NIF: " + cliente.getNif()); // Imprime el NIF del cliente
            System.out.println("Nombre: " + cliente.getNombre()); // Imprime el nombre del cliente
            System.out.println("Edad: " + cliente.getEdad()); // Imprime la edad del cliente
            System.out.println(); // Imprime una línea en blanco para separar los clientes
        }
    }
}
