package com.space.invaders.interfaces.estados;

import com.space.invaders.interfaces.controladores.IControlador;
import com.space.invaders.navegacion.ConfiguracionControladorEstado;

/**
 * Define la Interfaz para la fabrica de controladores. 
 */
public interface IControladorFactory {

	/**
	 * Crea un nuevo controlador a partir de la informaci�n del estado.
	 * @param informacionRuta Informaci�n del estado.
	 * @return Controlador creado.
	 */
	public IControlador crearControlador(ConfiguracionControladorEstado informacionRuta);
	
}