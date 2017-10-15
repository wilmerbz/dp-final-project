package com.space.invaders.entidades;

public class Partida {
	private String nombre;
	private int puntos;
	
	public Partida(String nombre, int puntos) {
		super();
		this.setNombre(nombre);
		this.setPuntos(puntos);
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the puntos
	 */
	public int getPuntos() {
		return puntos;
	}

	/**
	 * @param puntos the puntos to set
	 */
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	public Puntaje getPuntaje ( Puntaje puntaje) {
		
		return puntaje;
	}



}
