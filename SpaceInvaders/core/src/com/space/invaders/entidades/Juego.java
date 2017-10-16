package com.space.invaders.entidades;

import java.util.ArrayList;

import com.space.invaders.actores.ElementoJuego;
import com.space.invaders.actores.naves.NaveEnemiga;
import com.space.invaders.actores.naves.NaveJugador;

public class Juego {
	private Jugador jugador;
	private Partida partida;
	private Nivel nivel;
	private NaveJugador naveJugador;
	private ArrayList<NaveEnemiga> navesEnemigas;
	private ArrayList<ElementoJuego> elementoJuego;

	/**
	 * @return the jugador
	 */
	public Jugador getJugador() {
		return jugador;
	}

	/**
	 * @param jugador
	 *            the jugador to set
	 */
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	/**
	 * @return the partida
	 */
	public Partida getPartida() {
		return partida;
	}

	/**
	 * @param partida
	 *            the partida to set
	 */
	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	/**
	 * @return the nivel
	 */
	public Nivel getNivel() {
		return nivel;
	}

	/**
	 * @param nivel
	 *            the nivel to set
	 */
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	/**
	 * @return the naveJugador
	 */
	public NaveJugador getNaveJugador() {
		return naveJugador;
	}

	/**
	 * @param naveJugador
	 *            the naveJugador to set
	 */
	public void setNaveJugador(NaveJugador naveJugador) {
		this.naveJugador = naveJugador;
	}

	/**
	 * @return the navesEnemigas
	 */
	public ArrayList<NaveEnemiga> getNavesEnemigas() {
		return navesEnemigas;
	}

	/**
	 * @param navesEnemigas
	 *            the navesEnemigas to set
	 */
	public void setNavesEnemigas(ArrayList<NaveEnemiga> navesEnemigas) {
		this.navesEnemigas = navesEnemigas;
	}

	/**
	 * @return the elementoJuego
	 */
	public ArrayList<ElementoJuego> getElementoJuego() {
		return elementoJuego;
	}

	/**
	 * @param elementoJuego
	 *            the elementoJuego to set
	 */
	public void setElementoJuego(ArrayList<ElementoJuego> elementoJuego) {
		this.elementoJuego = elementoJuego;
	}

}