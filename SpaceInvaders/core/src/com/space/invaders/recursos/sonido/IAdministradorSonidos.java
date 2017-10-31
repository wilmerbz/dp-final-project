package com.space.invaders.recursos.sonido;

import com.badlogic.gdx.audio.Sound;

/**
 * Interfaz para el administrador de sonido.
 */
public interface IAdministradorSonidos {
	
	/**
	 * Reproduce el sonido.
	 * @param nombre Nombre del sonido a reproducir.
	 */
	void reproducirSonido(String nombre);
	
	/**
	 * Reproduce un sonido de manera continua.
	 * @param nombre Nombre del sonido a reproducir.
	 */
	void reproducirBucleSonido(String nombre);
	
	/**
	 * Detiene el sonido.
	 * @param nombre Nombre del sonido a detener.
	 */
	void detenerSonido(String nombre);
	
	/**
	 * Detiene todos los sonidos.
	 */
	void detenerTodo();
	
	/**
	 * Obtiene el sonido.
	 * @param nombre Nombre del sonido a cargar.
	 * @return Sonido cargado.
	 */
	Sound obtenerSonido(String nombre);
}
