package com.space.invaders.actores.disparos.builder;

import com.space.invaders.actores.disparos.Disparo;

/**
 * Builder de disparos.
 */
public abstract class DisparoBuilder {

	/**
	 * Disparo manejado por el builder actual.
	 */
	protected Disparo disparo;
	
	/**
	 * Crea una nueva instancia de disparo.
	 */
	public void crearDisparo() {
		disparo = new Disparo();
	}
	
	/**
	 * Construye la textura del disparo.
	 */
	public abstract void construirTextura();
	
	/**
	 * Construye la dirección del disparo.
	 */
	public abstract void construirDireccion();
	
	/**
	 * Construye la configuracion de animacion del disparo.
	 */
	public void construirConfiguracionAnimacion(float intervaloAnimacion) {
		disparo.setAnimar(true);
		disparo.setIntervaloAnimacion(intervaloAnimacion);
		disparo.setVelocidadY(5);
	}
	
	/**
	 * Obtiene el Disparo construido.
	 * @return
	 */
	public Disparo obtenerResultado() {
		return disparo;
	}
}
