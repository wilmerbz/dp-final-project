package com.space.invaders.actores.naves;

import java.util.List;

import com.badlogic.gdx.graphics.Texture;

/**
 * Invasor Cangrejo.
 */
public class InvasorCangrejo extends NaveEnemiga {

	/**
	 * Crea una nueva instancia de NaveEnemiga.
	 * @param texturas Texturas utilizadas para la animación.
	 * @param intervaloAnimacion Intervalo de cambio de texturas para la animación.
	 */
	public InvasorCangrejo(List<Texture> texturas, float intervaloAnimacion) {
		super(texturas, intervaloAnimacion);
		this.puntos = 100;
	}

}
