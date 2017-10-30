package com.space.invaders.actores.naves.decorator;


import com.space.invaders.actores.naves.NaveEnemiga;

public class NaveEnemigaPuntosNivel2 extends NaveEnemigaNivel {

	public NaveEnemigaPuntosNivel2(NaveEnemiga naveEnemiga) {
		super(naveEnemiga);
	}

	public long puntos() {
		return 15 + naveEnemiga.puntos();
	}

}
