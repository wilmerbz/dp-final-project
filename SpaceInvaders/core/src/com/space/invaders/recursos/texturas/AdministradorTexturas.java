package com.space.invaders.recursos.texturas;

import java.util.HashMap;
import java.util.Hashtable;

import com.badlogic.gdx.graphics.Texture;

/**
 * Administra las texturas y permite reutilizarlas, por medio del patrón Flyweight.
 */
public class AdministradorTexturas implements IAdministradorTexturas {

	
	private HashMap<String, Texture> texturas;
	
	private static IAdministradorTexturas _instancia;
	
	/**
	 * Crea una nueva instancia del administrador de texturas.
	 */
	private AdministradorTexturas() {
		texturas = new HashMap<String, Texture>();
	}
	
	/**
	 * Obtiene la instancia unica del administrador de texturas.	
	 * @return Administrador de texturas.
	 */
	public synchronized static IAdministradorTexturas getInstancia() {
		if(_instancia == null) {
			_instancia = new AdministradorTexturas();
		}
		
		return _instancia;
	}
	
	@Override
	public Texture obtenerTextura(String nombreTextura) {
		
		if(texturas.containsKey(nombreTextura)) {
			return texturas.get(nombreTextura);
		}
		
		Texture textura = cargarTextura(nombreTextura);
		
		return textura;
	}
	
	private final String _formatoRutaArchivoTextura = "images/%s/%s.png";
	
	private synchronized Texture cargarTextura(String nombreTextura) {
		String rutaArchivoTextura = String.format(_formatoRutaArchivoTextura ,NombreTextura.FOLDER, nombreTextura);
		Texture textura = new Texture(rutaArchivoTextura);
		
		if(!texturas.containsKey(nombreTextura)) {
			texturas.put(nombreTextura, textura);
		}
		
		return textura;
	}

}
