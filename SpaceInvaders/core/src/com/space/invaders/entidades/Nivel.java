package com.space.invaders.entidades;

import java.util.Hashtable;

public class Nivel {
	private String nombre;
	private int numero;
	private int velocidadEnemigos;
	private int velocidadDisparos;
	
	Hashtable<String,Integer> configuracionEnemigos =new Hashtable<String,Integer>();

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
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return the velocidadEnemigos
	 */
	public int getVelocidadEnemigos() {
		return velocidadEnemigos;
	}

	/**
	 * @param velocidadEnemigos the velocidadEnemigos to set
	 */
	public void setVelocidadEnemigos(int velocidadEnemigos) {
		this.velocidadEnemigos = velocidadEnemigos;
	}

	/**
	 * @return the velocidadDisparos
	 */
	public int getVelocidadDisparos() {
		return velocidadDisparos;
	}

	/**
	 * @param velocidadDisparos the velocidadDisparos to set
	 */
	public void setVelocidadDisparos(int velocidadDisparos) {
		this.velocidadDisparos = velocidadDisparos;
	}
}
