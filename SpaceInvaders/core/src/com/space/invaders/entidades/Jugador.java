package com.space.invaders.entidades;

public class Jugador {
	private String nombre;
	private String nickname;
	
	public Jugador(String nombre, String nickname) {
		super();
		this.nombre = nombre;
		this.nickname = nickname;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
