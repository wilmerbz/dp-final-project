package com.space.invaders.vistas;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.space.invaders.actores.ElementoTexto;
import com.space.invaders.entidades.menu.OpcionMenu;
import com.space.invaders.interfaces.vistas.IVistaEstadoJuego;
import com.space.invaders.recursos.texto.AdministradorTexto;
import com.space.invaders.recursos.texto.IAdministradorTexto;
import com.space.invaders.recursos.texto.NombreFuente;

public class VistaMenu implements IVistaEstadoJuego {

	private List<OpcionMenu> opcionesMenu;
	private String textoTitulo;
	private List<ElementoTexto> elementosTextoMenu;
	private BitmapFont fuenteElementoMenu;
	private BitmapFont fuenteElementoMenuSeleccionado;

	private ElementoTexto titulo;
	
	private final int distanciaPrimerElementoMenu = 200;
	private final int distanciaElementoMenu = 50;
	
	private IVistaEstadoJuego padre;
	
	public VistaMenu(IVistaEstadoJuego padre, String titulo) {
		this.padre = padre;
		this.textoTitulo = titulo;
	}


	public void inicializar() {
		titulo = new ElementoTexto(textoTitulo, NombreFuente.HYPER_SPACE, 100, Color.WHITE);
		float xTitulo = (padre.getWidth() - titulo.getWidth()) / 2;
		float yTitulo = padre.getHeight() - titulo.getHeight();
		titulo.setX(xTitulo);
		titulo.setY(yTitulo);

		IAdministradorTexto administradorTexto = AdministradorTexto.getInstancia();
		fuenteElementoMenu = administradorTexto.obtenerFuente(NombreFuente.HYPER_SPACE, 50, Color.WHITE);
		fuenteElementoMenuSeleccionado = administradorTexto.obtenerFuente(NombreFuente.HYPER_SPACE, 60, Color.SCARLET);
	}
	
	@Override
	public void actualizar(float deltaTiempo) {
		
	}

	public void setTitulo(String textoTitulo) {
		this.textoTitulo = textoTitulo;
		this.titulo.setTexto(textoTitulo);
	}
	
	/**
	 * Asigna las opciones del menu.
	 * @param opcionesMenu Opciones de menu.
	 */
	public void setOpcionesMenu(List<OpcionMenu> opcionesMenu) {

		this.opcionesMenu = opcionesMenu;
		elementosTextoMenu = new ArrayList<ElementoTexto>();
		
		if (opcionesMenu == null) {
			return;
		}
		
		float yElemento = titulo.getY() - titulo.getHeight() - distanciaPrimerElementoMenu;
		for (int indiceOpcion = 0; indiceOpcion < this.opcionesMenu.size(); indiceOpcion++) {
			OpcionMenu elemento = this.opcionesMenu.get(indiceOpcion);

			ElementoTexto elementoTexto = new ElementoTexto(elemento.getDescripcion(), fuenteElementoMenu);
			float xElemento = (padre.getWidth() - elementoTexto.getWidth()) / 2;
			elementoTexto.setX(xElemento);
			elementoTexto.setY(yElemento);
			elementosTextoMenu.add(elementoTexto);
			
			yElemento = yElemento - elementoTexto.getHeight() - distanciaElementoMenu;
		}

	}

	@Override
	public void dispose() {
		elementosTextoMenu=null;
	}


	@Override
	public float getWidth() {
		return padre.getWidth();
	}


	@Override
	public float getHeight() {
		return padre.getHeight();
	}


	@Override
	public void renderizar() {
		SpriteBatch spriteBatch = padre.getSpriteBatch();
		titulo.renderizar(spriteBatch);

		if (elementosTextoMenu == null || elementosTextoMenu.size() == 0) {
			return;
		}

		for (int i = 0; i < elementosTextoMenu.size(); i++) {
			OpcionMenu elementoMenu = this.opcionesMenu.get(i);
			ElementoTexto elementoTexto = this.elementosTextoMenu.get(i);

			BitmapFont fuente = fuenteElementoMenu;

			if (elementoMenu.isSeleccionado()) {
				fuente = fuenteElementoMenuSeleccionado;
			}
			
			if(fuente != elementoTexto.getFuente()) {
				elementoTexto.setFuente(fuente);
				
				float xElemento = (padre.getWidth() - elementoTexto.getWidth()) / 2;
				elementoTexto.setX(xElemento);
			}
			elementoTexto.renderizar(spriteBatch);
		}
	}


	@Override
	public SpriteBatch getSpriteBatch() {
		return padre.getSpriteBatch();
	}
	
}
