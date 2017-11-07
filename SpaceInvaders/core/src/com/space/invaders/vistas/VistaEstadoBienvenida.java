package com.space.invaders.vistas;

import com.badlogic.gdx.graphics.Color;
import com.space.invaders.actores.ElementoTexto;
import com.space.invaders.actores.FondoInfinito;
import com.space.invaders.interfaces.controladores.IControladorEstadoJuego;
import com.space.invaders.recursos.texto.NombreFuente;
import com.space.invaders.recursos.texturas.NombreTextura;
import com.space.invaders.vistas.base.VistaEstadoJuego;

/**
 * Estado de Bienvenida del Juego.
 */
public class VistaEstadoBienvenida extends VistaEstadoJuego {

	private ElementoTexto titulo;
	private ElementoTexto continuar;
	private String textoTitulo = "* SPACE INVADERS *";
	private String textoContinuar = "Presiona [Enter] para continuar.";

	/**
	 * Crea una nueva instancia del controlador del estado de Bienvenida del juego.
	 * 
	 * @param controlador
	 */
	public VistaEstadoBienvenida(IControladorEstadoJuego controlador) {
		super(controlador);
	}

	@Override
	public void inicializar() {
		super.inicializar();

		titulo = new ElementoTexto(textoTitulo, NombreFuente.DEFAULT, 100, Color.WHITE);
		float xTitulo = (getWidth() - titulo.getWidth()) / 2;
		float yTitulo = (getHeight() + titulo.getHeight()) / 2;
		titulo.setX(xTitulo);
		titulo.setY(yTitulo);

		continuar = new ElementoTexto(textoContinuar, NombreFuente.DEFAULT, 30, Color.LIGHT_GRAY);
		float xContinuar = (getWidth() - continuar.getWidth()) / 2;
		float yContinuar = (yTitulo - (titulo.getHeight() * 2));
		continuar.setX(xContinuar);
		continuar.setY(yContinuar);

	}

	@Override
	public void actualizar(float deltaTiempo) {

	}

	@Override
	public void renderizar() {
		spriteBatch.begin();

		titulo.renderizar(spriteBatch);
		continuar.renderizar(spriteBatch);

		spriteBatch.end();
	}

	@Override
	public void dispose() {
		spriteBatch.dispose();
		// background = null;
	}

}
