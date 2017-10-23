package com.space.invaders.vistas;

import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.space.invaders.actores.FondoInfinito;
import com.space.invaders.actores.iterator.IteradorGenerico;
import com.space.invaders.actores.iterator.IteradorListaGenerica;
import com.space.invaders.actores.naves.NaveEnemiga;
import com.space.invaders.actores.naves.NaveJugador;
import com.space.invaders.actores.ElementoJuego;
import com.space.invaders.controladores.ControladorJuego;
import com.space.invaders.interfaces.controladores.IControladorEstadoJuego;
import com.space.invaders.recursos.texturas.AdministradorTexturas;
import com.space.invaders.recursos.texturas.NombreTextura;
import com.space.invaders.vistas.base.VistaEstadoJuego;

public class VistaJuego extends VistaEstadoJuego {

	SpriteBatch batch;
	FondoInfinito background;
	
	private ControladorJuego controladorJuego;
	
	public VistaJuego(IControladorEstadoJuego controladorEstadoJuego) {
		super(controladorEstadoJuego);

		controladorJuego = (ControladorJuego) controladorEstadoJuego;
		batch = new SpriteBatch();
		background = new FondoInfinito(NombreTextura.GAME_BACKGROUND);
	}

	@Override
	public void inicializar() {
		
		List<NaveEnemiga> navesEnemigas = controladorJuego.getNavesEnemigas();
		int cantidadEnemigosPorFila = controladorJuego.getCantidadEnemigosPorFila();
		float posicionInicialX = 0;
		float posicionInicialY = getHeight() - 50;
		float espacioX = 10;
		float espacioY = 10;
		
		float x = posicionInicialX;
		float y = posicionInicialY;
		
		IteradorGenerico<NaveEnemiga> iteradorNavesEnemigas = new IteradorListaGenerica<NaveEnemiga>(navesEnemigas);
		int indiceNaveEnemiga = 0;
		while (iteradorNavesEnemigas.hasNext()) {

			NaveEnemiga naveEnemiga = iteradorNavesEnemigas.next();
			 x +=  (naveEnemiga.getWidth() + espacioX);
			 
			 if(indiceNaveEnemiga % cantidadEnemigosPorFila == 0) {
				 y -= ((naveEnemiga.getHeight() + espacioY) * 2);
				 x = posicionInicialX;
			 }
			naveEnemiga.setPosition(x,y);
			indiceNaveEnemiga++;
		}
		
		NaveJugador naveJugador = controladorJuego.getNaveJugador();
		float xNaveJugador = (getWidth()/2) - (naveJugador.getWidth()/2);
		naveJugador.setX(xNaveJugador);
		naveJugador.setY(5);		
	}

	@Override
	public void actualizar(float deltaTiempo) {
		background.act(deltaTiempo);
	}

	@Override
	public void renderizar() {
		
		batch.begin();
		//batch.draw(background, 0, 0);
		background.draw(batch, 1);
		
		List<ElementoJuego> elementosJuego = controladorJuego.getElementosJuego();
		IteradorGenerico<ElementoJuego> iteradorElementoJuego = new IteradorListaGenerica<ElementoJuego>(elementosJuego);
		
		while (iteradorElementoJuego.hasNext()) {
			ElementoJuego elementoJuego = iteradorElementoJuego.next();
			elementoJuego.renderizar(batch);
		}
		
		
		
		batch.end();
		
	}

	@Override
	public void manejarEntradas() {

	}

	@Override
	public void dispose() {
		batch.dispose();
	}

}
