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
import com.space.invaders.SpaceInvadersGame;
import com.space.invaders.entidades.menu.ElementoMenu;
import com.space.invaders.interfaces.controladores.IControladorEstadoJuego;
import com.space.invaders.vistas.base.VistaEstadoJuego;

/**
 * Vista del menu principal del juego.
 */
public class VistaMenuPrincipal extends VistaEstadoJuego {

	private List<ElementoMenu> elementosMenu;
	private GlyphLayout[] elementosMenuGlyphLayouts;

	private SpriteBatch spriteBatch;
	private BitmapFont fuenteTitulo;
	private BitmapFont fuenteElementosMenu;
	
	private final String titulo = "Space Invaders";
	private final String rutaFuente = "fonts/Hyperspace Bold.ttf"; 
	private static GlyphLayout glyphLayoutTitulo = new GlyphLayout();
	
	public VistaMenuPrincipal(IControladorEstadoJuego controladorEstadoJuego) {
		super(controladorEstadoJuego);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void inicializar() {
		spriteBatch = new SpriteBatch();
		
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(rutaFuente));
		FreeTypeFontParameter fontParameter = new FreeTypeFontParameter();
		fontParameter.size = 100;
		fontParameter.color = Color.WHITE;
		
		fuenteTitulo = generator.generateFont(fontParameter);
		
		fontParameter = new FreeTypeFontParameter();
		fontParameter.size = 50;
		fontParameter.color = Color.WHITE;
		fuenteElementosMenu = generator.generateFont(fontParameter);
		
		glyphLayoutTitulo.setText(fuenteTitulo, titulo);
		
	}

	@Override
	public void actualizar(float deltaTiempo) {
		
		
	}

	@Override
	public void renderizar() {
		spriteBatch.setProjectionMatrix(SpaceInvadersGame.camara.combined);
		spriteBatch.begin();

		float xTitulo = (SpaceInvadersGame.WIDTH-glyphLayoutTitulo.width)/2;
		float yTitulo = SpaceInvadersGame.HEIGHT - glyphLayoutTitulo.height;
		
		fuenteTitulo.draw(spriteBatch, glyphLayoutTitulo, xTitulo,yTitulo);
		
		if(elementosMenuGlyphLayouts!=null && elementosMenuGlyphLayouts.length > 0) {
			float yElemento = yTitulo - glyphLayoutTitulo.height - 500;
			for(int i = 0; i< elementosMenuGlyphLayouts.length; i++) {
				GlyphLayout layoutElemento = this.elementosMenuGlyphLayouts[i];
				float xElemento = (SpaceInvadersGame.WIDTH-layoutElemento.width)/2;
				
				fuenteElementosMenu.draw(spriteBatch, layoutElemento, xElemento, yElemento);
				
				yElemento-= layoutElemento.height - 100;
			}
			
		}
		
		spriteBatch.end();
	}

	@Override
	public void manejarEntradas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
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
			layoutElemento.setText(fuenteElementosMenu, elemento.getDescripcion());
			elementosMenuGlyphLayouts[i] = layoutElemento;
		}
		
		
	}

}
