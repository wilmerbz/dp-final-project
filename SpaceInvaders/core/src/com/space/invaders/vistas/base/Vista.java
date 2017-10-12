package com.space.invaders.vistas.base;

import com.space.invaders.interfaces.controladores.IControlador;
import com.space.invaders.interfaces.vistas.IVista;

/**
 * Clase base para las vistas.
 */
public abstract class Vista implements IVista{

	/**
	 * Controlador.
	 */
	protected IControlador controlador;
	
	/**
	 * Crea una nueva instancia de la vista.
	 * @param controlador Controlador del estado del juego.
	 */
	public Vista(IControlador controlador) {
		this.controlador = controlador;
	}

}
