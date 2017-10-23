package com.space.invaders.actores.naves.comandos;

import com.space.invaders.actores.naves.Nave;

/**
 * Interface para los comandos del jugador.
 */
public interface IComandoNave {

	/**
	 * Asigna la nave del jugador sobre la que se ejecuta del comando.
	 * @param naveJugador Nave del jugador.
	 */
	void setNave(Nave nave);
	
	/**
	 * Ejecuta el comando del jugador.
	 */
	void ejecutar();
	
}
