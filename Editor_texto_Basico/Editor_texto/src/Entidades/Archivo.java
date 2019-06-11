package Entidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Archivo {
 
	private File archivo;
	/**
	 Crea el Archivo
	 */
	public Archivo(String nombreArchivo) {
		archivo = new File(nombreArchivo);
	}
	
	/**
	 * 
	Escribe y lee el contenido del Archivo
	 */
	public String CrearContenido() throws IOException{
		String contenido="";		
		FileReader fr=new FileReader(archivo);
		BufferedReader lector=new BufferedReader(fr);
	    String linea=lector.readLine();
	    
	    while(linea !=null) {
	    	
	    	contenido+=linea + "\n";
	    	linea=lector.readLine();
	    }
	    lector.close();
	    fr.close();
		return contenido;
	}
	/**
	 * 
	Guarda el contenido en el archivo
	 */
	public void Guardar(String contenido)throws IOException{
		PrintWriter escritor=new PrintWriter(archivo);
		escritor.write(contenido);
		escritor.close();
	}
}
