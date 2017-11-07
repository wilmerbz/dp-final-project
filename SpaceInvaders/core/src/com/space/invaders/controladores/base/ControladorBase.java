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

	private boolean inicializado;

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
	
	/**
	 * Inidica si el controlador ya fue inicializado.
	 * @return Iniciado.
	 */
	@Override
	public boolean isInicializado() {
		return inicializado;
	}


	/**
	 * Asigna la bandera que indica si el controlador ya fue inicializado.
	 * @param inicializado Iniciado.
	 */
	@Override
	public void setInicializado(boolean inicializado) {
		this.inicializado = inicializado;
	}

	
}
