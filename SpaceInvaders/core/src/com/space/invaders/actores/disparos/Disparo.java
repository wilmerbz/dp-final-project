package com.space.invaders.actores.disparos;

import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.space.invaders.actores.ElementoAnimadoJuego;

/**
 * Representa un disparo.
 */
public class Disparo extends ElementoAnimadoJuego {

	private boolean impactado;
	
	/**
	 * Crea una nueva instancia de un Elemento Animado del Juego.
	 */
	public Disparo() {
		super();
	}


	@Override
	public void actualizar(float deltaTiempo) {
		if(impactado)
			return;
		
		super.actualizar(deltaTiempo);
		
		mover();
	}
	
	@Override
	public void renderizar(SpriteBatch batch) {
		if(impactado)
			return;
		
		super.renderizar(batch);
		
		mover();
	}
	
	/**
	 * Indica si el disparo fue impactado.
	 * @return Retorna true si el disparo fue impactado.
	 */
	public boolean isImpactado() {
		return impactado;
	}

	/**
	 * Asigna el indicador de impacto del disparo.
	 * @param 
	 */
	public void setImpactado(boolean impactado) {
		this.impactado = impactado;
	}
}
