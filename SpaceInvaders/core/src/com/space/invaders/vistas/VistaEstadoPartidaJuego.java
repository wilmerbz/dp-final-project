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
import com.space.invaders.actores.ElementoImagen;
import com.space.invaders.controladores.ControladorEstadoPartidaJuego;
import com.space.invaders.interfaces.controladores.IControladorEstadoJuego;
import com.space.invaders.recursos.texto.AdministradorTexto;
import com.space.invaders.recursos.texto.IAdministradorTexto;
import com.space.invaders.recursos.texto.NombreFuente;
import com.space.invaders.recursos.texturas.AdministradorTexturas;
import com.space.invaders.recursos.texturas.NombreTextura;
import com.space.invaders.vistas.base.VistaEstadoJuego;

public class VistaEstadoPartidaJuego extends VistaEstadoJuego {

	private ControladorEstadoPartidaJuego controladorJuego;
	private FondoInfinito background;
	private Texture panel;
	
	private BitmapFont fuentePuntaje;
	private static GlyphLayout layoutPuntaje;
	
	private BitmapFont fuenteVidas;
	private static GlyphLayout layoutVidas;
	
	ShapeRenderer shapeRenderer;
	
	public VistaEstadoPartidaJuego(IControladorEstadoJuego controladorEstadoJuego) {
		super(controladorEstadoJuego);

		controladorJuego = (ControladorEstadoPartidaJuego) controladorEstadoJuego;

		//shapeRenderer = new ShapeRenderer();
		//shapeRenderer.setProjectionMatrix(SpaceInvadersGame.camara.combined);
		
		background = new FondoInfinito(NombreTextura.GAME_BACKGROUND);
		panel = AdministradorTexturas.getInstancia().obtenerTextura(NombreTextura.PANEL_JUGADOR_PERSONAJE_1);
	}

	@Override
	public void inicializar() {
		super.inicializar();
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
			 x +=  (naveEnemiga.getWidth() + espacioX);
			 
			 if(indiceNaveEnemiga % cantidadEnemigosPorFila == 0) {
				 y -= ((naveEnemiga.getHeight() + espacioY) * 2);
				 x = posicionInicialX;
			 }
			 
			naveEnemiga.setX(x);
			naveEnemiga.setY(y);
			indiceNaveEnemiga++;
		}
		
		NaveJugador naveJugador = controladorJuego.getNaveJugador();
		float xNaveJugador = (getWidth()/2) - (naveJugador.getWidth()/2);
		naveJugador.setX(xNaveJugador);
		naveJugador.setY(5);
		
		IAdministradorTexto administradorTexto = AdministradorTexto.getInstancia();
		
		fuentePuntaje = administradorTexto.obtenerFuente(NombreFuente.HYPER_SPACE, 25, Color.WHITE, Color.BLACK);
		
		layoutPuntaje = new GlyphLayout();

		fuenteVidas = administradorTexto.obtenerFuente(NombreFuente.HYPER_SPACE, 30, Color.WHITE, Color.BLACK);
		layoutVidas = new GlyphLayout();

	}

	@Override
	public void actualizar(float deltaTiempo) {
		background.act(deltaTiempo);
	}

	@Override
	public void renderizar() {
		
		spriteBatch.begin();
		
		background.draw(spriteBatch, 1);
		
		List<ElementoImagen> elementosJuego = controladorJuego.getElementosJuego();
		IteradorGenerico<ElementoImagen> iteradorElementoJuego = new IteradorListaGenerica<ElementoImagen>(elementosJuego);
		
		while (iteradorElementoJuego.hasNext()) {
			ElementoImagen elementoJuego = iteradorElementoJuego.next();
			elementoJuego.renderizar(spriteBatch);
		}
		
		spriteBatch.draw(panel, 10, getHeight() - (panel.getHeight() + 10));
		
		long puntos = controladorJuego.getPuntos();
		layoutPuntaje.setText(fuentePuntaje, "$" + puntos);
		fuentePuntaje.draw(spriteBatch, layoutPuntaje, 205,getHeight()-75);
		
		int vidas = controladorJuego.getVidas();
		layoutVidas.setText(fuenteVidas, Integer.toString(vidas));
		fuenteVidas.draw(spriteBatch, layoutVidas, 135, getHeight()-70);
		
		spriteBatch.end();
		
		//Menu pausa
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
		spriteBatch.dispose();
	}

}
