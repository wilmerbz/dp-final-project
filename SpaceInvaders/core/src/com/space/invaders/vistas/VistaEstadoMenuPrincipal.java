package com.space.invaders.vistas;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.space.invaders.SpaceInvadersGame;
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
	private final String titulo = "Space Invaders";
	private final String rutaFuente = "fonts/Hyperspace Bold.ttf"; 
	private static GlyphLayout tituloGlyphLayout = new GlyphLayout();
	private GlyphLayout[] elementosMenuGlyphLayouts;
	private BitmapFont fuenteTitulo;
	private BitmapFont fuenteElementoMenu;
	private BitmapFont fuenteElementoMenuSeleccionado;
	
	private SpriteBatch spriteBatch;
	
	
	/**
	 * Crea una nueva instancia del estado del Menu Principal del juego.
	 * @param controladorEstadoJuego Controlador del estado del juego.
	 */
	public VistaEstadoMenuPrincipal(IControladorEstadoJuego controladorEstadoJuego) {
		super(controladorEstadoJuego);
		controlador = (ControladorEstadoMenuPrincipal)  controladorEstadoJuego;
	}

	@Override
	public void inicializar() {
		
		spriteBatch = new SpriteBatch();
		spriteBatch.setProjectionMatrix(SpaceInvadersGame.camara.combined);
		
		IAdministradorTexto administradorTexto = AdministradorTexto.getInstancia();
		
		fuenteTitulo = administradorTexto.obtenerFuente(NombreFuente.HYPER_SPACE, 100, Color.WHITE);
		tituloGlyphLayout = administradorTexto.crearGlifoTexto(titulo, fuenteTitulo);

		fuenteElementoMenu = administradorTexto.obtenerFuente(NombreFuente.HYPER_SPACE, 50, Color.WHITE);

		fuenteElementoMenuSeleccionado = administradorTexto.obtenerFuente(NombreFuente.HYPER_SPACE, 60, Color.SCARLET);
		
	}

	@Override
	public void actualizar(float deltaTiempo) {
		
	}

	private final int distanciaPrimerElementoMenu = 200;
	private final int distanciaElementoMenu= 50;
	
	@Override
	public void renderizar() {
		
		spriteBatch.begin();

		float xTitulo = (getWidth()-tituloGlyphLayout.width)/2;
		float yTitulo = getHeight() - tituloGlyphLayout.height;
		
		fuenteTitulo.draw(spriteBatch, tituloGlyphLayout, xTitulo,yTitulo);
		
		if(elementosMenuGlyphLayouts!=null && elementosMenuGlyphLayouts.length > 0) {
			float yElemento = yTitulo - tituloGlyphLayout.height - distanciaPrimerElementoMenu;
			for(int i = 0; i< elementosMenuGlyphLayouts.length; i++) {
				GlyphLayout layoutElemento = this.elementosMenuGlyphLayouts[i];
				
				BitmapFont fuente = fuenteElementoMenu;
				
				ElementoMenu elementoMenu = elementosMenu.get(i);
				if(elementoMenu.getSeleccionado()) {
					fuente = fuenteElementoMenuSeleccionado;
				}
				layoutElemento.setText(fuente, elementoMenu.getDescripcion());
				float xElemento = (getWidth()-layoutElemento.width)/2;
				fuente.draw(spriteBatch, layoutElemento, xElemento, yElemento);
				
				yElemento = yElemento - layoutElemento.height - distanciaElementoMenu;
			}
			
		}
		
		spriteBatch.end();
	}

	@Override
	public void dispose() {
		spriteBatch.dispose();
	}
	
	
	/**
	 * Asigna la lista de elementos de menú.
	 * @param elementosMenu
	 */
	public void setElementosMenu(List<ElementoMenu> elementosMenu) {
		this.elementosMenu = elementosMenu;
		if(elementosMenu==null)
		{
			elementosMenuGlyphLayouts =null;
			return;
		}
		
		IAdministradorTexto administradorTexto = AdministradorTexto.getInstancia();
		
		
		elementosMenuGlyphLayouts = new GlyphLayout[elementosMenu.size()];
		for(int i = 0; i< elementosMenu.size(); i++) {
			ElementoMenu elemento = this.elementosMenu.get(i);
			GlyphLayout layoutElemento = administradorTexto.crearGlifoTexto(elemento.getDescripcion(), fuenteElementoMenu);
			elementosMenuGlyphLayouts[i] = layoutElemento;
		}

	}
	
}
