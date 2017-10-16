package com.space.invaders.controladores;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.space.invaders.actores.ElementoJuego;
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
	private ElementoJuego naveJugador;

	@Override
	public void inicializar() {
		contadorVisualizaciones++;

		System.out.println("Iniciando ControladorJuego: " + contadorVisualizaciones);

		int contadorEnemigos = 20;
		/**
		 * Creación de los enemigos usando el patron Factory
		 */
		INaveFactory enemigos = new NaveFactory();
		List<Nave> nave1 = enemigos.crearNaves(TipoNave.Calamar, contadorEnemigos);
		List<Nave> nave2 = enemigos.crearNaves(TipoNave.Cangrejo, contadorEnemigos);
		List<Nave> nave3 = enemigos.crearNaves(TipoNave.Pulpo, contadorEnemigos);
		for (int i = 0; i < contadorEnemigos; i++) {
			elementosJuego.add(nave1.get(i));
			navesEnemigas.add(nave1.get(i));
			elementosJuego.add(nave2.get(i));
			navesEnemigas.add(nave2.get(i));
			elementosJuego.add(nave3.get(i));
			navesEnemigas.add(nave3.get(i));
		}
		/**
		 * Creación de la nave del jugador usando el patron Factory
		 */
		INaveFactory jugador = new NaveFactory();
		naveJugador = jugador.crearNave(TipoNave.Jugador);

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

		float width = Gdx.graphics.getWidth();
		boolean cambioDireccion = false;

		float radians = 3.1415f / 2;
		float dx = MathUtils.cos(radians);
		float speed = 7000;

		for (int i = 0; i < navesEnemigas.size(); i++) {

			ElementoJuego elementoJuego = navesEnemigas.get(i);
			elementoJuego.actualizar(deltaTiempo);

			float x = elementoJuego.getX() + (dx * speed);

			if (!cambioDireccion && (x > width || x < 0)) {
				cambioDireccion = true;
				direccion = direccion * -1;
			}

			x = elementoJuego.getX() + (dx * speed * direccion);

			elementoJuego.setX(x);
		}

		vistaJuego.actualizar(deltaTiempo);
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
			direccion = -1;
		}

		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			direccion = 1;
		}

		if (direccion == 0)
			return;

		float radians = 3.1415f / 2;
		float dx = MathUtils.cos(radians);
		float speed = 28000 * direccion;

		float x = naveJugador.getX() + (dx * speed);
		naveJugador.setX(x);

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		vistaJuego.dispose();
	}

	public List<ElementoJuego> obtenerElementosJuego() {
		return elementosJuego;
	}

}