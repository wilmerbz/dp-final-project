package com.space.invaders.interfaces.controladores;

/**
 * Define la Interfaz para el Controlador principal.
 */
public interface IControladorPrincipal extends IControlador, IControladorEstadoJuego {
	
	/**
	 * Establece el controlador actual del estado juego.
	 * @param controladorEstadoJuego Controlador del estado juego.
	 */
	void establecerControladorEstadoJuegoActual(IControladorEstadoJuego controladorEstadoJuego);
	
}
