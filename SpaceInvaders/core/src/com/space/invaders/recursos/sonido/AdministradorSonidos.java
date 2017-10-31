package com.space.invaders.recursos.sonido;

import java.util.HashMap;
import java.util.Hashtable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

/**
 * Administrador de sonidos.
 */
public class AdministradorSonidos  implements IAdministradorSonidos{

	private HashMap<String, Sound> sonidos; 
	private final String _formatoRutaArchivoSonido = "sounds/%s.mp3";
	
	private static IAdministradorSonidos _instancia;
	
	/**
	 * Crea una nueva instancia del administrador de texturas.
	 */
	private AdministradorSonidos() {
		sonidos = new HashMap<String, Sound>();
	}
	
	/**
	 * Obtiene la instancia unica del administrador de sonidos.
	 * @return Administrador de sonidos.
	 */
	public static IAdministradorSonidos getInstancia() {
		if(_instancia == null) {
			_instancia = new AdministradorSonidos();
		}
		
		return _instancia;
	}
	
	@Override
	public void reproducirSonido(String nombre) {
		Sound sonido = obtenerSonido(nombre);
		if(sonido!=null) {
			sonido.play();
		}
	}

	@Override
	public void reproducirBucleSonido(String nombre) {
		Sound sonido =obtenerSonido(nombre);
		if(sonido!=null) {
			sonido.loop();
		}
	}

	@Override
	public void detenerSonido(String nombre) {
		Sound sonido =obtenerSonido(nombre);
		if(sonido!=null) {
			sonido.stop();
		}
	}

	@Override
	public void detenerTodo() {
		for (Sound sonido : sonidos.values()) {
			sonido.stop();
		}
	}

	@Override
	public Sound obtenerSonido(String nombre) {
		Sound sonido = null;
		try {
			if(sonidos.containsKey(nombre)) {
				sonido = sonidos.get(nombre);
			}else{
				String rutaArchivo = String.format(_formatoRutaArchivoSonido , nombre);
				sonido = Gdx.audio.newSound(Gdx.files.internal(rutaArchivo));
				sonidos.put(nombre, sonido);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sonido;
	}

}
