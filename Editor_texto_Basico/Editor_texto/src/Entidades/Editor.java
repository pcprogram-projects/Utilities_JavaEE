package Entidades;

import java.io.IOException;

public class Editor {

	private Archivo archivo;
	
	public Editor() {
		archivo=null;
	}
	/**
	 * Abrte un archivo de texto Existente
	 * @throws Exception 
	*/
	public String AbrirArchivo(String nombreArchivo) throws Exception {
		String contenido="";
		archivo =new Archivo(nombreArchivo);
		try {
			contenido= archivo.CrearContenido();
		} catch (IOException e) {
			throw new Exception ("Error al abrir el archivo",e);
		}
		return contenido;
	}
	/**
	 * Crea el archivo desde Cero
	 */
	public void CrearArchivo() {
		archivo=null;
	}
	/**
	 * 
	 Guarda el contenido del archivo ya sea nuevo o existente
	 * @throws Exception 
	 */
	public void GuardarArchivo(String contenido, String ruta) throws Exception {
		if (archivo ==null) {
			archivo =new Archivo(ruta);
		}
		try {
			archivo.Guardar(contenido);
		} catch (IOException e) {
			throw new Exception ("Error al guardar el archivo",e);
		}
	}
	
	/**
	 * indica si el archivo es nuevo
	 * @return
	 */
	public boolean ComprovarArchivo() {
		
		return archivo == null;
	}
}

