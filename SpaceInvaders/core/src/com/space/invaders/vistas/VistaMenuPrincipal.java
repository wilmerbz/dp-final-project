package com.space.invaders.vistas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeBitmapFontData;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.space.invaders.SpaceInvadersGame;
import com.space.invaders.interfaces.controladores.IControladorEstadoJuego;
import com.space.invaders.vistas.base.VistaEstadoJuego;

/**
 * Vista del menu principal del juego.
 */
public class VistaMenuPrincipal extends VistaEstadoJuego {

	private SpriteBatch spriteBatch;
	private BitmapFont fuenteTitulo;
	private BitmapFont fuenteElementosMenu;
	
	private final String titulo = "Space Invaders";
	private final String rutaFuente = "fonts/Hyperspace Bold.ttf"; 
	private static GlyphLayout glyphLayout = new GlyphLayout();
	
	public VistaMenuPrincipal(IControladorEstadoJuego controladorEstadoJuego) {
		super(controladorEstadoJuego);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void inicializar() {
		spriteBatch = new SpriteBatch();
		
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(rutaFuente));
		FreeTypeFontParameter fontParameter = new FreeTypeFontParameter();
		fontParameter.size = 60;
		fontParameter.color = Color.WHITE;
		fuenteTitulo = generator.generateFont(fontParameter);
		
		glyphLayout.setText(fuenteTitulo, titulo);
		
	}

	@Override
	public void actualizar(float deltaTiempo) {
		
		
	}

	@Override
	public void renderizar() {
		spriteBatch.setProjectionMatrix(SpaceInvadersGame.camara.combined);
		spriteBatch.begin();

		fuenteTitulo.draw(spriteBatch, glyphLayout, (SpaceInvadersGame.WIDTH-glyphLayout.width)/2, 500);
		
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

}
