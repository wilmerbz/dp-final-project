package com.space.invaders.interfaces.navegacion;

import com.space.invaders.interfaces.controladores.IControladorEstadoJuego;
import com.space.invaders.interfaces.controladores.IControladorPrincipal;
import com.space.invaders.interfaces.vistas.IVista;
import com.space.invaders.navegacion.NombreRuta;

/***
 * Interfaz para Administrador de Navegación.
 */
public interface IAdministradorNavegacion {
	
	/**
	 * Asigna el controlador principal.
	 * @param controladorPrincipal Controlador principal.
	 */
	public void setControladorPrincipal(IControladorPrincipal controladorPrincipal);
	
	/**
	 * Registra la ruta en el Administrador de Navegación.
	 * @param nombreRuta Nombre de ruta a registrar.
	 * @param nombreClaseControlador Nombre de clase del controlador a ejecutar.
	 * @param isSingleton Indica si la instancia será singleton o se creará una nueva cada vez que se navegue al controlador.
	 */
	public void agregarRuta(NombreRuta nombreRuta, String nombreClaseControlador, boolean isSingleton);
	
	/***
	 * Remueve la ruta del administrador de navegación.
	 * @param nombreRuta Nombre de ruta a remover.
	 */
	public void removerRuta(NombreRuta nombreRuta);
	
	/*
	 * Navega a la ruta indicada.
	 * @param nombreRuta Nombre de la ruta.
	 */
	public void navegar(NombreRuta nombreRuta);
	
	/**
	 * Establece el controlador actual del estado del juego, en el controlador principal.
	 * @param controladorJuego Controlador del estado del juego.
	 */
	void establecerControladorEstadoJuegoActual(IControladorEstadoJuego controladorJuego);
}
