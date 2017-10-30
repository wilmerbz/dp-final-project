package com.space.invaders.vistas;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeBitmapFontData;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.space.invaders.SpaceInvadersGame;
import com.space.invaders.controladores.ControladorMenuPrincipal;
import com.space.invaders.entidades.menu.ElementoMenu;
import com.space.invaders.interfaces.controladores.IControladorEstadoJuego;
import com.space.invaders.vistas.base.VistaEstadoJuego;

/**
 * Vista del menu principal del juego.
 */
public class VistaMenuPrincipal extends VistaEstadoJuego {

	private ControladorMenuPrincipal controlador;
	
	private List<ElementoMenu> elementosMenu;
	private final String titulo = "Space Invaders";
	private final String rutaFuente = "fonts/Hyperspace Bold.ttf"; 
	private static GlyphLayout tituloGlyphLayout = new GlyphLayout();
	private GlyphLayout[] elementosMenuGlyphLayouts;
	private BitmapFont fuenteTitulo;
	private BitmapFont fuenteElementoMenu;
	private BitmapFont fuenteElementoMenuSeleccionado;
	
	private SpriteBatch spriteBatch;
	
	
	
	public VistaMenuPrincipal(IControladorEstadoJuego controladorEstadoJuego) {
		super(controladorEstadoJuego);
		controlador = (ControladorMenuPrincipal)  controladorEstadoJuego;
	}

	@Override
	public void inicializar() {
		
		spriteBatch = new SpriteBatch();
		spriteBatch.setProjectionMatrix(SpaceInvadersGame.camara.combined);
		
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(rutaFuente));
		FreeTypeFontParameter fontParameter = new FreeTypeFontParameter();
		fontParameter.size = 100;
		fontParameter.color = Color.WHITE;
		
		fuenteTitulo = generator.generateFont(fontParameter);
		tituloGlyphLayout.setText(fuenteTitulo, titulo);
		
		fontParameter = new FreeTypeFontParameter();
		fontParameter.size = 50;
		fontParameter.color = Color.WHITE;
		fuenteElementoMenu = generator.generateFont(fontParameter);
		
		fontParameter = new FreeTypeFontParameter();
		fontParameter.size = 60;
		fontParameter.color = Color.SCARLET;
		fuenteElementoMenuSeleccionado = generator.generateFont(fontParameter);
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
		elementosMenuGlyphLayouts = new GlyphLayout[elementosMenu.size()];
		for(int i = 0; i< elementosMenu.size(); i++) {
			ElementoMenu elemento = this.elementosMenu.get(i);
			GlyphLayout layoutElemento = new GlyphLayout();
			layoutElemento.setText(fuenteElementoMenu, elemento.getDescripcion());
			elementosMenuGlyphLayouts[i] = layoutElemento;
		}

	}
	
}
