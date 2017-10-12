package com.space.invaders.interfaces.controladores;

import com.space.invaders.navegacion.AdministradorNavegacion;

/**
 * Define la interfaz para los controladores del juego.
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
