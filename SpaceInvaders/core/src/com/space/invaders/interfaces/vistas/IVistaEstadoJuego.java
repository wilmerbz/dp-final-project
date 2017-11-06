package com.space.invaders.interfaces.vistas;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/***
 * Define la interfaz para las vistas de los estados del juego.
 */
public interface IVistaEstadoJuego extends IVista{


	/***
	 * Inicializa la vista del estado del juego.
	 */
	void inicializar();
	
	/***
	 * Actualiza la vista del estado del juego.
	 * @param deltaTiempo Tiempo transcurrido entre el frame actual y el anterior.
	 */
	void actualizar(float deltaTiempo);
	
	/***
	 * Renderiza el estado del juego.
	 */
	void renderizar();
	

	
	/***
	 * Dispone de la vista del estado del juego.
	 */
	void dispose();
	
	/**
	 * Obtiene el sprite batch de la vista de estado del juego.
	 * @return Sprite batch.
	 */
	SpriteBatch getSpriteBatch();
}