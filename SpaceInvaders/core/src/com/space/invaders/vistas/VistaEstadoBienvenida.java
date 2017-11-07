package com.space.invaders.vistas;

import com.space.invaders.actores.FondoInfinito;
import com.space.invaders.interfaces.controladores.IControladorEstadoJuego;
import com.space.invaders.recursos.texturas.NombreTextura;
import com.space.invaders.vistas.base.VistaEstadoJuego;

/**
 * Estado de Bienvenida del Juego.
 */
public class VistaEstadoBienvenida extends VistaEstadoJuego {

	
	//Texture background;
	FondoInfinito background;
	/**
	 * Crea una nueva instancia del controlador del estado de Bienvenida del juego.
	 * @param controlador
	 */
	public VistaEstadoBienvenida(IControladorEstadoJuego controlador) {
		super(controlador);
	}

	@Override
	public void inicializar() {
		super.inicializar();
		background = new FondoInfinito(NombreTextura.GAME_BACKGROUND);
	}

	@Override
	public void actualizar(float deltaTiempo) {
		background.act(deltaTiempo);
	}

	@Override
	public void renderizar() {
		spriteBatch.begin();
		
		background.draw(spriteBatch, 1);
		
		spriteBatch.end();
	}

	@Override
	public void dispose() {
		spriteBatch.dispose();
		background = null;
	}

}
