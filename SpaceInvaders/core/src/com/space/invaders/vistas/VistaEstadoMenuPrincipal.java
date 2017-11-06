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
import com.space.invaders.entidades.menu.ElementoMenu;
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

	private List<ElementoMenu> elementosMenu;
	private final String textoTitulo = "Space Invaders";
	private List<ElementoTexto> elementosTextoMenu;
	private BitmapFont fuenteTitulo;
	private BitmapFont fuenteElementoMenu;
	private BitmapFont fuenteElementoMenuSeleccionado;

	private ElementoTexto titulo;
	
	private final int distanciaPrimerElementoMenu = 200;
	private final int distanciaElementoMenu = 50;

	/**
	 * Crea una nueva instancia del estado del Menu Principal del juego.
	 * 
	 * @param controladorEstadoJuego
	 *            Controlador del estado del juego.
	 */
	public VistaEstadoMenuPrincipal(IControladorEstadoJuego controladorEstadoJuego) {
		super(controladorEstadoJuego);
		controlador = (ControladorEstadoMenuPrincipal) controladorEstadoJuego;
	}

	@Override
	public void inicializar() {
		super.inicializar();
		
		titulo = new ElementoTexto(textoTitulo, NombreFuente.HYPER_SPACE, 100, Color.WHITE);
		float xTitulo = (getWidth() - titulo.getWidth()) / 2;
		float yTitulo = getHeight() - titulo.getHeight();
		titulo.setX(xTitulo);
		titulo.setY(yTitulo);

		IAdministradorTexto administradorTexto = AdministradorTexto.getInstancia();
		fuenteElementoMenu = administradorTexto.obtenerFuente(NombreFuente.HYPER_SPACE, 50, Color.WHITE);
		fuenteElementoMenuSeleccionado = administradorTexto.obtenerFuente(NombreFuente.HYPER_SPACE, 60, Color.SCARLET);
	}

	@Override
	public void actualizar(float deltaTiempo) {

	}

	@Override
	public void renderizar() {

		spriteBatch.begin();

		titulo.renderizar(spriteBatch);

		if (elementosTextoMenu == null || elementosTextoMenu.size() == 0) {
			return;
		}

		for (int i = 0; i < elementosTextoMenu.size(); i++) {
			ElementoMenu elementoMenu = elementosMenu.get(i);
			ElementoTexto elementoTexto = this.elementosTextoMenu.get(i);

			BitmapFont fuente = fuenteElementoMenu;

			if (elementoMenu.isSeleccionado()) {
				fuente = fuenteElementoMenuSeleccionado;
			}
			
			if(fuente != elementoTexto.getFuente()) {
				elementoTexto.setFuente(fuente);
				
				float xElemento = (getWidth() - elementoTexto.getWidth()) / 2;
				elementoTexto.setX(xElemento);
			}

			elementoTexto.renderizar(spriteBatch);
		}

		spriteBatch.end();
	}

	@Override
	public void dispose() {
		spriteBatch.dispose();
	}

	/**
	 * Asigna la lista de elementos de menú.
	 * 
	 * @param elementosMenu
	 */
	public void setElementosMenu(List<ElementoMenu> elementosMenu) {
		this.elementosMenu = elementosMenu;
		elementosTextoMenu = new ArrayList<ElementoTexto>();
		
		if (elementosMenu == null) {
			return;
		}
		
		float yElemento = titulo.getY() - titulo.getHeight() - distanciaPrimerElementoMenu;
		for (int i = 0; i < elementosMenu.size(); i++) {
			ElementoMenu elemento = this.elementosMenu.get(i);

			ElementoTexto elementoTexto = new ElementoTexto(elemento.getDescripcion(), fuenteElementoMenu);
			float xElemento = (getWidth() - elementoTexto.getWidth()) / 2;
			elementoTexto.setX(xElemento);
			elementoTexto.setY(yElemento);
			elementosTextoMenu.add(elementoTexto);
			
			yElemento = yElemento - elementoTexto.getHeight() - distanciaElementoMenu;
		}

	}

}
