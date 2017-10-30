package com.space.invaders.actores.naves.decorador;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.space.invaders.actores.Actor;
import com.space.invaders.actores.direccion.DireccionX;
import com.space.invaders.actores.direccion.DireccionY;
import com.space.invaders.actores.naves.NaveEnemiga;

/**
 * Clase base para los decoradores de NavesEnemigas de acuerdo al nivel.
 */
public abstract class DecoradorNaveEnemigaNivel extends DecoradorNaveEnemiga{
	
	/**
	 * Crea una nueva instancia del decorador de nave enemiga nivel.
	 * @param naveEnemiga
	 */
	public DecoradorNaveEnemigaNivel(NaveEnemiga naveEnemiga) {
		super(naveEnemiga);
	}
	
	@Override
	public abstract long getPuntos();

}
