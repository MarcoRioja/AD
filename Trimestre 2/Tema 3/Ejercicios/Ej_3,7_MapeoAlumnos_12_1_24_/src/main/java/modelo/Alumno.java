package modelo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "alumno")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido1")
    private String apellido1;
    @Column(name = "apellido2")
    private String apellido2;
    @Column(name = "fecha_nacimiento")
    private Date fecha_nacimiento;
    @Column(name = "es_repetidor")
    private String es_repetidor;
    @Column(name = "teléfono")
    private String telefono;

    public Alumno() {}

    public Alumno(String nombre, String apellido1, String apellido2, Date fecha_nacimiento, String es_repetidor, String telefono) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fecha_nacimiento = fecha_nacimiento;
        this.es_repetidor = es_repetidor;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return String.format("Alumno {%s %s %s, %s, %s, %s}", nombre, apellido1, apellido2, fecha_nacimiento.toString(), es_repetidor, telefono);
    }
}
