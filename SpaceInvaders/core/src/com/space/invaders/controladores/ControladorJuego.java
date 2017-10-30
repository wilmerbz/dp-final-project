package com.space.invaders.controladores;

import java.util.List;
import java.util.Random;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.space.invaders.actores.ElementoJuego;
import com.space.invaders.actores.disparos.Disparo;
import com.space.invaders.actores.iterator.IteradorGenerico;
import com.space.invaders.actores.iterator.IteradorListaGenerica;
import com.space.invaders.actores.naves.NaveEnemiga;
import com.space.invaders.actores.naves.NaveJugador;
import com.space.invaders.actores.naves.comandos.ComandoNaveDisparar;
import com.space.invaders.actores.naves.comandos.ComandoNaveMovimientoDerecha;
import com.space.invaders.actores.naves.comandos.ComandoNaveMovimientoIzquierda;
import com.space.invaders.actores.naves.comandos.IComandoNave;
import com.space.invaders.actores.util.Temporizador;
import com.space.invaders.controladores.base.ControladorEstadoJuegoBase;
import com.space.invaders.entidades.Nivel;
import com.space.invaders.interfaces.mensajes.IColega;
import com.space.invaders.interfaces.mensajes.IMediador;
import com.space.invaders.modelos.ModeloNivel;
import com.space.invaders.modelos.ModeloPartidaJuego;
import com.space.invaders.vistas.VistaJuego;

/**
 * Controlador de juego.
 */
public class ControladorJuego extends ControladorEstadoJuegoBase implements IColega {
	
	private int contadorVisualizaciones = 0;
	private IMediador mediador;
	private ModeloPartidaJuego modeloPartidaJuego;
	private ModeloNivel modeloNivel;
	private VistaJuego vistaJuego;
	private Temporizador temporizadorDisparo;
	
	private IComandoNave comandoNaveMovimientoDerecha;
	private IComandoNave comandoNaveMovimientoIzquierda;
	private IComandoNave comandoNaveDisparar;
	
	/**
	 * Crea una nueva instancia de Controlador Juego.
	 */
	public ControladorJuego() {
		modeloNivel = new ModeloNivel();
		modeloPartidaJuego = new ModeloPartidaJuego();
		vistaJuego = new VistaJuego(this);
		temporizadorDisparo = new Temporizador();
	}

	@Override
	public void inicializar() {
		contadorVisualizaciones++;
		System.out.println("Iniciando ControladorJuego: " + contadorVisualizaciones);
		Nivel nivel = modeloNivel.getNivel(0);
		modeloPartidaJuego.setNivel(nivel);
		temporizadorDisparo.setTiempo(nivel.getFrecuenciaDisparosEnemigos());
		System.out.println("Nivel: "+ nivel.getNumero() + " - "+ nivel.getNombre());
		modeloPartidaJuego.inicializarPartidaJuego();
		vistaJuego.inicializar();
		
		inicializarComandos();

	}
	
	/**
	 * Inicializa los comandos para la nave del jugador.
	 */
	private void inicializarComandos() {
		NaveJugador naveJugador = modeloPartidaJuego.getNaveJugador();
		comandoNaveMovimientoDerecha = new ComandoNaveMovimientoDerecha(naveJugador);
		comandoNaveMovimientoIzquierda = new ComandoNaveMovimientoIzquierda(naveJugador);
		comandoNaveDisparar = new ComandoNaveDisparar(naveJugador);
	}

	@Override
	public void setMediador(IMediador mediador) {
		this.mediador = mediador;
	}

	@Override
	public void recibirMensaje(String mensaje, Object data) {
		//Jugador jugador = (Jugador) data;
		//System.out.println("Mensaje recibido por ControladorJuego: " + mensaje + " - Nombre: " + jugador.getNombre() + " - Nickname: " + jugador.getNickname());
	}

	@Override
	public void actualizar(float deltaTiempo) {

		vistaJuego.actualizar(deltaTiempo);

		NaveJugador naveJugador = modeloPartidaJuego.getNaveJugador();
		naveJugador.actualizar(deltaTiempo);

		Disparo disparo = naveJugador.getDisparo();

		List<NaveEnemiga> navesEnemigas = modeloPartidaJuego.getNavesEnemigas();
		IteradorGenerico<NaveEnemiga> iteradorNavesEnemigas = new IteradorListaGenerica<NaveEnemiga>(navesEnemigas);
		while (iteradorNavesEnemigas.hasNext()) {

			NaveEnemiga naveEnemiga = iteradorNavesEnemigas.next();
			naveEnemiga.actualizar(deltaTiempo);

			if (disparo != null && !disparo.isImpactado()) {

				if (naveEnemiga.isDestruida())
					continue;

				boolean naveImpactada = naveEnemiga.validarImpacto(disparo);

				if (naveImpactada) {
					modeloPartidaJuego.removerNaveEnemiga(naveEnemiga);
					modeloPartidaJuego.agregarPuntos(naveEnemiga.puntos());
					
					Sound s = Gdx.audio.newSound(Gdx.files.internal("sounds/explosion.mp3"));
					s.play();
				}
			}
			Disparo disparoEnemigo = naveEnemiga.getDisparo();
			if(disparoEnemigo!= null && !disparoEnemigo.isImpactado()) {
				boolean jugadorImpactado = naveJugador.validarImpacto(disparoEnemigo);
				if(jugadorImpactado) {
					modeloPartidaJuego.quitarVida();
				}
			}
		}

		if (temporizadorDisparo.esTiempo(deltaTiempo)) {
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

	}

	@Override
	public void renderizar() {
		vistaJuego.renderizar();
	}

	@Override
	public void manejarEntradas() {
		
		//Manejar las entradas y ejecutar los comandos correspondientes.
		float direccion = 0;
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			comandoNaveMovimientoIzquierda.ejecutar();
		}

		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			comandoNaveMovimientoDerecha.ejecutar();
		}
		
		if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
			comandoNaveDisparar.ejecutar();
			Sound s = Gdx.audio.newSound(Gdx.files.internal("sounds/shoot.mp3"));
			s.play();
		}
	}

	@Override
	public void dispose() {
		vistaJuego.dispose();
	}

	/**
	 * Obtiene la lista de elementos del juego.
	 * @return
	 */
	public List<ElementoJuego> getElementosJuego() {
		return modeloPartidaJuego.getElementosJuego();
	}
	
	
	/**
	 * Obtiene la lista de naves enemigas.
	 * @return
	 */
	public List<NaveEnemiga> getNavesEnemigas() {
		return modeloPartidaJuego.getNavesEnemigas();
	}

	/**
	 * Obtiene la cantidad de enemigos por fila.
	 * @return
	 */
	public int getCantidadEnemigosPorFila() {
		return modeloPartidaJuego.getJuego().getNivel().getCantidadEnemigosPorFila();
	}
	
	/**
	 * Obtiene la nave del jugador.
	 * @return Nave del jugador.
	 */
	public NaveJugador getNaveJugador() {
		return modeloPartidaJuego.getNaveJugador();
	}

	/**
	 * Obtiene los puntos de la partida actual.
	 * @return Puntos.
	 */
	public long getPuntos() {
		return modeloPartidaJuego.getPuntos();
	}

	/**
	 * Obtiene las vidas disponibles en la partida actual.
	 * @return Vidas.
	 */
	public int getVidas() {
		return modeloPartidaJuego.getVidas();
	}
	
}