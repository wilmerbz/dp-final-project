package com.space.invaders.modelos;

import java.util.ArrayList;
import java.util.List;
import com.space.invaders.entidades.Nivel;
import com.space.invaders.entidades.iterador.IteradorGenerico;
import com.space.invaders.entidades.iterador.IteradorListaGenerica;

/**
 * Modelo para los niveles del juego.
 */
public class ModeloNivel {

	/**
	 * Niveles del juego.
	 */
	private List<Nivel> niveles;
	
	
	private IteradorGenerico<Nivel> iteradorNiveles;
	
	/**
	 * Nivel actual.
	 */
	private Nivel nivelActual;
	
	
	/**
	 * Crea una nueva instancia del modelo de nivel.
	 */
	public 	ModeloNivel() {
		cargarNiveles();
		crearIteradorNiveles();
	}
	
	private void crearIteradorNiveles(){
		iteradorNiveles = new IteradorListaGenerica<Nivel>(niveles);
	}

	/**
	 * Carga los niveles configurados en el juego.
	 */
	private void cargarNiveles() {
		
		niveles = new ArrayList<Nivel>();
		Nivel nivel = new Nivel();
		nivel.setNombre("Lets kill some aliens!  ;)");
		nivel.setNumero(1);
		nivel.setVelocidadEnemigos(1f);
		nivel.setVelocidadJugador(5f);
		nivel.setVelocidadDisparosEnemigos(2.5f);
		nivel.setVelocidadDisparosJugador(5);
		nivel.getConfiguracionEnemigos().put(0, 10);
		nivel.getConfiguracionEnemigos().put(1, 10);
		nivel.getConfiguracionEnemigos().put(2, 10);
		nivel.setCantidadEnemigosPorFila(10);
		nivel.setFrecuenciaDisparosEnemigos(1);
		
		niveles.add(nivel);
		
		nivel = new Nivel();
		nivel.setNombre("It's getting complicated!  :o");
		nivel.setNumero(2);
		nivel.setVelocidadEnemigos(3);
		nivel.setVelocidadJugador(6);
		nivel.setVelocidadDisparosEnemigos(4);
		nivel.setVelocidadDisparosJugador(8);
		nivel.getConfiguracionEnemigos().put(0, 10);
		nivel.getConfiguracionEnemigos().put(1, 20);
		nivel.getConfiguracionEnemigos().put(2, 10);
		nivel.setCantidadEnemigosPorFila(10);
		nivel.setFrecuenciaDisparosEnemigos(0.75f);
		
		niveles.add(nivel);
		
		nivel = new Nivel();
		nivel.setNombre("This is the end!  X(");
		nivel.setNumero(3);
		nivel.setVelocidadEnemigos(5);
		nivel.setVelocidadJugador(7.5f);
		nivel.setVelocidadDisparosEnemigos(8);
		nivel.setVelocidadDisparosJugador(16);
		nivel.getConfiguracionEnemigos().put(0, 15);
		nivel.getConfiguracionEnemigos().put(1, 30);
		nivel.getConfiguracionEnemigos().put(2, 15);
		nivel.setCantidadEnemigosPorFila(15);
		nivel.setFrecuenciaDisparosEnemigos(0.5f);
		
		niveles.add(nivel);
		
		nivel = new Nivel();
		nivel.setNombre("Hardcore mode!");
		nivel.setNumero(4);
		nivel.setVelocidadEnemigos(7.5f);
		nivel.setVelocidadJugador(10f);
		nivel.setVelocidadDisparosEnemigos(10);
		nivel.setVelocidadDisparosJugador(20);
		nivel.getConfiguracionEnemigos().put(0, 20);
		nivel.getConfiguracionEnemigos().put(1, 40);
		nivel.getConfiguracionEnemigos().put(2, 20);
		nivel.setCantidadEnemigosPorFila(20);
		nivel.setFrecuenciaDisparosEnemigos(0.2f);
		
		niveles.add(nivel);
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
	
	/**
	 * Obtiene el siguiente nivel.
	 * @return Nivel
	 */
	public Nivel getSiguienteNivel() {
		nivelActual = iteradorNiveles.next();
		return nivelActual;
	}
	
	/**
	 * Obtiene el primer nivel.
	 * @return
	 */
	public Nivel getPrimerNivel() {
		crearIteradorNiveles();
		Nivel primerNivel = getSiguienteNivel();
		return primerNivel;
	}
	
	/**
	 * Obtiene el nivel actual.
	 * @return Nivel actual.
	 */
	public Nivel getNivelActual() {
		return nivelActual;
	}
	
	/**
	 * Valida si el nivel actual es el ultimo nivel.
	 * @return Retorna true si el nivel actual es el ultimo nivel; de lo contrario retorna false.
	 */
	public boolean esUltimoNivel() {
		boolean esUltimoNivel = !iteradorNiveles.hasNext();
		return esUltimoNivel;
	}
}
