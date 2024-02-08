package vtx.mk.HospitalApp.Modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_paciente")
    private int id_paciente;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "tlf")
    private String tlf;

    @Column(name = "edad")
    private int edad;

    @Column(name = "historial")
    private String historial;

    @OneToMany(mappedBy = "id_paciente", cascade = CascadeType.ALL)
    private List<Cita> citas = new ArrayList<>();

    // Constructor por defecto requerido por Hibernate
    public Paciente() {
    }

    // Constructor para crear un objeto de tipo fabricante con un nombre específico
    public Paciente(String nombre, String apellidos, String ciudad, String direccion, String tlf, int edad, String historial) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.tlf = tlf;
        this.edad = edad;
        this.historial = historial;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    // Método para imprimir información del objeto fabricante
    @Override
    public String toString() {
        return "Paciente: {" +
                "id=" + id_paciente +
                ", nombre='" + nombre +
                ", apellidos='" + apellidos +
                ", ciudad='" + ciudad +
                ", direccion='" + direccion +
                ", tlf='" + tlf +
                ", edad='" + edad +
                ", historial='" + historial +
                '}';
    }
}
