package com.space.invaders.modelos;

import java.util.ArrayList;
import java.util.List;

import com.space.invaders.entidades.Jugador;
import com.space.invaders.entidades.Partida;


public class ModeloJugador {
	private ArrayList<Jugador> jugadores;
	Jugador jugador;
	private List<Partida> partidas;

	/**
	 * @return the jugadores
	 */
	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	/**
	 * @param jugadores the jugadores to set
	 */
	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	
	public Jugador crearJugador(String nombre, String nickname ) {
	
		
		jugador.setNombre(nombre);
		jugador.setNickname(nickname);
		
		return jugador;		
	}
	
	public boolean guardarJugador (Jugador jugador) {
		
		return false;
}
	public List<Partida> getPartidasjugador () {
		
		return partidas;
		
	}
}