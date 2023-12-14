package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeerFichero {
    public static void main(String[] args) {
        try {
            File file = new File("prueba1/ciudadesDeAndalucia.txt");
            if (!file.exists()) {
                System.err.println("El archivo no existe");
                return;
            }
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("\t" + line);
            }

            fr.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}