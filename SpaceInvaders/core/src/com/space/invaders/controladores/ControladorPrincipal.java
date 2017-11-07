package com.space.invaders.controladores;

import com.space.invaders.interfaces.controladores.IControladorEstadoJuego;
import com.space.invaders.interfaces.controladores.IControladorPrincipal;
import com.space.invaders.interfaces.vistas.IVista;

/**
 * Controlador principal del juego. Representa el contexto para los diferentes estados del juego.
 */
public class ControladorPrincipal implements IControladorPrincipal {

	private IControladorEstadoJuego _controladorEstadoJuego;
	private boolean inicializado;
	
	@Override
	public void inicializar() {
		System.out.println("Iniciando ControladorPrincipal");
		this.inicializado = true;
	}
	
	/**
	 * Establece el controlador actual del estado del juego.
	 * @param controladorEstadoJuego Controlador del juego.
	 */
	@Override
	public void setControladorEstadoJuegoActual(IControladorEstadoJuego controladorEstadoJuego){
		this._controladorEstadoJuego = controladorEstadoJuego;
	}


	@Override
	public void actualizar(float deltaTiempo) {
		_controladorEstadoJuego.actualizar(deltaTiempo);
	}

	@Override
	public void renderizar() {
		_controladorEstadoJuego.renderizar();
	}

	@Override
	public void manejarEntradas() {
		_controladorEstadoJuego.manejarEntradas();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		_controladorEstadoJuego.dispose();
		
	}

	@Override
	public void setInicializado(boolean inicializado) {
		this.inicializado = true;
	}

	@Override
	public boolean isInicializado() {
		return this.inicializado;
	}

}
