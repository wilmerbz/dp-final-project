package com.space.invaders.actores.disparos.builder;

import com.space.invaders.actores.disparos.Disparo;

/**
 * Director del proceso de construcción de disparos.
 */
public class DirectorConstruccionDisparo {
	
	private DisparoBuilder builder;
	private final float intervaloAnimacionDisparo = 0.25f;
	
	/**
	 * Asigna el builder a utilizar en el proceso de construcción de disparos.
	 */
	public void setDisparoBuilder(DisparoBuilder builder) {
		this.builder = builder;
	}
	
	
	/**
	 * Construye el disparo paso a paso utilizando el builder.
	 */
	public void construirDisparo() {
		builder.crearDisparo();
		builder.construirTextura();
		builder.construirDireccion();
		builder.construirConfiguracionAnimacion(intervaloAnimacionDisparo);
	}
	
	/**
	 * Obtiene el disparo construido.
	 * @return Disparo construido.
	 */
	public Disparo getDisparo() {
		return builder.obtenerResultado();
	}
	
}
