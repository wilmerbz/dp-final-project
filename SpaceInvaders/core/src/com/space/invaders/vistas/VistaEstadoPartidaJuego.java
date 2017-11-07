package com.space.invaders.vistas;

import java.util.List;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.space.invaders.actores.FondoInfinito;
import com.space.invaders.entidades.Nivel;
import com.space.invaders.entidades.iterador.IteradorGenerico;
import com.space.invaders.entidades.iterador.IteradorListaGenerica;
import com.space.invaders.actores.naves.NaveEnemiga;
import com.space.invaders.actores.naves.NaveJugador;
import com.space.invaders.SpaceInvadersGame;
import com.space.invaders.actores.ElementoImagen;
import com.space.invaders.actores.ElementoTexto;
import com.space.invaders.controladores.ControladorEstadoPartidaJuego;
import com.space.invaders.entidades.menu.OpcionMenu;
import com.space.invaders.interfaces.controladores.IControladorEstadoJuego;
import com.space.invaders.recursos.texto.NombreFuente;
import com.space.invaders.recursos.texturas.AdministradorTexturas;
import com.space.invaders.recursos.texturas.NombreTextura;
import com.space.invaders.vistas.base.VistaEstadoJuego;

public class VistaEstadoPartidaJuego extends VistaEstadoJuego {

	private ControladorEstadoPartidaJuego controladorJuego;
	private Texture panelJugador;
	private ElementoTexto puntaje;
	private ElementoTexto vidas;
	private ElementoTexto tituloNivel;
	private ElementoTexto nivel;
	
	private VistaMenu vistaMenu;
	private final String textoTituloPausa = "Pausa";
	ShapeRenderer shapeRenderer;
	
	public VistaEstadoPartidaJuego(IControladorEstadoJuego controladorEstadoJuego) {
		super(controladorEstadoJuego);

		controladorJuego = (ControladorEstadoPartidaJuego) controladorEstadoJuego;

		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(SpaceInvadersGame.getCamara().combined);
		
		panelJugador = AdministradorTexturas.getInstancia().obtenerTextura(NombreTextura.PANEL_JUGADOR_PERSONAJE_1);
		
		vistaMenu = new VistaMenu(this, textoTituloPausa);
	}

	@Override
	public void inicializar() {
		super.inicializar();
		
		List<NaveEnemiga> navesEnemigas = controladorJuego.getNavesEnemigas();
		int cantidadEnemigosPorFila = controladorJuego.getCantidadEnemigosPorFila();
		float posicionInicialX = 0;
		float posicionInicialY = getHeight() - 50;
		float espacioX = 20;
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
		
		vidas = new ElementoTexto("0", NombreFuente.DEFAULT, 30, Color.WHITE, Color.BLACK);
		vidas.setX(150);
		vidas.setY(getHeight()-70);
		
		puntaje = new ElementoTexto("0", NombreFuente.DEFAULT, 25, Color.WHITE, Color.BLACK);
		puntaje.setX(240);
		puntaje.setY(getHeight()-70);
		
		tituloNivel = new ElementoTexto("nivel", NombreFuente.DEFAULT, 15, Color.WHITE);
		tituloNivel.setX(380);
		tituloNivel.setY(getHeight()-40);
		
		nivel = new ElementoTexto("1", NombreFuente.DEFAULT, 35, Color.WHITE, Color.BLACK);
		nivel.setX(390);
		nivel.setY(getHeight()-60);
		
		vistaMenu.inicializar();
	}

	@Override
	public void actualizar(float deltaTiempo) {
		
		long puntos = controladorJuego.getPuntos();
		puntaje.setTexto("$" + puntos);
		
		int cantidadVidas = controladorJuego.getVidas();
		vidas.setTexto(Integer.toString(cantidadVidas));
		
		Nivel nivelActual = controladorJuego.getNivelActual();
		nivel.setTexto(Integer.toString(nivelActual.getNumero()));
		
		if(controladorJuego.isPausado()) {
			vistaMenu.actualizar(deltaTiempo);
		}
		
	}

	@Override
	public void renderizar() {
		
		spriteBatch.begin();
		
		List<ElementoImagen> elementosJuego = controladorJuego.getElementosJuego();
		IteradorGenerico<ElementoImagen> iteradorElementoJuego = new IteradorListaGenerica<ElementoImagen>(elementosJuego);
		
		while (iteradorElementoJuego.hasNext()) {
			ElementoImagen elementoJuego = iteradorElementoJuego.next();
			elementoJuego.renderizar(spriteBatch);
		}
		
		spriteBatch.draw(panelJugador, 10, getHeight() - (panelJugador.getHeight() + 10));
		
		puntaje.renderizar(spriteBatch);
		vidas.renderizar(spriteBatch);
		
		tituloNivel.renderizar(spriteBatch);
		nivel.renderizar(spriteBatch);
		
		spriteBatch.end();
		
		if(controladorJuego.isPausado()) {
			//Menu pausa			
			Gdx.gl.glEnable(GL30.GL_BLEND);
			Gdx.gl.glBlendFunc(GL30.GL_SRC_ALPHA, GL30.GL_ONE_MINUS_SRC_ALPHA);
			
			shapeRenderer.begin(com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled);
			Color color = new Color(0, 0, 0, 0.5f);
			shapeRenderer.setColor(color);
			
			shapeRenderer.rect(0,0,getWidth(),getHeight());
			
			shapeRenderer.end();
			Gdx.gl.glDisable(GL30.GL_BLEND);
			
			spriteBatch.begin();
			if(controladorJuego.isPausado()) {
				vistaMenu.renderizar();
			}
			spriteBatch.end();
		}
		

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
	public void dispose() {
		spriteBatch.dispose();
	}

}
