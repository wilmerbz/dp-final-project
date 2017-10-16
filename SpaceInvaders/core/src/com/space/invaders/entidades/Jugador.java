package com.space.invaders.entidades;

import java.util.List;

public class Jugador {
	private String nombre;
	private String nickname;
	List<Partida> partidas;
	
	
	public Jugador(String nombre, String nickname) {
		super();
		this.setNombre(nombre);
		this.setNickname(nickname);
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
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public List<Partida> getPartidas () {
		return partidas;
		
	}

}