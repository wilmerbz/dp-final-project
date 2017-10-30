package com.space.invaders.actores.naves.decorador;

import com.space.invaders.actores.naves.NaveEnemiga;

/**
 * Decorador concreto para las naves en el nivel 2.
 */
public class DecoradorNaveEnemigaNivel2 extends DecoradorNaveEnemigaNivel {

	/**
	 * Crea una nueva instancia del decorador de nave enemiga.
	 * @param naveEnemiga Nave Enemiga a decorar.
	 */
	public DecoradorNaveEnemigaNivel2(NaveEnemiga naveEnemiga) {
		super(naveEnemiga);
	}

	@Override
	public long getPuntos() {
		long puntosNave = naveEnemiga.getPuntos();
		long puntosMultiplicados = puntosNave * 2;
		return puntosMultiplicados;
	}

}