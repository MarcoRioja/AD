package vtx.mk.HospitalApp.Modelo;

import javax.persistence.*;

@Entity
@Table(name = "citas")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Cambiar el nombre de la columna aquí
    private int id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente")
    private int id_paciente;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medico")
    private int id_medico;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "hora")
    private String hora;


    // Constructor por defecto requerido por Hibernate
    public Cita() {
    }

    // Constructor para crear un objeto de tipo fabricante con un nombre específico
    public Cita(int id_paciente, int id_medico, String fecha, String hora) {
        this.id_paciente = id_paciente;
        this.id_medico = id_medico;
        this.fecha = fecha;
        this.hora = hora;
    }
    // Constructor para crear un objeto de tipo fabricante con un nombre específico
    public Cita(int id, int id_paciente, int id_medico, String fecha, String hora) {
        this.id = id;
        this.id_paciente = id_paciente;
        this.id_medico = id_medico;
        this.fecha = fecha;
        this.hora = hora;
    }

    // Método para imprimir información del objeto fabricante
    @Override
    public String toString() {
        return "Cita: {" +
                "id=" + id +
                ", id_paciente='" + id_paciente +
                ", id_medico='" + id_medico +
                ", fecha='" + fecha +
                ", hora='" + hora +
                '}';
    }
}
