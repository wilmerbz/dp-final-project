package com.space.invaders.controladores.base;

import com.space.invaders.interfaces.controladores.IControlador;
import com.space.invaders.interfaces.vistas.IVista;
import com.space.invaders.navegacion.AdministradorNavegacion;
import com.space.invaders.navegacion.NombreRuta;

/**
 * Clase base para los controladores.
 */
public abstract class ControladorBase implements IControlador {


	/**
	 * Crea una nueva instancia del controlador.
	 */
	public ControladorBase() {
		
	}
	
	
	/**
	 * Navegar a la ruta indicada.
	 * @param nombreRuta Nombre de ruta.
	 */
	protected void navegarControlador(NombreRuta nombreRuta) {
		AdministradorNavegacion.getInstancia().navegar(nombreRuta);
	}
	
	
}
