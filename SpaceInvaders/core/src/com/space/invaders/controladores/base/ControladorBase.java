package com.space.invaders.controladores.base;

import com.space.invaders.interfaces.controladores.IControlador;
import com.space.invaders.interfaces.vistas.IVista;
import com.space.invaders.navegacion.AdministradorEstados;
import com.space.invaders.navegacion.NombreEstado;

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
	 * @param nombreEstado Nombre de ruta.
	 */
	protected void navegarControlador(NombreEstado nombreEstado) {
		AdministradorEstados.getInstancia().setEstado(nombreEstado);
	}
	
	
}
