package vtx.mk.HospitalApp.Modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "medicos")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_medico")
    private int id_medico;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "especialidad")
    private String especialidad;

    @OneToMany(mappedBy = "id_medico", cascade = CascadeType.ALL)
    private List<Cita> citas = new ArrayList<>();

    // Constructor por defecto requerido por Hibernate
    public Medico() {
    }

    // Constructor para crear un objeto de tipo fabricante con un nombre específico
    public Medico(String nombre, String apellidos, String especialidad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.especialidad = especialidad;
    }

    public Medico(int id,String nombre, String apellidos, String especialidad) {
        this.id_medico = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.especialidad = especialidad;
    }

    public int getId_medico() {
        return id_medico;
    }

    // Método para imprimir información del objeto fabricante
    @Override
    public String toString() {
        return "Medico: {" +
                "id=" + id_medico +
                ", nombre='" + nombre +
                ", apellidos='" + apellidos +
                ", especialidad='" + especialidad +
                '}';
    }
}
