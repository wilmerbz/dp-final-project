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
import com.space.invaders.actores.util.Temporizador;
import com.space.invaders.controladores.base.ControladorEstadoJuegoBase;
import com.space.invaders.entidades.Nivel;
import com.space.invaders.interfaces.mensajes.IColega;
import com.space.invaders.interfaces.mensajes.IMediador;
import com.space.invaders.modelos.ModeloNivel;
import com.space.invaders.modelos.ModeloPartidaJuego;
import com.space.invaders.vistas.VistaJuego;

public class ControladorJuego extends ControladorEstadoJuegoBase implements IColega {
	private int contadorVisualizaciones = 0;
	private IMediador mediador;
	private ModeloPartidaJuego modeloPartidaJuego;
	private ModeloNivel modeloNivel;
	private VistaJuego vistaJuego;
	private Temporizador temporizadorDisparo;
	
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
		Nivel nivel = modeloNivel.getNivel(1);
		modeloPartidaJuego.setNivel(nivel);
		temporizadorDisparo.setTiempo(nivel.getFrecuenciaDisparosEnemigos());
		System.out.println("Nivel: "+ nivel.getNumero() + " - "+ nivel.getNombre());
		modeloPartidaJuego.inicializarPartidaJuego();
		vistaJuego.inicializar();
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

		float width = Gdx.graphics.getWidth();
		boolean cambioDireccion = false;

		List<NaveEnemiga> navesEnemigas = modeloPartidaJuego.getNavesEnemigas();
		IteradorGenerico<NaveEnemiga> iteradorNavesEnemigas = new IteradorListaGenerica<NaveEnemiga>(navesEnemigas);
		while (iteradorNavesEnemigas.hasNext()) {

			NaveEnemiga naveEnemiga = iteradorNavesEnemigas.next();
			naveEnemiga.actualizar(deltaTiempo);

			if (disparo != null && !disparo.isImpactado()) {

				if (naveEnemiga.isDestruida())
					continue;

				boolean impacto = naveEnemiga.validarImpacto(disparo);

				if (impacto) {
					disparo.setImpactado(true);
					Sound s = Gdx.audio.newSound(Gdx.files.internal("sounds/explosion.mp3"));
					s.play();
				}
			}
		}

		if (temporizadorDisparo.esTiempo(deltaTiempo)) {
			Random random = new Random();
			int indiceNaveEnemigaDisparar = random.nextInt(navesEnemigas.size());

			NaveEnemiga disparar = navesEnemigas.get(indiceNaveEnemigaDisparar);
			disparar.disparar();
			System.out.println("Nave Dispara: " + (indiceNaveEnemigaDisparar + 1));
		}

	}

	@Override
	public void renderizar() {
		// TODO Auto-generated method stub
		vistaJuego.renderizar();
	}

	@Override
	public void manejarEntradas() {
		// TODO Auto-generated method stub
		float direccion = 0;
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			modeloPartidaJuego.getNaveJugador().moverIzquierda();
		}

		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			modeloPartidaJuego.getNaveJugador().moverDerecha();
		}
		
		if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
			modeloPartidaJuego.getNaveJugador().disparar();
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
	
}