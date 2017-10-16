package com.space.invaders.actores.naves;

import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.space.invaders.actores.ElementoAnimadoJuego;
import com.space.invaders.actores.disparos.Disparo;

/**
 * Clase base para las naves.
 */
public abstract class Nave extends ElementoAnimadoJuego {

	/**
	 * Disparo actual de la nave.
	 */
	protected Disparo disparo;
	
	/**
	 * Crea una nueva instancia de Nave.
	 * @param intervaloAnimacion Intervalo de cambio de texturas para la animación.
	 */
	public Nave(float intervaloAnimacion) {
		super(intervaloAnimacion);
	}
	
	/**
	 * Crea una nueva instancia de Nave.
	 * @param texturas Texturas utilizadas para la animación.
	 * @param intervaloAnimacion Intervalo de cambio de texturas para la animación.
	 */
	public Nave(List<Texture> texturas, float intervaloAnimacion) {
		super(texturas, intervaloAnimacion);
	}
	
	/**
	 * Valida si el disparo dado impactó la nave.
	 * @param disparo Disparo a validar.
	 * @return Retorna true si el disparo impactó la nave; de lo contrario retorna false.
	 */
	public boolean validarImpacto(Disparo disparo) {
		return false;
	}


	/**
	 * Crea un nuevo disparo para la nave.
	 * @return Disparo creado.
	 */
	public abstract Disparo disparar();
	
	
	@Override
	public void actualizar(float deltaTiempo) {
		super.actualizar(deltaTiempo);
		
		if(disparo!=null) {
			disparo.actualizar(deltaTiempo);
		}
	}
	
	@Override
	public void renderizar(SpriteBatch batch) {
		super.renderizar(batch);
		
		if(disparo!=null) {
			disparo.renderizar(batch);
		}
	}
	
	
}
