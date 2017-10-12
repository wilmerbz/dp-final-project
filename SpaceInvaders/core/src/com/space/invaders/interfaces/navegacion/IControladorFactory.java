package com.space.invaders.interfaces.navegacion;

import com.space.invaders.interfaces.controladores.IControlador;
import com.space.invaders.navegacion.RutaControlador;

/**
 * Define la Interfaz para la fabrica de controladores. 
 */
public interface IControladorFactory {

	/**
	 * Crea un nuevo controlador a partir de la información de la ruta.
	 * @param informacionRuta Información de la ruta del controlador.
	 * @return Controlador creado.
	 */
	public IControlador crearControlador(RutaControlador informacionRuta);
	
}
