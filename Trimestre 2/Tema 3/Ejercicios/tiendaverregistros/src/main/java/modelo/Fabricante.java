package modelo;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "fabricante")
public class Fabricante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo") // Cambiar el nombre de la columna aquí
    private int id;

    @Column(name = "nombre")
    private String nombre;

    // Constructor por defecto requerido por Hibernate
    public Fabricante() {
    }

    // Constructor para crear un objeto de tipo fabricante con un nombre específico
    public Fabricante(String nombre) {
        this.nombre = nombre;
    }

    // Getter y setter para el atributo id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter y setter para el atributo nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método para imprimir información del objeto fabricante
    @Override
    public String toString() {
        return "fabricante{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
