package com.space.invaders.actores.naves.decorador;

import com.space.invaders.actores.naves.NaveEnemiga;

/**
 * Decorador concreto para las naves en el nivel 3.
 */
public class DecoradorNaveEnemigaNivel3 extends DecoradorNaveEnemigaNivel {

	/**
	 * Crea una nueva instancia del decorador de nave enemiga.
	 * @param naveEnemiga Nave Enemiga a decorar.
	 */
	public DecoradorNaveEnemigaNivel3(NaveEnemiga naveEnemiga) {
		super(naveEnemiga);
	}

	@Override
	public long getPuntos() {
		long puntosNave = naveEnemiga.getPuntos();
		long puntosMultiplicados = puntosNave * 3;
		return puntosMultiplicados;
	}

}