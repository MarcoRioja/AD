package vtx.mk.HospitalApp.Modelo;

import javax.persistence.*;

@Entity
@Table(name = "medicos")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToMany(mappedBy = "id_medico", cascade = CascadeType.ALL)
    @Column(name = "id") // Cambiar el nombre de la columna aquí
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "especialidad")
    private String especialidad;

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
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.especialidad = especialidad;
    }

    public int getId() {
        return id;
    }

    // Método para imprimir información del objeto fabricante
    @Override
    public String toString() {
        return "Medico: {" +
                "id=" + id +
                ", nombre='" + nombre +
                ", apellidos='" + apellidos +
                ", especialidad='" + especialidad +
                '}';
    }
}
