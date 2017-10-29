package com.space.invaders.entidades;

/**
 * Información de un mejor puntaje.
 */
public class MejorPuntaje {
	private String nicknameJugador;
	private String nombrePartida;
	private long puntos;
	
	/**
	 * Obtiene el nickname del jugador.
	 * @return the nicknameJugador
	 */
	public String getNicknameJugador() {
		return nicknameJugador;
	}
	/**
	 * Obtiene el nombre de la partida.
	 * @return the nombrePartida
	 */
	public String getNombrePartida() {
		return nombrePartida;
	}
	/**
	 * Obtiene los puntos de la partida.
	 * @return Puntos de la partida.
	 */
	public long getPuntos() {
		return puntos;
	}
	/**
	 * Asigna el nickname del jugador.
	 * @param nicknameJugador the nicknameJugador to set
	 */
	public void setNicknameJugador(String nicknameJugador) {
		this.nicknameJugador = nicknameJugador;
	}
	/**
	 * Asigna el nombre de la partida.
	 * @param nombrePartida the nombrePartida to set
	 */
	public void setNombrePartida(String nombrePartida) {
		this.nombrePartida = nombrePartida;
	}
	/**
	 * Asigna los puntos de la partida.
	 * @param puntos Puntos de la partida.
	 */
	public void setPuntos(long puntos) {
		this.puntos = puntos;
	}
	
}
