package com.space.invaders.controladores.base;

import com.space.invaders.interfaces.controladores.IControladorEstadoJuego;
import com.space.invaders.navegacion.AdministradorEstados;
import com.space.invaders.navegacion.NombreEstado;

/**
 * Clase base para los controladores de estado del juego.
 */
public abstract class ControladorEstadoJuegoBase extends ControladorBase implements IControladorEstadoJuego{
	
	/**
	 * Cambiar al estado indicado.
	 * @param nombreEstado Nombre del estado.
	 */
	protected void cambiarEstado(NombreEstado nombreEstado) {
		AdministradorEstados.getInstancia().setEstado(nombreEstado);
	}
}