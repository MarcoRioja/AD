package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String ruta = "prueba1";
        File fichero = new File(ruta);

        if (fichero.mkdir()) {
            System.out.println("Carpeta creada");
        } else {
            System.err.println("No se pudo crear la carpeta");
            if (fichero.exists()) {
                System.err.println("La carpeta ya existe");
            }
        }
    }
}