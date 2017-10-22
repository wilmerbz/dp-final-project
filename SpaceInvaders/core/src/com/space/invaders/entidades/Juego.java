package com.space.invaders.entidades;

import java.util.ArrayList;
import java.util.List;

import com.space.invaders.actores.ElementoJuego;
import com.space.invaders.actores.naves.NaveEnemiga;
import com.space.invaders.actores.naves.NaveJugador;

/**
 * Agrupa los elementos requeridos para la sesión de juego.
 */
public class Juego {

	private Jugador jugador;
	private Partida partida;
	private Nivel nivel;
	private NaveJugador naveJugador;
	private List<NaveEnemiga> navesEnemigas;
	private List<ElementoJuego> elementosJuego;

	public Juego() {
		navesEnemigas = new ArrayList<NaveEnemiga>();
		elementosJuego = new ArrayList<ElementoJuego>();
	}
	
	/**
	 * Obtiene el jugador actual.
	 * @return Jugador actual.
	 */
	public Jugador getJugador() {
		return jugador;
	}

	/**
	 * Asigna el jugador actual.
	 * @param jugador Jugador a asignar.
	 */
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	/**
	 * Obtiene la partida actual.
	 * @return Partiada actual.
	 */
	public Partida getPartida() {
		return partida;
	}

	/**
	 * Asigna la partida actual.
	 * @param partida Partida actual.
	 */
	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	/**
	 * OBtiene el nivel actual.
	 * @return Nivel actual.
	 */
	public Nivel getNivel() {
		return nivel;
	}

	/**
	 * Asigna el nivel actual.
	 * @param nivel Nivel.
	 */
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	/**
	 * Obtiene la nave del jugador.
	 * @return Nave del jugador.
	 */
	public NaveJugador getNaveJugador() {
		return naveJugador;
	}

	/**
	 * Asigna la nave del jugador.
	 * @param naveJugador Nave del jugador.
	 */
	public void setNaveJugador(NaveJugador naveJugador) {
		this.naveJugador = naveJugador;
	}

	/**
	 * Obtiene la lista naves enemigas.
	 * @return Naves enemigas.
	 */
	public List<NaveEnemiga> getNavesEnemigas() {
		return navesEnemigas;
	}
	
	/**
	 * Agrega una nave enemiga.
	 * @param Nave enemiga a agregar.
	 */
	public void agregaNaveEnemiga(NaveEnemiga naveEnememiga) {
		navesEnemigas.add(naveEnememiga);
		elementosJuego.add(naveEnememiga);
	}

	/**
	 * Asigna la lista de naves enemigas.
	 * @param navesEnemigas Naves enemigas.
	 */
	public void setNavesEnemigas(List<NaveEnemiga> navesEnemigas) {
		this.navesEnemigas = navesEnemigas;
	}

	/**
	 * Obtiene la lista de elementos del juego.
	 * @return Lista de elementos del juego.
	 */
	public List<ElementoJuego> getElementosJuego() {
		return elementosJuego;
	}

	/**
	 * Asigna la lista de elementos del juego.
	 * @param elementosJuego Elementos del juego.
	 */
	public void setElementosJuego(List<ElementoJuego> elementosJuego) {
		this.elementosJuego = elementosJuego;
	}

}