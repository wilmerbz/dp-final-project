package com.space.invaders.interfaces.controladores;

import java.util.List;

import com.space.invaders.actores.ElementoJuego;
import com.space.invaders.navegacion.AdministradorEstados;

/**
 * Define la interfaz para los controladores de estado del juego.
 */
public interface IControladorEstadoJuego extends IControlador {

	
	/***
	 * Actualiza el estado del juego.
	 * @param deltaTiempo Tiempo transcurrido entre el frame actual y el anterior.
	 */
	void actualizar(float deltaTiempo);
	
	/***
	 * Renderiza el estado del juego.
	 */
	void renderizar();
	
	/***
	 * Maneja entradas del usuario.
	 */
	void manejarEntradas();
	
	/***
	 * Dispone del controlador del estado del juego.
	 */
	void dispose();

}
