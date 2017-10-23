package com.space.invaders.actores.naves.comandos;

import com.space.invaders.actores.naves.Nave;

/**
 * Comando de nave concreto, para el movimiento a la derecha.
 */
public class ComandoNaveMovimientoDerecha implements IComandoNave{

	private Nave nave;
	
	/**
	 * Crea una nueva instancia de ComandoNaveMovimientoDerecha, para la nave indicada.
	 * @param nave
	 */
	public ComandoNaveMovimientoDerecha(Nave nave) {
		this.nave = nave;
	}
	
	@Override
	public void setNave(Nave nave) {
		this.nave = nave;
	}

	@Override
	public void ejecutar() {
		nave.moverDerecha();
	}

}
