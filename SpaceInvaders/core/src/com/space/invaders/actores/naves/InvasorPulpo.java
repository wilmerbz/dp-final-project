package com.space.invaders.actores.naves;

import java.util.List;

import com.badlogic.gdx.graphics.Texture;

/**
 * Invasor Pulpo.
 */
public class InvasorPulpo extends NaveEnemiga {

	/**
	 * Crea una nueva instancia de NaveEnemiga.
	 * @param texturas Texturas utilizadas para la animación.
	 * @param intervaloAnimacion Intervalo de cambio de texturas para la animación.
	 */
	public InvasorPulpo(List<Texture> texturas, float intervaloAnimacion) {
		super(texturas, intervaloAnimacion);
		this.puntos = 300;
	}

}
