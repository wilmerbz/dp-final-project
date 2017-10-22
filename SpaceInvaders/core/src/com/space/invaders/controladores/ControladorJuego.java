package com.space.invaders.controladores;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.space.invaders.actores.ElementoJuego;
import com.space.invaders.actores.disparos.Disparo;
import com.space.invaders.actores.naves.INaveFactory;
import com.space.invaders.actores.naves.Nave;
import com.space.invaders.actores.naves.NaveEnemiga;
import com.space.invaders.actores.naves.NaveFactory;
import com.space.invaders.actores.naves.TipoNave;
import com.space.invaders.controladores.base.ControladorEstadoJuegoBase;
import com.space.invaders.entidades.Jugador;
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

	public ControladorJuego() {
		modeloNivel = new ModeloNivel();
		modeloPartidaJuego = new ModeloPartidaJuego();
		vistaJuego = new VistaJuego(this);
		elementosJuego = new ArrayList<ElementoJuego>();
		//navesEnemigas = new ArrayList<ElementoJuego>();
	}

	private List<ElementoJuego> elementosJuego;
	//private List<ElementoJuego> navesEnemigas;
	private Nave naveJugador;

	@Override
	public void inicializar() {
		contadorVisualizaciones++;
		System.out.println("Iniciando ControladorJuego: " + contadorVisualizaciones);
		Nivel nivel = modeloNivel.getNivel(1);
		modeloPartidaJuego.setNivel(nivel);
		System.out.println("Nivel: "+ nivel.getNumero() + " - "+ nivel.getNombre());
		modeloPartidaJuego.inicializarPartidaJuego();
		vistaJuego.inicializar();
	
		/**
		 * Creación de la nave del jugador usando el patron Factory
		 */
		INaveFactory jugador = new NaveFactory();
		naveJugador = jugador.crearNave(TipoNave.Jugador);
		naveJugador.setVelocidadX(5);
		elementosJuego.add(naveJugador);

	}

	@Override
	public void setMediador(IMediador mediador) {
		// TODO Auto-generated method stub
		this.mediador = mediador;
	}

	@Override
	public void recibirMensaje(String mensaje, Object data) {
		// TODO Auto-generated method stub
		Jugador jugador = (Jugador) data;
		System.out.println("Mensaje recibido por ControladorJuego: " + mensaje + " - Nombre: " + jugador.getNombre()
				+ " - Nickname: " + jugador.getNickname());
	}

	private int direccion = 1;

	@Override
	public void actualizar(float deltaTiempo) {

		vistaJuego.actualizar(deltaTiempo);
		
		float width = Gdx.graphics.getWidth();
		boolean cambioDireccion = false;

		float dx = 1.5f;

		Disparo disparo  = naveJugador.getDisparo();
		List<NaveEnemiga> navesEnemigas = modeloPartidaJuego.getNavesEnemigas();
		for (int i = 0; i < navesEnemigas.size(); i++) {

			ElementoJuego elementoJuego = navesEnemigas.get(i);
			elementoJuego.actualizar(deltaTiempo);
//
//			//float x = elementoJuego.getX() + (dx * speed);
//			float x = elementoJuego.getX() + (dx * direccion);
//
//			if (!cambioDireccion && (x > width || x < 0)) {
//				cambioDireccion = true;
//				direccion = direccion * -1;
//			}
//
//			//x = elementoJuego.getX() + (dx * speed * direccion);
//			x = elementoJuego.getX() + (dx * direccion);
//
//			elementoJuego.setX(x);
//			
//			if(elementoJuego instanceof Nave && disparo!=null && !disparo.isImpactado()) {
//				NaveEnemiga naveEnemiga = (NaveEnemiga)elementoJuego;
//				
//				if(naveEnemiga.isDestruida())
//					continue;
//				
//				boolean impacto = naveEnemiga.validarImpacto(disparo);
//				
//				if(impacto) {
//					disparo.setImpactado(true);
//				}
//			}
		}

		naveJugador.actualizar(deltaTiempo);
		
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
			naveJugador.moverIzquierda();
		}

		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			naveJugador.moverDerecha();
		}
		
		if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
			naveJugador.disparar();
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
	
}