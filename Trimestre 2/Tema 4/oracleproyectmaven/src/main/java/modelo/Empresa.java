package modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Empresa {
    @Id
    private int id;
    private String nombre;
    private String pais;

    // Constructor sin argumentos requerido por Hibernate
    public Empresa() {
    }

    // Otros constructores y métodos getter/setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
