package com.space.invaders.vistas;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.space.invaders.interfaces.controladores.IControlador;
import com.space.invaders.interfaces.controladores.IControladorEstadoJuego;
import com.space.invaders.vistas.base.VistaEstadoJuego;

/**
 * Estado de Bienvenida del Juego.
 */
public class VistaBienvenida extends VistaEstadoJuego {

	SpriteBatch batch;
	Texture img;
	
	
	/**
	 * Crea una nueva instancia del controlador del estado de Bienvenida del juego.
	 * @param controlador
	 */
	public VistaBienvenida(IControladorEstadoJuego controlador) {
		super(controlador);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void inicializar() {
		// TODO Auto-generated method stub
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void actualizar(float deltaTiempo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void renderizar() {
		batch.begin();
		batch.draw(img, 0, 0);
		batch.draw(img, 200, 100);
		batch.end();
	}

	@Override
	public void manejarEntradas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		batch.dispose();
		img.dispose();
	}

}
