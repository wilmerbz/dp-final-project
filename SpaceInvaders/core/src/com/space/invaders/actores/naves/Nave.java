package com.space.invaders.actores.naves;

import com.badlogic.gdx.graphics.Texture;
import com.space.invaders.actores.ElementoJuego;

/**
 * Clase base para las naves.
 */
public abstract class Nave extends ElementoJuego {

	/**
	 * Crea una nueva instancia de Nave.
	 */
	public Nave(Texture texture) {
		super(texture);

	}
	
}
