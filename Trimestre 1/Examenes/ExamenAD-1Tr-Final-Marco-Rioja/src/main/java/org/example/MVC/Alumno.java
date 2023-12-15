package org.example.MVC;

public class Alumno {
    private int idAlumno;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String fechaNacimiento;
    private String esRepetidor;
    private int telefono;

    public Alumno(int idAlumno, String nombre, String apellido1, String apellido2, String fechaNacimiento, String esRepetidor, int telefono) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
        this.esRepetidor = esRepetidor;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Alumno { " + idAlumno + ", " + nombre + ", " + apellido1 + ", " + apellido2 + ", " + fechaNacimiento + ", "
                + esRepetidor + ", " + telefono + " }";
    }
}
