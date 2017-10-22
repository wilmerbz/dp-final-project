package com.space.invaders.vistas;

import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.space.invaders.actores.FondoInfinito;
import com.space.invaders.actores.ElementoJuego;
import com.space.invaders.controladores.ControladorJuego;
import com.space.invaders.interfaces.controladores.IControladorEstadoJuego;
import com.space.invaders.recursos.texturas.AdministradorTexturas;
import com.space.invaders.recursos.texturas.NombreTextura;
import com.space.invaders.vistas.base.VistaEstadoJuego;

public class VistaJuego extends VistaEstadoJuego {

	SpriteBatch batch;
	//Texture background;
	FondoInfinito background;
	
	
	private ControladorJuego controladorJuego;
	
	public VistaJuego(IControladorEstadoJuego controladorEstadoJuego) {
		super(controladorEstadoJuego);

		controladorJuego = (ControladorJuego) controladorEstadoJuego;
		batch = new SpriteBatch();
		
		//background = AdministradorTexturas.getInstancia().obtenerTextura(NombreTextura.GAME_BACKGROUND);
		background = new FondoInfinito(NombreTextura.GAME_BACKGROUND);
	}

	@Override
	public void inicializar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(float deltaTiempo) {
		// TODO Auto-generated method stub
		background.act(deltaTiempo);
	}

	@Override
	public void renderizar() {
		// TODO Auto-generated method stub
		batch.begin();
		//batch.draw(background, 0, 0);
		background.draw(batch, 1);
		
		List<ElementoJuego> elementosJuego = controladorJuego.obtenerElementosJuego();
		
		for (int i = 0; i < elementosJuego.size(); i++) {
			ElementoJuego elementoJuego = elementosJuego.get(i);
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
