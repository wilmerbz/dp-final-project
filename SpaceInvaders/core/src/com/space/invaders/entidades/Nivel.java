package com.space.invaders.entidades;

import java.util.Hashtable;

public class Nivel {
	
	private String nombre;
	private int numero;
	private float velocidadEnemigos;
	private float velocidadJugador;
	private float velocidadDisparosEnemigos;

	private float velocidadDisparosJugador;

	private int cantidadEnemigosPorFila;
	private float frecuenciaDisparosEnemigos;
	Hashtable<Integer, Integer> configuracionEnemigos;
	/**
	 * Crea una nueva instancia de nivel.
	 */
	public Nivel() {
		configuracionEnemigos =new Hashtable<Integer, Integer>();
	}
	/**
	 * Obtiene la cantidad de enemigos por fila.
	 * @return Cantidad de enemigos por fila.
	 */
	public int getCantidadEnemigosPorFila() {
		return cantidadEnemigosPorFila;
	}

	/**
	 * @return the configuracionEnemigos
	 */
	public Hashtable<Integer, Integer> getConfiguracionEnemigos() {
		return configuracionEnemigos;
	}

	/**
	 * Obtiene la frecuencia de generacion de disparos enemigos.
	 * @return Frecuencia de generacion de disparos enemigos.
	 */
	public float getFrecuenciaDisparosEnemigos() {
		return frecuenciaDisparosEnemigos;
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
	public float getVelocidadDisparosEnemigos() {
		return velocidadDisparosEnemigos;
	}

	/**
	 * Obtiene la velocidad de disparos del jugador.
	 * @return Velocidad de disparos del jugador.
	 */
	public float getVelocidadDisparosJugador() {
		return velocidadDisparosJugador;
	}

	/**
	 * Obtiene la velocidad de los enemigos.
	 * @return Velocidad enemigos.
	 */
	public float getVelocidadEnemigos() {
		return velocidadEnemigos;
	}
	
	/**
	 * Obtiene la velocidad del jugador.
	 * @return Velocidad del jugador. 
	 */
	public float getVelocidadJugador() {
		return velocidadJugador;
	}

	/**
	 * Asigna la cantidad de enemigos por fila.
	 * @param cantidadEnemigosPorFila Cantidad de enemigos por fila.
	 */
	public void setCantidadEnemigosPorFila(int cantidadEnemigosPorFila) {
		this.cantidadEnemigosPorFila = cantidadEnemigosPorFila;
	}

	/**
	 * Obtiene la configuracion de enemigos.
	 * @param configuracionEnemigos Configuracion enemigos.
	 */
	public void setConfiguracionEnemigos(Hashtable<Integer, Integer> configuracionEnemigos) {
		this.configuracionEnemigos = configuracionEnemigos;
	}

	/**
	 * Asigna la frecuencia de generacion de disparos enemigos.
	 * @param frecuenciaDisparosEnemigos Frecuencia de generacion de disparos enemigos.
	 */
	public void setFrecuenciaDisparosEnemigos(float frecuenciaDisparosEnemigos) {
		this.frecuenciaDisparosEnemigos = frecuenciaDisparosEnemigos;
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
	public void setVelocidadDisparosEnemigos(float velocidadDisparos) {
		this.velocidadDisparosEnemigos = velocidadDisparos;
	}
	
	
	/**
	 * Asigna la velocidad de los disparos del jugador.
	 * @param velocidadDisparosJugador Velocidad de disparos.
	 */
	public void setVelocidadDisparosJugador(float velocidadDisparosJugador) {
		this.velocidadDisparosJugador = velocidadDisparosJugador;
	}

	/**
	 * Asigna la velocidad de los enemigos.
	 * @param velocidadEnemigos Velocidad de enemigos.
	 */
	public void setVelocidadEnemigos(float velocidadEnemigos) {
		this.velocidadEnemigos = velocidadEnemigos;
	}
	
	/**
	 * Asigna la velocidad del jugador.
	 * @param velocidadJugador Velocidad del jugador.
	 */
	public void setVelocidadJugador(float velocidadJugador) {
		this.velocidadJugador = velocidadJugador;
	}
}
