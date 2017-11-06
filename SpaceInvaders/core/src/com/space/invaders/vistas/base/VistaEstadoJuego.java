package com.space.invaders.vistas.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.space.invaders.SpaceInvadersGame;
import com.space.invaders.interfaces.controladores.IControladorEstadoJuego;
import com.space.invaders.interfaces.vistas.IVistaEstadoJuego;;

/**
 * Clase base para las vistas de estado del juego.
 */
public abstract class VistaEstadoJuego extends Vista implements IVistaEstadoJuego {

	protected SpriteBatch spriteBatch;
	
	/**
	 * Controlador del estado del juego.
	 */
	protected IControladorEstadoJuego controladorEstadoJuego;
	
	/**
	 * Crea una nueva instancia de la vista de estado del juego.
	 * @param controladorEstadoJuego Controador de estado del juego.
	 */
	public VistaEstadoJuego(IControladorEstadoJuego controladorEstadoJuego) {
		super(controladorEstadoJuego);
		this.controladorEstadoJuego = controladorEstadoJuego;
		
	}
	
	@Override
	public float getWidth() {
		return Gdx.graphics.getWidth();
	}
	
	
	@Override
	public float getHeight() {
		return Gdx.graphics.getHeight();
	}
	
	/**
	 * Inicializa la vista del estado del juego.
	 */
	public void inicializar() {
		spriteBatch = new SpriteBatch();
		spriteBatch.setProjectionMatrix(SpaceInvadersGame.getCamara().combined);
	}
	
	/**
	 * Actualiza la vista del estado del juego.
	 */
	public abstract void actualizar(float deltaTiempo);
	
	/***
	 * Renderiza el estado del juego.
	 */
	public abstract void renderizar();
	
	
	/***
	 * Dispone de la vista del estado del juego.
	 */
	public abstract void dispose();

	/**
	 * Obtiene el sprite batch de la vista de estado del juego.
	 * @return Sprite batch.
	 */
	@Override
	public SpriteBatch getSpriteBatch() {
		return spriteBatch;
	}
	
}
