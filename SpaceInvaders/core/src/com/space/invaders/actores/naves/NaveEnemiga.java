package com.space.invaders.actores.naves;

import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.space.invaders.actores.disparos.Disparo;
import com.space.invaders.actores.disparos.FachadaCreacionDisparo;

public abstract class NaveEnemiga extends Nave {

	/**
	 * Crea una nueva instancia de NaveEnemiga.
	 * @param intervaloAnimacion Intervalo de cambio de texturas para la animación.
	 */
	public NaveEnemiga(float intervaloAnimacion) {
		super(intervaloAnimacion);
	}
	
	/**
	 * Crea una nueva instancia de NaveEnemiga.
	 * @param texturas Texturas utilizadas para la animación.
	 * @param intervaloAnimacion Intervalo de cambio de texturas para la animación.
	 */
	public NaveEnemiga(List<Texture> texturas, float intervaloAnimacion) {
		super(texturas, intervaloAnimacion);
	}
	
	
	/**
	 * Crea un nuevo disparo para la nave enemiga.
	 * @return Disparo creado.
	 */
	public Disparo disparar() {
		disparo = FachadaCreacionDisparo.getInstancia().construirDisparoEnemigo();
		return disparo;
	}
	
	
	
}
