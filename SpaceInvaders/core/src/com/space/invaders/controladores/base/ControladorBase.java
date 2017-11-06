package com.space.invaders.controladores.base;

import com.space.invaders.interfaces.controladores.IControlador;
import com.space.invaders.interfaces.vistas.IVista;
import com.space.invaders.navegacion.AdministradorEstados;
import com.space.invaders.navegacion.NombreEstado;
import com.space.invaders.recursos.sonido.AdministradorSonidos;

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
	 * Reproduce el sonido indicado, utilizando el administrador de sonido.
	 * @param nombreSonido Nombre del sonido a reproducir.
	 */
	protected void reproducirSonido(String nombreSonido) {
		AdministradorSonidos.getInstancia().reproducirSonido(nombreSonido);
	}
	
	
}
