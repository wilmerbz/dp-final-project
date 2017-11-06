package com.space.invaders.interfaces.estados;

import com.space.invaders.interfaces.controladores.IControladorEstadoJuego;
import com.space.invaders.interfaces.controladores.IControladorPrincipal;
import com.space.invaders.interfaces.vistas.IVista;
import com.space.invaders.navegacion.NombreEstado;

/***
 * Interfaz para Administrador de Estados
 */
public interface IAdministradorEstados {
	
	/**
	 * Asigna el controlador principal.
	 * @param controladorPrincipal Controlador principal.
	 */
	public void setControladorPrincipal(IControladorPrincipal controladorPrincipal);
	
	/**
	 * Registra el estado en el Administrador de Estados.
	 * @param nombreEstado Nombre de ruta a registrar.
	 * @param nombreClaseControlador Nombre de clase del controlador a ejecutar.
	 * @param isSingleton Indica si la instancia ser� singleton o se crear� una nueva cada vez que se navegue al controlador.
	 */
	public void agregarEstado(NombreEstado nombreEstado, String nombreClaseControlador, boolean isSingleton);
	
	/***
	 * Remueve la ruta del administrador de Estados.
	 * @param nombreEstado Nombre del estado a remover.
	 */
	public void removerEstado(NombreEstado nombreEstado);
	
	/*
	 * Cambia el estado del controlador principal, al estado indicado.
	 * @param nombreEstado Nombre del estado.
	 */
	public void setEstado(NombreEstado nombreEstado);
	
	/**
	 * Establece el controlador actual del estado del juego, en el controlador principal.
	 * @param controladorJuego Controlador del estado del juego.
	 */
	void setControladorEstadoJuegoActual(IControladorEstadoJuego controladorJuego);
}