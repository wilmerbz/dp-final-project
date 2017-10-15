package com.space.invaders.actores.naves;

import java.util.List;

import com.badlogic.gdx.graphics.Texture;

/**
 * Representa la nave del jugador.
 */
public class NaveJugador extends Nave {

	/**
	 * Crea una nueva instancia de NaveJugador.
	 * @param intervaloAnimacion Intervalo de cambio de texturas para la animación.
	 */
	public NaveJugador(float intervaloAnimacion) {
		super(intervaloAnimacion);
	}
	
	/**
	 * Crea una nueva instancia de NaveJugador.
	 * @param texturas Texturas utilizadas para la animación.
	 * @param intervaloAnimacion Intervalo de cambio de texturas para la animación.
	 */
	public NaveJugador(List<Texture> texturas, float intervaloAnimacion) {
		super(texturas, intervaloAnimacion);
	}

}
