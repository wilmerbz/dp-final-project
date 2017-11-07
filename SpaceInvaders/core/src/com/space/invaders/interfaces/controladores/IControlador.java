package com.space.invaders.interfaces.controladores;

/**
 * Define la interfaz del controlador.
 */
public interface IControlador {
	
	/**
	 * Inicializar el controlador.
	 */
	void inicializar();
	
	/**
	 * Asigna la bandera que indica si el controlador ya fue inicializado.
	 * @param inicializado Iniciado.
	 */
	void setInicializado(boolean inicializado);
	
	/**
	 * Inidica si el controlador ya fue inicializado.
	 * @return Iniciado.
	 */
	boolean isInicializado();
	
}