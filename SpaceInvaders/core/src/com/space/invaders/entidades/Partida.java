package com.space.invaders.entidades;

/**
 * Representa una partida de juego.
 */
public class Partida {
	
	private String nombre;
	private long puntos = 0;
	private int vidas = 10;

	/**
	 * Crea un nueva partida.
	 */
	public Partida() {
	}

	/**
	 * Crea un nueva partida con el nombre indicado.
	 * @param nombre Nombre de la partida.
	 */
	public Partida(String nombre) {
		this.nombre=nombre;
	}

	/**
	 * Obtiene el nombre de la partida
	 * @return Nombre de partida
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Asigna el nombre de la partida.
	 * @param nombre Nombre de la partida a asignar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene los puntos de la partida.
	 * @return Puntos de la partida.
	 */
	public long getPuntos() {
		return puntos;
	}

	/**
	 * Asigna los puntos de la partida.
	 * @param puntos Puntos de la partida.
	 */
	public void setPuntos(long puntos) {
		this.puntos = puntos;
	}
	
	/**
	 * Obtiene una instancia de Puntaje que representa los puntos de la partida.
	 * @return
	 */
	public MejorPuntaje getMejorPuntaje () {
		MejorPuntaje mejorPuntaje = new MejorPuntaje();
		mejorPuntaje.setPuntos(puntos);
		return mejorPuntaje;
	}

	/**
	 * Obtiene las vidas disponibles en la partida.
	 * @return Vidas disponibles.
	 */
	public int getVidas() {
		return vidas;
	}

	/**
	 * Asigna la cantidad de vidas disponibles en la partida.
	 * @param vidas Vidas.
	 */
	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

}
