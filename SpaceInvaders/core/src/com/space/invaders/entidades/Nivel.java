package com.space.invaders.entidades;

import java.util.Hashtable;

public class Nivel {
	private String nombre;
	private int numero;
	private float velocidadEnemigos;
	private float velocidadDisparos;
	
	Hashtable<Integer, Integer> configuracionEnemigos =new Hashtable<Integer, Integer>();

	/**
	 * @return the configuracionEnemigos
	 */
	public Hashtable<Integer, Integer> getConfiguracionEnemigos() {
		return configuracionEnemigos;
	}

	/**
	 * Obtiene el nombre del nivel.
	 * @return Nombre del nivel.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Obtiene el numero del nivel.
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * Obtiene la velocidad de disparos.
	 * @return Velocidad de disparos.
	 */
	public float getVelocidadDisparos() {
		return velocidadDisparos;
	}

	/**
	 * Obtiene la velocidad de los enemigos.
	 * @return Velocidad enemigos.
	 */
	public float getVelocidadEnemigos() {
		return velocidadEnemigos;
	}

	/**
	 * Obtiene la configuracion de enemigos.
	 * @param configuracionEnemigos Configuracion enemigos.
	 */
	public void setConfiguracionEnemigos(Hashtable<Integer, Integer> configuracionEnemigos) {
		this.configuracionEnemigos = configuracionEnemigos;
	}

	/**
	 * Asigna el nombre del nivel.
	 * @param nombre Nombre del nivel.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Asigna el numero del nivel.
	 * @param numero Numero del nivel.
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * Asigna la velocidad de los disparos.
	 * @param velocidadDisparos Velocidad de disparos.
	 */
	public void setVelocidadDisparos(float velocidadDisparos) {
		this.velocidadDisparos = velocidadDisparos;
	}

	/**
	 * Asigna la velocidad de los enemigos.
	 * @param velocidadEnemigos Velocidad de enemigos.
	 */
	public void setVelocidadEnemigos(float velocidadEnemigos) {
		this.velocidadEnemigos = velocidadEnemigos;
	}
}
