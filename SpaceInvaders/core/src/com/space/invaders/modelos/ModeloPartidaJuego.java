package com.space.invaders.modelos;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import com.space.invaders.actores.ElementoImagen;
import com.space.invaders.actores.disparos.Disparo;
import com.space.invaders.entidades.iterador.IteradorGenerico;
import com.space.invaders.entidades.iterador.IteradorListaGenerica;
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

	
	private static ModeloPartidaJuego instancia;
	
	private final long PUNTOS_INICIALES = 0;
	private final int VIDAS_INICIALES = 10;
	
	private boolean pausado;
	private boolean completado;
	private boolean fallido;

	private Juego juego;

	/**
	 * Crea una nueva instancia del modelo de partida de juego.
	 */
	private ModeloPartidaJuego() {
		juego = new Juego();
	}

	/**
	 * Obtiene la instancia única de ModeloPartidaJuego.
	 * @return Instancia unica de ModeloPartidaJuego.
	 */
	public static synchronized ModeloPartidaJuego getInstancia() {
		if(instancia == null) {
			instancia = new ModeloPartidaJuego();
		}
		
		return instancia;
	} 
	
	/**
	 * Actualiza los actores de la partida de juego actual.
	 */
	public void actualizar(float deltaTiempo) {

		if (pausado || fallido || completado) {
			return;
		}

		NaveJugador naveJugador = getNaveJugador();
		naveJugador.actualizar(deltaTiempo);

		Disparo disparo = naveJugador.getDisparo();

		List<NaveEnemiga> navesEnemigas = getNavesEnemigas();
		IteradorGenerico<NaveEnemiga> iteradorNavesEnemigas = new IteradorListaGenerica<NaveEnemiga>(navesEnemigas);
		while (iteradorNavesEnemigas.hasNext() && !fallido) {

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
			if (disparoEnemigo != null && !disparoEnemigo.isImpactado()) {
				boolean jugadorImpactado = naveJugador.validarImpacto(disparoEnemigo);
				if (jugadorImpactado) {
					quitarVida();
				}
			}
			
			if(getVidas() == -1 || naveEnemiga.alcanzoUbicacionLimiteY()) {
				fallido = true;
			}
			
		}
		
		if(!hayNavesEnemigas()) {
			completado = true;
		}
		
	}

	/**
	 * Agrega los puntos a la cuenta de puntos de la partida.
	 * 
	 * @param puntos
	 *            Puntos a agregar.
	 */
	public void agregarPuntos(long puntos) {
		Partida partida = juego.getPartida();
		long totalPuntos = partida.getPuntos() + puntos;
		partida.setPuntos(totalPuntos);
	}

	/**
	 * Alterna la pausa del juego.
	 */
	public void alternarPausa() {
		boolean isPausado = isPausado();
		isPausado = !isPausado;

		setPausado(isPausado);
	}

	/**
	 * Genera un disparo enemigo, seleccionando una de las naves de manera
	 * aleatoria.
	 */
	public void generarDisparoEnemigo() {
		List<NaveEnemiga> navesEnemigas = getNavesEnemigas();
		Random random = new Random();
		if (navesEnemigas.size() == 0) {
			return;
		}
		int indiceNaveEnemigaDisparar = random.nextInt(navesEnemigas.size());
		NaveEnemiga disparar = navesEnemigas.get(indiceNaveEnemigaDisparar);
		if (disparar.isDestruida()) {
			return;
		}

		disparar.disparar();
	}

	/**
	 * Obtiene los elementos del juego actual.
	 * 
	 * @return Naves enemigas.
	 */
	public List<ElementoImagen> getElementosJuego() {
		return juego.getElementosJuego();
	}

	/**
	 * Obtiene el juego actual.
	 * 
	 * @return Juego actual.
	 */
	public Juego getJuego() {
		return juego;
	}

	/**
	 * Obtiene la navel del jugador.
	 * 
	 * @return Nave del jugador.
	 */
	public NaveJugador getNaveJugador() {
		return juego.getNaveJugador();
	}

	/**
	 * Obtiene las naves enemigas del juego actual.
	 * 
	 * @return Naves enemigas.
	 */
	public List<NaveEnemiga> getNavesEnemigas() {
		return juego.getNavesEnemigas();
	}

	/**
	 * Obtiene los puntos de la partida actual.
	 * 
	 * @return
	 */
	public long getPuntos() {
		Partida partida = juego.getPartida();
		long puntos = partida.getPuntos();
		return puntos;
	}

	/**
	 * Obtiene las vidas disponibles en la partida actual.
	 * 
	 * @return Vidas disponibles.
	 */
	public int getVidas() {
		Partida partida = juego.getPartida();
		int vidas = partida.getVidas();
		return vidas;
	}

	/**
	 * Indica si hay mas naves enemigas por eliminar.
	 * 
	 * @return Contador naves enemigas.
	 */
	public boolean hayNavesEnemigas() {
		return juego.getNavesEnemigas().size() > 0;
	}

	private void inicializarNaveJugador() {
		Nivel nivel = juego.getNivel();
		/**
		 * Creación de la nave del jugador usando el patron Factory
		 */
		INaveFactory naveFactory = new NaveFactory();
		Nave naveJugador = naveFactory.crearNave(TipoNave.Jugador);
		naveJugador.setVelocidadX(nivel.getVelocidadJugador());
		naveJugador.setVelocidadDisparo(nivel.getVelocidadDisparosJugador());
		juego.setNaveJugador((NaveJugador) naveJugador);
	}

	/**
	 * Inicializa las naves enemigas.
	 */
	private void inicializarNavesEnemigas() {

		Nivel nivel = juego.getNivel();

		Hashtable<Integer, Integer> configuracionEnemigos = nivel.getConfiguracionEnemigos();

		INaveFactory naveFactory = new NaveFactory();
		TipoNave[] valoresTipoNave = TipoNave.values();
		Enumeration<Integer> enumeradorClavesConfiguracionEnemigos = configuracionEnemigos.keys();
		Integer tipoNave;

		Random random = new Random();

		while (enumeradorClavesConfiguracionEnemigos.hasMoreElements()) {
			tipoNave = enumeradorClavesConfiguracionEnemigos.nextElement();
			Integer contadorEnemigos = configuracionEnemigos.get(tipoNave);
			List<Nave> navesEnemigasTipo = naveFactory.crearNaves(valoresTipoNave[tipoNave],
					contadorEnemigos.intValue());
			IteradorGenerico<Nave> iteradorNavesEnemigas = new IteradorListaGenerica<Nave>(navesEnemigasTipo);
			while (iteradorNavesEnemigas.hasNext()) {
				NaveEnemiga naveEnemiga = (NaveEnemiga) iteradorNavesEnemigas.next();
				naveEnemiga.setVelocidadX(nivel.getVelocidadEnemigos());
				naveEnemiga.setVelocidadY(nivel.getVelocidadEnemigos());
				naveEnemiga.setVelocidadDisparo(nivel.getVelocidadDisparosEnemigos());

				int aleatorio = random.nextInt(20);

				if (aleatorio % 5 == 0) {
					naveEnemiga = new DecoradorNaveEnemigaEscudo(naveEnemiga);
					// naveEnemiga = new DecoradorNaveEnemigaEscudo(naveEnemiga);
				}

				juego.agregaNaveEnemiga(naveEnemiga);
			}
		}

	}

	/**
	 * Inicializa los elementos del juego actual.
	 * @param reiniciarPuntaje Inidica si se debe reiniciar el puntaje actual.
	 */
	public void inicializarPartidaJuego(boolean reiniciarPuntaje) {
		setPausado(false);
		setCompletado(false);
		setFallido(false);
		
		if(reiniciarPuntaje) {
			Partida partida = juego.getPartida();
			partida.setPuntos(PUNTOS_INICIALES);
			partida.setVidas(VIDAS_INICIALES);
		}
		
		juego.getNavesEnemigas().clear();
		juego.getElementosJuego().clear();

		inicializarNavesEnemigas();
		inicializarNaveJugador();
	}

	/**
	 * Indica si el jugador completó el nivel actual.
	 * 
	 * @return Retorna true si el jugador completo el nivel actual; de lo contrario
	 *         retorna false.
	 */
	public boolean isCompletado() {
		return completado;
	}

	/**
	 * Indica si el jugador completó el nivel actual.
	 * 
	 * @return Retorna true si el jugador completo el nivel actual; de lo contrario
	 *         retorna false.
	 */
	public boolean isFallido() {
		return fallido;
	}

	/**
	 * Obtiene el valor que indica si el juego se encuentra pausado.
	 * 
	 * @return Retorna true si el juego se encuentra pausado; de lo contrario
	 *         retorna false.
	 */
	public boolean isPausado() {
		return pausado;
	}

	/**
	 * Quita una vida disponible en la partida de juego actual.
	 */
	public void quitarVida() {
		Partida partida = juego.getPartida();
		int vidas = partida.getVidas();
		if (vidas == -1) {
			return;
		}

		vidas--;

		partida.setVidas(vidas);
	}

	/**
	 * Remueve la nave enemiga.
	 * 
	 * @param naveEnemiga
	 *            Nave a remover.
	 */
	public void removerNaveEnemiga(NaveEnemiga naveEnemiga) {
		juego.removerNaveEnemiga(naveEnemiga);
	}

	/**
	 * Asigna la bandera de completado en true.
	 * 
	 * @param gano
	 *            Valor de la bandera de completado.
	 */
	public void setCompletado(boolean completado) {
		this.completado = completado;
	}

	/**
	 * Asigna la bandera de fallido en true.
	 * 
	 * @param gano
	 *            Valor de la bandera de fallido.
	 */
	public void setFallido(boolean fallido) {
		this.fallido = fallido;
	}

	/**
	 * Asigna el juego actual.
	 * 
	 * @param juego
	 *            Juego actual.
	 */
	public void setJuego(Juego juego) {
		this.juego = juego;
	}

	/**
	 * Asigna el nivel actual al juego.
	 * 
	 * @param nivel
	 *            nNivel actual.
	 */
	public void setNivel(Nivel nivel) {
		juego.setNivel(nivel);
	}

	/**
	 * Asigna el valor que indica si el juego se encuentra pausado.
	 * 
	 * @param pausado
	 *            Valor que indica si el juego se encuentra pausado.
	 */
	public void setPausado(boolean pausado) {
		this.pausado = pausado;
	}

}
