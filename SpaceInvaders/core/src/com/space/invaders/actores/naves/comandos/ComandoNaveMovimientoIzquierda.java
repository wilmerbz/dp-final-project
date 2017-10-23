package com.space.invaders.actores.naves.comandos;

import com.space.invaders.actores.naves.Nave;

/**
 * Comando de nave concreto, para el movimiento a la izquierda.
 */
public class ComandoNaveMovimientoIzquierda implements IComandoNave{

	private Nave nave;
	
	/**
	 * Crea una nueva instancia de ComandoNaveMovimientoIzquierda, para la nave indicada.
	 * @param nave
	 */
	public ComandoNaveMovimientoIzquierda(Nave nave) {
		this.nave = nave;
	}
	
	@Override
	public void setNave(Nave nave) {
		this.nave = nave;
	}

	@Override
	public void ejecutar() {
		nave.moverIzquierda();
	}

}
