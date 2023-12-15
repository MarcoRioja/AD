package org.example.MVC;

import java.util.List;

public class InstitutoView {
    // Método para mostrar los alumnos en la vista
    public void mostrarAlumnos(List<Alumno> clientes) {
        for (Alumno game : clientes) {
            System.out.println(game.toString());
        }
    }
}
