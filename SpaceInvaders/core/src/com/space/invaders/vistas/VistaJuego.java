package com.space.invaders.vistas;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.space.invaders.actores.FondoInfinito;
import com.space.invaders.actores.iterator.IteradorGenerico;
import com.space.invaders.actores.iterator.IteradorListaGenerica;
import com.space.invaders.actores.naves.NaveEnemiga;
import com.space.invaders.actores.naves.NaveJugador;
import com.space.invaders.SpaceInvadersGame;
import com.space.invaders.actores.ElementoJuego;
import com.space.invaders.controladores.ControladorJuego;
import com.space.invaders.interfaces.controladores.IControladorEstadoJuego;
import com.space.invaders.recursos.texturas.AdministradorTexturas;
import com.space.invaders.recursos.texturas.NombreTextura;
import com.space.invaders.vistas.base.VistaEstadoJuego;

public class VistaJuego extends VistaEstadoJuego {

	private ControladorJuego controladorJuego;
	private SpriteBatch batch;
	private FondoInfinito background;
	private Texture panel;
	
	private final String rutaFuente = "fonts/Hyperspace Bold.ttf";
	private BitmapFont fuentePuntaje;
	private static GlyphLayout layoutPuntaje;
	
	private BitmapFont fuenteVidas;
	private static GlyphLayout layoutVidas;
	
	ShapeRenderer shapeRenderer;
	
	public VistaJuego(IControladorEstadoJuego controladorEstadoJuego) {
		super(controladorEstadoJuego);

		controladorJuego = (ControladorJuego) controladorEstadoJuego;
		batch = new SpriteBatch();
		batch.setProjectionMatrix(SpaceInvadersGame.camara.combined);
		
		//shapeRenderer = new ShapeRenderer();
		//shapeRenderer.setProjectionMatrix(SpaceInvadersGame.camara.combined);
		
		background = new FondoInfinito(NombreTextura.GAME_BACKGROUND);
		panel = AdministradorTexturas.getInstancia().obtenerTextura(NombreTextura.PANEL_JUGADOR_PERSONAJE_1);
	}

	@Override
	public void inicializar() {
		
		List<NaveEnemiga> navesEnemigas = controladorJuego.getNavesEnemigas();
		int cantidadEnemigosPorFila = controladorJuego.getCantidadEnemigosPorFila();
		float posicionInicialX = 0;
		float posicionInicialY = getHeight() - 50;
		float espacioX = 10;
		float espacioY = 10;
		
		float x = posicionInicialX;
		float y = posicionInicialY;
		
		IteradorGenerico<NaveEnemiga> iteradorNavesEnemigas = new IteradorListaGenerica<NaveEnemiga>(navesEnemigas);
		int indiceNaveEnemiga = 0;
		while (iteradorNavesEnemigas.hasNext()) {

			NaveEnemiga naveEnemiga = iteradorNavesEnemigas.next();
			 x +=  (naveEnemiga.getActor().getWidth() + espacioX);
			 
			 if(indiceNaveEnemiga % cantidadEnemigosPorFila == 0) {
				 y -= ((naveEnemiga.getActor().getHeight() + espacioY) * 2);
				 x = posicionInicialX;
			 }
			naveEnemiga.getActor().setPosition(x,y);
			indiceNaveEnemiga++;
		}
		
		NaveJugador naveJugador = controladorJuego.getNaveJugador();
		float xNaveJugador = (getWidth()/2) - (naveJugador.getActor().getWidth()/2);
		naveJugador.getActor().setX(xNaveJugador);
		naveJugador.getActor().setY(5);
		
		
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(rutaFuente));
		FreeTypeFontParameter fontParameter = new FreeTypeFontParameter();
		fontParameter.size = 25;
		fontParameter.color = Color.WHITE;
		fontParameter.shadowColor = Color.BLACK;
		fontParameter.shadowOffsetX = 1;
		fontParameter.shadowOffsetY = 1;
		fuentePuntaje = generator.generateFont(fontParameter);
		layoutPuntaje = new GlyphLayout();
		
		
		fontParameter.size = 30;
		fontParameter.color = Color.WHITE;
		
		fuenteVidas = generator.generateFont(fontParameter);
		layoutVidas = new GlyphLayout();

	}

	@Override
	public void actualizar(float deltaTiempo) {
		background.act(deltaTiempo);
	}

	@Override
	public void renderizar() {
		
		batch.begin();
		
		background.draw(batch, 1);
		
		List<ElementoJuego> elementosJuego = controladorJuego.getElementosJuego();
		IteradorGenerico<ElementoJuego> iteradorElementoJuego = new IteradorListaGenerica<ElementoJuego>(elementosJuego);
		
		while (iteradorElementoJuego.hasNext()) {
			ElementoJuego elementoJuego = iteradorElementoJuego.next();
			elementoJuego.renderizar(batch);
		}
		
		batch.draw(panel, 10, getHeight() - (panel.getHeight() + 10));
		
		long puntos = controladorJuego.getPuntos();
		layoutPuntaje.setText(fuentePuntaje, "$" + puntos);
		fuentePuntaje.draw(batch, layoutPuntaje, 205,getHeight()-75);
		
		int vidas = controladorJuego.getVidas();
		layoutVidas.setText(fuenteVidas, Integer.toString(vidas));
		fuenteVidas.draw(batch, layoutVidas, 135, getHeight()-70);
		
		batch.end();
		
//		Gdx.gl.glEnable(GL30.GL_BLEND);
//		Gdx.gl.glBlendFunc(GL30.GL_SRC_ALPHA, GL30.GL_ONE_MINUS_SRC_ALPHA);
//		
//		shapeRenderer.begin(com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled);
//		Color color = new Color(0, 0, 0, 0.5f);
//		shapeRenderer.setColor(color);
//		
//		shapeRenderer.rect(0,0,getWidth(),getHeight());
//		
//		shapeRenderer.end();
//		Gdx.gl.glDisable(GL30.GL_BLEND);
	}

	@Override
	public void dispose() {
		batch.dispose();
	}

}
