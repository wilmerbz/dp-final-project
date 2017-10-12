package com.space.invaders.vistas.base;

import com.space.invaders.interfaces.controladores.IControladorEstadoJuego;
import com.space.invaders.interfaces.vistas.IVistaEstadoJuego;;

/**
 * Clase base para las vistas de estado del juego.
 */
public abstract class VistaEstadoJuego extends Vista implements IVistaEstadoJuego {

	/**
	 * Controlador del estado del juego.
	 */
	protected IControladorEstadoJuego controladorEstadoJuego;
	
	/**
	 * Crea una nueva instancia de la vista de estado del juego.
	 * @param controladorEstadoJuego Controador de estado del juego.
	 */
	public VistaEstadoJuego(IControladorEstadoJuego controladorEstadoJuego) {
		super(controladorEstadoJuego);
		this.controladorEstadoJuego = controladorEstadoJuego;
	}

}
