package com.space.invaders.modelos;

import java.util.ArrayList;
import java.util.List;

import com.space.invaders.entidades.Nivel;

/**
 * Modelo para los niveles del juego.
 */
public class ModeloNivel {

	/**
	 * Niveles del juego.
	 */
	private List<Nivel> niveles;
	
	
	/**
	 * Nivel actual.
	 */
	private Nivel nivelActual;
	
	
	/**
	 * Ctea una nueva instancia del modelo de nivel.
	 */
	public 	ModeloNivel() {
		cargarNiveles();
	}

	/**
	 * Carga los niveles configurados en el juego.
	 */
	private void cargarNiveles() {
		
		niveles = new ArrayList<Nivel>();
		Nivel nivel1 = new Nivel();
		nivel1.setNombre("Lets kill some aliens!  ;)");
		nivel1.setNumero(1);
		nivel1.setVelocidadEnemigos(1f);
		nivel1.setVelocidadDisparos(3);
		nivel1.getConfiguracionEnemigos().put(0, 15);
		nivel1.getConfiguracionEnemigos().put(1, 15);
		nivel1.getConfiguracionEnemigos().put(2, 15);
		nivel1.setCantidadEnemigosPorFila(15);
		nivel1.setFrecuenciaDisparosEnemigos(1);
		
		niveles.add(nivel1);
		
		Nivel nivel2 = new Nivel();
		nivel2.setNombre("It's getting complicated!  :o");
		nivel2.setNumero(2);
		nivel2.setVelocidadEnemigos(2f);
		nivel2.setVelocidadDisparos(6);
		nivel2.getConfiguracionEnemigos().put(0, 20);
		nivel2.getConfiguracionEnemigos().put(1, 40);
		nivel2.getConfiguracionEnemigos().put(2, 20);
		nivel2.setCantidadEnemigosPorFila(20);
		nivel2.setFrecuenciaDisparosEnemigos(0.75f);
		
		niveles.add(nivel2);
		
		Nivel nivel3 = new Nivel();
		nivel3.setNombre("This is the end!  X(");
		nivel3.setNumero(3);
		nivel3.setVelocidadEnemigos(3f);
		nivel3.setVelocidadDisparos(9);
		nivel3.getConfiguracionEnemigos().put(0, 40);
		nivel3.getConfiguracionEnemigos().put(1, 40);
		nivel3.getConfiguracionEnemigos().put(2, 40);
		nivel3.setCantidadEnemigosPorFila(20);
		nivel3.setFrecuenciaDisparosEnemigos(0.5f);
		
		niveles.add(nivel3);
	}

	/**
	 * Obtiene los niveles del juego.
	 * @return Niveles.
	 */
	public List<Nivel> getNiveles() {
		return niveles;
	}
	
	/**
	 * Asigna la lista de niveles del juego.
	 * @param niveles Niveles.
	 */
	public void setNiveles(List<Nivel> niveles) {
		this.niveles = niveles;
	}
	
	/**
	 * Obtiene el nivel en el indice dado.
	 * @param numeroNivel Indice nivel.
	 * @return Nivel.
	 */
	public Nivel getNivel(int indiceNivel) {
		return this.niveles.get(indiceNivel);
	}
}
