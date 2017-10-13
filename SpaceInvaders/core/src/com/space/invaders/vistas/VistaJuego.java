package com.space.invaders.vistas;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.space.invaders.actores.ElementoJuego;
import com.space.invaders.controladores.ControladorJuego;
import com.space.invaders.interfaces.controladores.IControladorEstadoJuego;
import com.space.invaders.vistas.base.VistaEstadoJuego;

public class VistaJuego extends VistaEstadoJuego {

	SpriteBatch batch;
	private ControladorJuego controladorJuego;
	
	public VistaJuego(IControladorEstadoJuego controladorEstadoJuego) {
		super(controladorEstadoJuego);

		controladorJuego = (ControladorJuego) controladorEstadoJuego;
		batch = new SpriteBatch();
	}

	@Override
	public void inicializar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(float deltaTiempo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void renderizar() {
		// TODO Auto-generated method stub
		batch.begin();
		List<ElementoJuego> elementosJuego = controladorJuego.obtenerElementosJuego();
		
		for (int i = 0; i < elementosJuego.size(); i++) {
			ElementoJuego elementoJuego = elementosJuego.get(i);
			elementoJuego.draw(batch, 1);
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
