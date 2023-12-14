package org.example.individuales;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ArchivoDeMalaga {
    public static void main(String[] args) {
        String ruta = "prueba1/";
        File fichero = new File(ruta);

        String nombreArchivo = "malaga.txt";
        String contenidoArchivo = "Malaga es la mejor del mundo";
        try (BufferedWriter fw = new BufferedWriter(new FileWriter(ruta + nombreArchivo))) {
            System.out.println("Archivo " + nombreArchivo + " creado.");
            fw.write(contenidoArchivo);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al crear el archivo.");
        }

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
