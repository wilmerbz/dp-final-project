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
import com.space.invaders.actores.naves.NaveFactory;
import com.space.invaders.actores.naves.TipoNave;
import com.space.invaders.controladores.base.ControladorEstadoJuegoBase;
import com.space.invaders.entidades.Jugador;
import com.space.invaders.interfaces.mensajes.IColega;
import com.space.invaders.interfaces.mensajes.IMediador;
import com.space.invaders.vistas.VistaJuego;

public class ControladorJuego extends ControladorEstadoJuegoBase implements IColega {
	private int contadorVisualizaciones = 0;
	private IMediador mediador;
	private VistaJuego vistaJuego;

	public ControladorJuego() {
		vistaJuego = new VistaJuego(this);
		elementosJuego = new ArrayList<ElementoJuego>();
		navesEnemigas = new ArrayList<ElementoJuego>();
	}

	private List<ElementoJuego> elementosJuego;
	private List<ElementoJuego> navesEnemigas;
	private Nave naveJugador;

	@Override
	public void inicializar() {
		contadorVisualizaciones++;

		System.out.println("Iniciando ControladorJuego: " + contadorVisualizaciones);

		int contadorEnemigos = 20;
		/**
		 * Creaci�n de los enemigos usando el patron Factory
		 */
		INaveFactory enemigos = new NaveFactory();
		List<Nave> nave1 = enemigos.crearNaves(TipoNave.Calamar, contadorEnemigos);
		List<Nave> nave2 = enemigos.crearNaves(TipoNave.Cangrejo, contadorEnemigos);
		List<Nave> nave3 = enemigos.crearNaves(TipoNave.Pulpo, contadorEnemigos);
		for (int i = 0; i < contadorEnemigos; i++) {
			nave1.get(i).setPosition((i + 1) * 40, 500);
			elementosJuego.add(nave1.get(i));
			navesEnemigas.add(nave1.get(i));
			nave2.get(i).setPosition((i + 1) * 40, 600);			
			elementosJuego.add(nave2.get(i));
			navesEnemigas.add(nave2.get(i));
			nave3.get(i).setPosition((i + 1) * 40, 700);			
			elementosJuego.add(nave3.get(i));
			navesEnemigas.add(nave3.get(i));
		}
		/**
		 * Creaci�n de la nave del jugador usando el patron Factory
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

		//float radians = 3.1415f / 2;
		//float dx = MathUtils.cos(radians);
		//float speed = 7000;
		
		float dx = 1.5f;

		Disparo disparo  = naveJugador.getDisparo();
		
		for (int i = 0; i < navesEnemigas.size(); i++) {

			ElementoJuego elementoJuego = navesEnemigas.get(i);
			elementoJuego.actualizar(deltaTiempo);

			//float x = elementoJuego.getX() + (dx * speed);
			float x = elementoJuego.getX() + (dx * direccion);

			if (!cambioDireccion && (x > width || x < 0)) {
				cambioDireccion = true;
				direccion = direccion * -1;
			}

			//x = elementoJuego.getX() + (dx * speed * direccion);
			x = elementoJuego.getX() + (dx * direccion);

			elementoJuego.setX(x);
			
			if(elementoJuego instanceof Nave && disparo!=null) {
				((Nave)elementoJuego).validarImpacto(disparo);
			}
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

	public List<ElementoJuego> obtenerElementosJuego() {
		return elementosJuego;
	}

	}
