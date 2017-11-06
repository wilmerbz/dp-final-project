package com.space.invaders.modelos;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import com.space.invaders.actores.ElementoImagen;
import com.space.invaders.actores.disparos.Disparo;
import com.space.invaders.actores.iterator.IteradorGenerico;
import com.space.invaders.actores.iterator.IteradorListaGenerica;
import com.space.invaders.actores.naves.Nave;
import com.space.invaders.actores.naves.NaveEnemiga;
import com.space.invaders.actores.naves.NaveJugador;
import com.space.invaders.actores.naves.TipoNave;
import com.space.invaders.actores.naves.decorador.DecoradorNaveEnemigaEscudo;
import com.space.invaders.actores.naves.factory.INaveFactory;
import com.space.invaders.actores.naves.factory.NaveFactory;
import com.space.invaders.entidades.Juego;
import com.space.invaders.entidades.Jugador;
import com.space.invaders.entidades.Nivel;
import com.space.invaders.entidades.Partida;

/**
 * Modelo para la partida de juego.
 */
public class ModeloPartidaJuego {
	
	private Juego juego;
	
	/**
	 * Crea una nueva instancia del modelo de partida de juego.
	 */
	public ModeloPartidaJuego() {
		juego = new Juego();
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
	
	
	/**
	 * Asigna el nivel actual al juego.
	 * @param nivel nNivel actual.
	 */
	public void setNivel(Nivel nivel) {
		juego.setNivel(nivel);
	}
	
	/**
	 * Inicializa los elementos del juego actual.
	 */
	public void inicializarPartidaJuego() {
		inicializarNavesEnemigas();
		inicializarNaveJugador();
	}
	
	private void inicializarNaveJugador() {
		/**
		 * Creación de la nave del jugador usando el patron Factory
		 */
		INaveFactory naveFactory = new NaveFactory();
		Nave naveJugador = naveFactory.crearNave(TipoNave.Jugador);
		naveJugador.setVelocidadX(5);
		juego.setNaveJugador((NaveJugador)naveJugador);
	}

	/**
	 * Inicializa las naves enemigas.
	 */
	private void inicializarNavesEnemigas() {
		
		Nivel nivel = juego.getNivel();
		List<NaveEnemiga> navesEnemigas = juego.getNavesEnemigas();
		if(navesEnemigas.size()>0) {
			navesEnemigas.clear();
		}
		
		Hashtable<Integer, Integer> configuracionEnemigos = nivel.getConfiguracionEnemigos();
		
		INaveFactory naveFactory = new NaveFactory();
		TipoNave[] valoresTipoNave = TipoNave.values();
		Enumeration<Integer> enumeradorClavesConfiguracionEnemigos = configuracionEnemigos.keys();
		Integer tipoNave;
		
		Random random = new Random();
		
//		List<Integer> indicesEscudo = new ArrayList<Integer>();
//		int numeroNavesEscudo = 10;
//		for (int i = 0; i < numeroNavesEscudo; i++) {
//			indicesEscudo.add(random.nextInt(navesEnemigas.size()));
//		}
		
		
		while(enumeradorClavesConfiguracionEnemigos.hasMoreElements()) {
			tipoNave = enumeradorClavesConfiguracionEnemigos.nextElement();
			Integer contadorEnemigos = configuracionEnemigos.get(tipoNave);
			List<Nave> navesEnemigasTipo = naveFactory.crearNaves(valoresTipoNave[tipoNave], contadorEnemigos.intValue());
			
			for (int indiceNave = 0; indiceNave < navesEnemigasTipo.size(); indiceNave++) {
				NaveEnemiga naveEnemiga = (NaveEnemiga)navesEnemigasTipo.get(indiceNave);
				naveEnemiga.setVelocidadX(nivel.getVelocidadEnemigos());
				naveEnemiga.setVelocidadY(nivel.getVelocidadEnemigos());
				naveEnemiga.setVelocidadDisparo(nivel.getVelocidadDisparos());
				
				int aleatorio = random.nextInt(20);
				
				if(aleatorio%5 == 0) {
					naveEnemiga = new DecoradorNaveEnemigaEscudo(naveEnemiga);
					//naveEnemiga = new DecoradorNaveEnemigaEscudo(naveEnemiga);
				}
				
				juego.agregaNaveEnemiga(naveEnemiga);
			}
		}
		
	}
	
	/**
	 * Obtiene las naves enemigas del juego actual.
	 * @return Naves enemigas.
	 */
	public List<NaveEnemiga> getNavesEnemigas(){
		return juego.getNavesEnemigas();
	}
	
	
	/**
	 * Obtiene los elementos del juego actual.
	 * @return Naves enemigas.
	 */
	public List<ElementoImagen> getElementosJuego(){
		return juego.getElementosJuego();
	}
	
	/**
	 * Obtiene la navel del jugador.
	 * @return Nave del jugador.
	 */
	public NaveJugador getNaveJugador() {
		return juego.getNaveJugador();
	}

	/**
	 * Obtiene los puntos de la partida actual.
	 * @return 
	 */
	public long getPuntos() {
		Partida partida = juego.getPartida();
		long puntos = partida.getPuntos();
		return puntos;
	}
	
	/**
	 * Obtiene las vidas disponibles en la partida actual.
	 * @return Vidas disponibles.
	 */
	public int getVidas() {
		Partida partida = juego.getPartida();
		int vidas = partida.getVidas();
		return vidas;
	}
	
	/**
	 * Agrega los puntos a la cuenta de puntos de la partida.
	 * @param puntos Puntos a agregar.
	 */
	public void agregarPuntos(long puntos)
	{
		Partida partida = juego.getPartida();
		long totalPuntos = partida.getPuntos() + puntos;
		partida.setPuntos(totalPuntos);
	}

	/**
	 * Quita una vida disponible en la partida de juego actual.
	 */
	public void quitarVida() {
		Partida partida = juego.getPartida();
		int vidas = partida.getVidas();
		if(vidas == 0) {
			return;
		}
		
		vidas--;
		
		partida.setVidas(vidas);
	}

	/**
	 * Remueve la nave enemiga.
	 * @param naveEnemiga Nave a remover.
	 */
	public void removerNaveEnemiga(NaveEnemiga naveEnemiga) {
		juego.removerNaveEnemiga(naveEnemiga);
	}
	
	/**
	 * Genera un disparo enemigo, seleccionando una de las naves de manera aleatoria.
	 */
	public void generarDisparoEnemigo() {
		List<NaveEnemiga> navesEnemigas = getNavesEnemigas();
		Random random = new Random();
		if(navesEnemigas.size() == 0){
			return;
		}
		int indiceNaveEnemigaDisparar = random.nextInt(navesEnemigas.size());
		NaveEnemiga disparar = navesEnemigas.get(indiceNaveEnemigaDisparar);
		if(disparar.isDestruida())
		{	
			return;
		}
		
		disparar.disparar();
	}
	
	/**
	 * Actualiza los actores de la partida de juego actual.
	 */
	public void actualizar(float deltaTiempo) {
		NaveJugador naveJugador = getNaveJugador();
		naveJugador.actualizar(deltaTiempo);

		Disparo disparo = naveJugador.getDisparo();

		List<NaveEnemiga> navesEnemigas = getNavesEnemigas();
		IteradorGenerico<NaveEnemiga> iteradorNavesEnemigas = new IteradorListaGenerica<NaveEnemiga>(navesEnemigas);
		while (iteradorNavesEnemigas.hasNext()) {

			NaveEnemiga naveEnemiga = iteradorNavesEnemigas.next();
			naveEnemiga.actualizar(deltaTiempo);

			if (disparo != null && !disparo.isImpactado() && !naveEnemiga.isDestruida()) {

				boolean naveImpactada = naveEnemiga.validarImpacto(disparo);

				if (naveImpactada) {
					removerNaveEnemiga(naveEnemiga);
					agregarPuntos(naveEnemiga.getPuntos());
				}
			}
			
			Disparo disparoEnemigo = naveEnemiga.getDisparo();
			if(disparoEnemigo!= null && !disparoEnemigo.isImpactado()) {
				boolean jugadorImpactado = naveJugador.validarImpacto(disparoEnemigo);
				if(jugadorImpactado) {
					quitarVida();
				}
			}
		}
	}
	
}
