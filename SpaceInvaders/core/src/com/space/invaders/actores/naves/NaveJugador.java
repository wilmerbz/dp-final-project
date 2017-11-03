package com.space.invaders.actores.naves;

import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.space.invaders.actores.disparos.Disparo;
import com.space.invaders.actores.disparos.FachadaCreacionDisparo;
import com.space.invaders.recursos.sonido.AdministradorSonidos;
import com.space.invaders.recursos.sonido.NombreSonido;

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
		if(disparo!=null && !disparo.isImpactado()) {
			AdministradorSonidos.getInstancia().reproducirSonido(NombreSonido.NO_DISPARO_JUGADOR);
			return null;
		}
		
		disparo = FachadaCreacionDisparo.getInstancia().construirDisparoJugador();
		setUbicacionInicialDisparo(disparo);
		AdministradorSonidos.getInstancia().reproducirSonido(NombreSonido.DISPARO_JUGADOR);
		return disparo;
	}
	
	@Override
	public void impactada() {
		AdministradorSonidos.getInstancia().reproducirSonido(NombreSonido.IMPACTO_NAVE_JUGADOR);
	}
	
}
