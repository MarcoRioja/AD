package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ListaDeCiudades {
    public static void main(String[] args) {
        String ruta = "prueba1/";
        File fichero = new File(ruta);

        String nombreArchivo = "ciudadesDeAndalucia.txt";
        String[] contenidoArchivo = {"Malaga","Sevilla","Cordoba","Cadiz", "Huelva", "Almeria", "Jaen", "Granada"};
        try (BufferedWriter fw = new BufferedWriter(new FileWriter(ruta + nombreArchivo))) {
            System.out.println("Archivo " + nombreArchivo + " creado.");
            for (String element : contenidoArchivo) {
                fw.write(element + "\n");
            }
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
