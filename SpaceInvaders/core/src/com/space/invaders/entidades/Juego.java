package com.space.invaders.entidades;

import java.util.ArrayList;
import java.util.List;

import com.space.invaders.actores.ElementoImagen;
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
	private List<ElementoImagen> elementosJuego;

	public Juego() {
		partida = new Partida("Default");
		navesEnemigas = new ArrayList<NaveEnemiga>();
		elementosJuego = new ArrayList<ElementoImagen>();
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
		if(this.elementosJuego!=null && elementosJuego.contains(this.naveJugador)) {
			this.elementosJuego.remove(this.naveJugador);
		}
		this.naveJugador = naveJugador;
		this.elementosJuego.add(this.naveJugador);
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
	 * @param naveEnememiga Nave enemiga a agregar.
	 */
	public void agregaNaveEnemiga(NaveEnemiga naveEnememiga) {
		navesEnemigas.add(naveEnememiga);
		elementosJuego.add(naveEnememiga);
	}
	
	/**
	 * Remueve una nave enemiga.
	 * @param naveEnememiga Nave enemiga a remover.
	 */
	public void removerNaveEnemiga(NaveEnemiga naveEnemiga) {
		navesEnemigas.remove(naveEnemiga);
		elementosJuego.remove(naveEnemiga);
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
	public List<ElementoImagen> getElementosJuego() {
		return elementosJuego;
	}

	/**
	 * Asigna la lista de elementos del juego.
	 * @param elementosJuego Elementos del juego.
	 */
	public void setElementosJuego(List<ElementoImagen> elementosJuego) {
		this.elementosJuego = elementosJuego;
	}

}