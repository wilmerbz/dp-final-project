package com.space.invaders.actores.disparos;

import com.space.invaders.actores.disparos.builder.DirectorConstruccionDisparo;
import com.space.invaders.actores.disparos.builder.DisparoBuilder;
import com.space.invaders.actores.disparos.builder.DisparoEnemigoBuilder;
import com.space.invaders.actores.disparos.builder.DisparoJugadorBuilder;

/**
 * Fachada que simplica el proceso de construcción del disparos por medio del builder.
 */
public class FachadaCreacionDisparo{

	private static FachadaCreacionDisparo instancia;
	
	private FachadaCreacionDisparo() {
	}
	
	/**
	 * Obtiene la instancia singleton de la fachada de creación de disparos.
	 * @return
	 */
	public static synchronized FachadaCreacionDisparo getInstancia() {
		if(instancia == null) {
			instancia = new FachadaCreacionDisparo();
		}
		
		return instancia;
	}
	
	/**
	 * Construye un disparo enemigo.
	 * @return Disparo construido.
	 */
	public Disparo construirDisparoEnemigo() {
		DisparoBuilder disparoEnemigoBuilder = new DisparoEnemigoBuilder();
		return construirDisparo(disparoEnemigoBuilder);
	}
	
	/**
	 * Construye un disparo del jugador.
	 * @return Disparo construido.
	 */
	public Disparo construirDisparoJugador() {
		DisparoBuilder disparoJugadorBuilder = new DisparoJugadorBuilder();
		return construirDisparo(disparoJugadorBuilder);
	}
	
	/**
	 * Construye un disparo utilizando el Builder dado pr paramétro.
	 * @param builder Builder concreto.
	 * @return Disparo construido con el builder.
	 */
	private Disparo construirDisparo(DisparoBuilder builder) {
		DirectorConstruccionDisparo director = new DirectorConstruccionDisparo();
		director.setDisparoBuilder(builder);
		director.construirDisparo();
		Disparo disparo = director.getDisparo();
		return disparo;
	}
}
