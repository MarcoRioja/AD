package org.example.individuales;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class LeerDosFicheros {
	public static void main(String[] args) {
	
		try {
			BufferedReader br1= new BufferedReader(new FileReader("c://prueba//malaga.txt"));
			BufferedReader br2= new BufferedReader (new FileReader("c://prueba//fruta.txt"));
			BufferedWriter bw=new BufferedWriter(new FileWriter("c://prueba//union.txt",true));
			String linea1="";
			String linea2="";
			while (linea1!=null || linea2!=null) {
				linea1=br1.readLine();
				linea2=br2.readLine();
				if (linea1 !=null) {
					bw.write(linea1+"\n");
								
				}
				if (linea1 !=null) {
					bw.write(linea2+"\n");
								
				}
				
			}
			System.out.println("proceso realizado con exito");
					
			
			br1.close();
			br2.close();
			bw.close();
		} catch (FileNotFoundException fnfe) { // qué hacer si no se encuentra el fichero
			System.out.println("No se encuentran los ficheros");
		} catch (IOException ioe) { // qué hacer si hay un error en la lectura del fichero
			System.out.println("No se puede leer los ficheros");
		}
	
	
	

}
}