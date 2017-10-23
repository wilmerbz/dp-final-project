package com.space.invaders.actores.naves.comandos;

import com.space.invaders.actores.naves.Nave;

/**
 * Comando de nave concreto, para disparar.
 */
public class ComandoNaveDisparar implements IComandoNave{

	private Nave nave;
	
	/**
	 * Crea una nueva instancia de ComandoNaveDisparar, para la nave indicada.
	 * @param nave
	 */
	public ComandoNaveDisparar(Nave nave) {
		this.nave = nave;
	}
	
	@Override
	public void setNave(Nave nave) {
		this.nave = nave;
	}

	@Override
	public void ejecutar() {
		nave.disparar();
	}

}
