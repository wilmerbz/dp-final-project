package com.space.invaders.vistas;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.space.invaders.SpaceInvadersGame;
import com.space.invaders.actores.ElementoTexto;
import com.space.invaders.controladores.ControladorEstadoMenuPrincipal;
import com.space.invaders.entidades.menu.OpcionMenu;
import com.space.invaders.interfaces.controladores.IControladorEstadoJuego;
import com.space.invaders.recursos.texto.AdministradorTexto;
import com.space.invaders.recursos.texto.IAdministradorTexto;
import com.space.invaders.recursos.texto.NombreFuente;
import com.space.invaders.vistas.base.VistaEstadoJuego;

/**
 * Vista del menu principal del juego.
 */
public class VistaEstadoMenuPrincipal extends VistaEstadoJuego {

	private ControladorEstadoMenuPrincipal controlador;
	private VistaMenu vistaMenu;
	private final String textoTitulo = "Space Invaders";

	/**
	 * Crea una nueva instancia del estado del Menu Principal del juego.
	 * 
	 * @param controladorEstadoJuego
	 *            Controlador del estado del juego.
	 */
	public VistaEstadoMenuPrincipal(IControladorEstadoJuego controladorEstadoJuego) {
		super(controladorEstadoJuego);
		controlador = (ControladorEstadoMenuPrincipal) controladorEstadoJuego;
		vistaMenu = new VistaMenu(this, textoTitulo);
	}

	@Override
	public void inicializar() {
		super.inicializar();

		vistaMenu.inicializar();
	}

	/**
	 * Asigna las opciones del menu.
	 * 
	 * @param opcionesMenu
	 *            Opciones de menu.
	 */
	public void setOpcionesMenu(List<OpcionMenu> opcionesMenu) {
		vistaMenu.setOpcionesMenu(opcionesMenu);
	}

	@Override
	public void actualizar(float deltaTiempo) {
		vistaMenu.actualizar(deltaTiempo);
	}

	@Override
	public void renderizar() {

		spriteBatch.begin();

		vistaMenu.renderizar();

		spriteBatch.end();
	}

	@Override
	public void dispose() {
		spriteBatch.dispose();
	}

}
