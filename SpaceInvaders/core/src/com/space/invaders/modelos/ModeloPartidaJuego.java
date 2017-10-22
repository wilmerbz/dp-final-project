package com.space.invaders.modelos;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import com.space.invaders.actores.naves.INaveFactory;
import com.space.invaders.actores.naves.Nave;
import com.space.invaders.actores.naves.NaveEnemiga;
import com.space.invaders.actores.naves.NaveFactory;
import com.space.invaders.actores.naves.TipoNave;
import com.space.invaders.entidades.Juego;
import com.space.invaders.entidades.Nivel;

/**
 * Modelo para la partida de juego.
 */
public class ModeloPartidaJuego {
	
	private Juego juego;
	
	public ModeloPartidaJuego() {
		
	}

	/**
	 * Obtiene el juego actual.
	 * @return Juego actual.
	 */
	public Juego getJuego() {
		return juego;
	}

	/**
	 * Asigna el juego actual.
	 * @param juego Juego actual.
	 */
	public void setJuego(Juego juego) {
		this.juego = juego;
	}
	
	
	public void setNivel(Nivel nivel) {
		juego.setNivel(nivel);
	}
	
	/**
	 * Inicializa los elementos del juego actual.
	 */
	public void inicializarPartidaJuego() {
		
		inicializarNavesEnemigas();
		
	}
	
	/**
	 * Inicializa las naves enemigas.
	 */
	private void inicializarNavesEnemigas() {
		
		Nivel nivel = juego.getNivel();
		Hashtable<Integer, Integer> configuracionEnemigos = nivel.getConfiguracionEnemigos();
		
		List<NaveEnemiga> navesEnemigas = new ArrayList<NaveEnemiga>();
		INaveFactory naveFactory = new NaveFactory();
		TipoNave[] valoresTipoNave = TipoNave.values();
		Enumeration<Integer> enumeration = configuracionEnemigos.keys();
		Integer tipoNave;
		while(enumeration.hasMoreElements()) {
			tipoNave = enumeration.nextElement();
			Integer contadorEnemigos = configuracionEnemigos.get(tipoNave);
			List<Nave> navesEnemigasTipo = naveFactory.crearNaves(valoresTipoNave[tipoNave], contadorEnemigos.intValue());
			
			for (int indiceNave = 0; indiceNave < navesEnemigasTipo.size(); indiceNave++) {
				NaveEnemiga naveEnemiga = (NaveEnemiga)navesEnemigasTipo.get(indiceNave);
				naveEnemiga.setVelocidadX(nivel.getVelocidadEnemigos());
				naveEnemiga.setVelocidadDisparo(nivel.getVelocidadDisparos());
				navesEnemigas.add(naveEnemiga);
			}
		}
		
		
		juego.setNavesEnemigas(navesEnemigas);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
