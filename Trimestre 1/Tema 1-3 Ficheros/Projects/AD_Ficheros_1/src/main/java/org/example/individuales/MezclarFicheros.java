package org.example.individuales;

import java.io.*;

public class MezclarFicheros {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Error: debe proporcionar los nombres de los dos ficheros origen y el nombre del fichero destino");
            System.exit(1);
        }
        String fichero1 = args[0];
        String fichero2 = args[1];
        String ficheroDestino = args[2];
        try (BufferedReader br1 = new BufferedReader(new FileReader(fichero1));
             BufferedReader br2 = new BufferedReader(new FileReader(fichero2));
             BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroDestino))) {
            String linea1 = null;
            String linea2 = null;
            while ((linea1 = br1.readLine()) != null || (linea2 = br2.readLine()) != null) {
                if (linea1 != null) {
                    bw.write(linea1);
                    bw.newLine();
                }
                if (linea2 != null) {
                    bw.write(linea2);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}