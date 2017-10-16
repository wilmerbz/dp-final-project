package com.space.invaders.actores.naves;

import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.space.invaders.actores.disparos.Disparo;
import com.space.invaders.actores.disparos.FachadaCreacionDisparo;

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
	
	/**
	 * Crea un nuevo disparo para la nave del jugador.
	 * @return Disparo creado.
	 */
	public Disparo disparar() {
		disparo = FachadaCreacionDisparo.getInstancia().construirDisparoJugador();
		float x = getX() + (getWidth()/2);
		float y = getY() + disparo.getHeight()+100;
		disparo.setX(x);
		disparo.setY(y);
		return disparo;
	}
	
	
	@Override
	public void renderizar(SpriteBatch batch) {
		super.renderizar(batch);
		
		if(disparo!=null) {
			disparo.renderizar(batch);
		}
		
	}
}
