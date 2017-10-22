package com.space.invaders.vistas.base;

import com.badlogic.gdx.Gdx;
import com.space.invaders.interfaces.controladores.IControlador;
import com.space.invaders.interfaces.vistas.IVista;

/**
 * Clase base para las vistas.
 */
public abstract class Vista implements IVista{

	protected static int WIDTH;
	protected static int HEIGHT;
	
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
		
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();
	}

}
