package com.space.invaders.controladores;

import java.util.List;
import java.util.Random;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.space.invaders.actores.ElementoImagen;
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
import com.space.invaders.entidades.menu.OpcionMenu;
import com.space.invaders.interfaces.mensajes.IColega;
import com.space.invaders.interfaces.mensajes.IMediador;
import com.space.invaders.modelos.ModeloMenuPausa;
import com.space.invaders.modelos.ModeloNivel;
import com.space.invaders.modelos.ModeloPartidaJuego;
import com.space.invaders.navegacion.NombreEstado;
import com.space.invaders.recursos.sonido.AdministradorSonidos;
import com.space.invaders.recursos.sonido.NombreSonido;
import com.space.invaders.vistas.VistaEstadoPartidaJuego;

/**
 * Controlador de juego.
 */
public class ControladorEstadoPartidaJuego extends ControladorEstadoJuegoBase implements IColega {

	private int contadorVisualizaciones = 0;
	private IMediador mediador;
	private ModeloPartidaJuego modeloPartidaJuego;
	private ModeloMenuPausa modeloMenuPausa;
	private ModeloNivel modeloNivel;
	private VistaEstadoPartidaJuego vistaEstadoPartidaJuego;
	private Temporizador temporizadorDisparoEnemigo;

	private IComandoNave comandoNaveMovimientoDerecha;
	private IComandoNave comandoNaveMovimientoIzquierda;
	private IComandoNave comandoNaveDisparar;

	/**
	 * Crea una nueva instancia de Controlador Juego.
	 */
	public ControladorEstadoPartidaJuego() {
		modeloNivel = new ModeloNivel();
		modeloPartidaJuego = new ModeloPartidaJuego();
		modeloMenuPausa = new ModeloMenuPausa();
		vistaEstadoPartidaJuego = new VistaEstadoPartidaJuego(this);
		temporizadorDisparoEnemigo = new Temporizador();
	}

	@Override
	public void inicializar() {
		contadorVisualizaciones++;
		System.out.println("Iniciando ControladorJuego: " + contadorVisualizaciones);
		Nivel nivel = modeloNivel.getNivel(0);
		modeloPartidaJuego.setNivel(nivel);
		temporizadorDisparoEnemigo.setTiempo(nivel.getFrecuenciaDisparosEnemigos());
		System.out.println("Nivel: " + nivel.getNumero() + " - " + nivel.getNombre());
		modeloPartidaJuego.inicializarPartidaJuego();
		vistaEstadoPartidaJuego.inicializar();
		vistaEstadoPartidaJuego.setOpcionesMenu(modeloMenuPausa.getElementosMenu());
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
		// Jugador jugador = (Jugador) data;
		// System.out.println("Mensaje recibido por ControladorJuego: " + mensaje + " -
		// Nombre: " + jugador.getNombre() + " - Nickname: " + jugador.getNickname());
	}

	@Override
	public void actualizar(float deltaTiempo) {

		if (modeloPartidaJuego.isPausado()) {
			return;
		}

		modeloPartidaJuego.actualizar(deltaTiempo);
		vistaEstadoPartidaJuego.actualizar(deltaTiempo);

		if (temporizadorDisparoEnemigo.esTiempo(deltaTiempo)) {
			modeloPartidaJuego.generarDisparoEnemigo();
		}
	}

	@Override
	public void renderizar() {
		vistaEstadoPartidaJuego.renderizar();
	}

	@Override
	public void manejarEntradas() {

		if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
			modeloPartidaJuego.alternarPausa();
			reproducirSonido(NombreSonido.MENU_SELECCIONAR);
		}

		if (modeloPartidaJuego.isPausado()) {

			String nombreSonido = null;

			if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
				nombreSonido = NombreSonido.MENU_SELECCIONAR;

				OpcionMenu elementoMenuActual = modeloMenuPausa.getElementoMenuActual();

				if (elementoMenuActual != null) {
					NombreEstado nombreEstado = elementoMenuActual.getNombreRuta();

					switch (nombreEstado) {
					case Continuar:

						modeloPartidaJuego.alternarPausa();
						break;
					case MenuPrincipal:
						nombreSonido = NombreSonido.MENU_REGRESAR;
						setControladorEstado(nombreEstado);
						break;
					case Salir:
						Gdx.app.exit();
						break;
					default:
						break;
					}

				}
			}

			if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
				nombreSonido = NombreSonido.MENU_MOVER;
				modeloMenuPausa.moverElementoAnterior();
			}

			if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
				nombreSonido = NombreSonido.MENU_MOVER;
				modeloMenuPausa.moverElementoSiguiente();
			}

			if (nombreSonido != null) {
				reproducirSonido(nombreSonido);
			}

		} else {

			// Manejar las entradas y ejecutar los comandos correspondientes.
			if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
				comandoNaveMovimientoIzquierda.ejecutar();
			}

			if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
				comandoNaveMovimientoDerecha.ejecutar();
			}

			if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
				comandoNaveDisparar.ejecutar();
			}

		}
	}

	@Override
	public void dispose() {
		vistaEstadoPartidaJuego.dispose();
	}

	/**
	 * Obtiene la lista de elementos del juego.
	 * 
	 * @return
	 */
	public List<ElementoImagen> getElementosJuego() {
		return modeloPartidaJuego.getElementosJuego();
	}

	/**
	 * Obtiene la lista de naves enemigas.
	 * 
	 * @return
	 */
	public List<NaveEnemiga> getNavesEnemigas() {
		return modeloPartidaJuego.getNavesEnemigas();
	}

	/**
	 * Obtiene la cantidad de enemigos por fila.
	 * 
	 * @return
	 */
	public int getCantidadEnemigosPorFila() {
		return modeloPartidaJuego.getJuego().getNivel().getCantidadEnemigosPorFila();
	}

	/**
	 * Obtiene la nave del jugador.
	 * 
	 * @return Nave del jugador.
	 */
	public NaveJugador getNaveJugador() {
		return modeloPartidaJuego.getNaveJugador();
	}

	/**
	 * Obtiene los puntos de la partida actual.
	 * 
	 * @return Puntos.
	 */
	public long getPuntos() {
		return modeloPartidaJuego.getPuntos();
	}

	/**
	 * Obtiene las vidas disponibles en la partida actual.
	 * 
	 * @return Vidas.
	 */
	public int getVidas() {
		return modeloPartidaJuego.getVidas();
	}

	/**
	 * Obtiene el valor que indica si el juego se encuentra pausado.
	 * 
	 * @return
	 */
	public boolean isPausado() {
		return modeloPartidaJuego.isPausado();
	}

	/**
	 * Obtiene los elementos del menu.
	 * 
	 * @return Elementos menu.
	 */
	public List<OpcionMenu> getElementosMenu() {
		return modeloMenuPausa.getElementosMenu();
	}

}