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
	private List<ElementoTexto> elementosTextoMenu;
	private BitmapFont fuenteElementoMenu;
	private BitmapFont fuenteElementoMenuSeleccionado;

	private String textoTitulo;
	private String textoSubTitulo;
	private ElementoTexto titulo;
	private ElementoTexto subTitulo;

	private final int distanciaPrimerElementoMenu = 300;
	private final int distanciaElementoMenu = 50;

	private IVistaEstadoJuego padre;

	public VistaMenu(IVistaEstadoJuego padre, String titulo) {
		this.padre = padre;
		this.textoTitulo = titulo;
		textoSubTitulo = "";
		
		inicializar();
	}

	public void inicializar() {
		titulo = new ElementoTexto(textoTitulo, NombreFuente.DEFAULT, 100, Color.WHITE);
		subTitulo = new ElementoTexto(textoSubTitulo, NombreFuente.DEFAULT, 50, Color.LIGHT_GRAY);

		actualizarPosicionTitulo();
		actualizarPosicionSubTitulo();
		
		IAdministradorTexto administradorTexto = AdministradorTexto.getInstancia();
		fuenteElementoMenu = administradorTexto.obtenerFuente(NombreFuente.DEFAULT, 50, Color.WHITE);
		fuenteElementoMenuSeleccionado = administradorTexto.obtenerFuente(NombreFuente.DEFAULT, 60, Color.SCARLET);
	}

	@Override
	public void actualizar(float deltaTiempo) {

	}

	/**
	 * Asigna el titulo a mostrar.
	 * 
	 * @param texto
	 *            Titulo.
	 */
	public void setTitulo(String texto) {
		this.textoTitulo = texto;
		this.titulo.setTexto(textoTitulo);
		actualizarPosicionTitulo();
	}

	private void actualizarPosicionTitulo() {
		float x = (padre.getWidth() - titulo.getWidth()) / 2;
		float y = padre.getHeight() - (titulo.getHeight()*2);
		titulo.setX(x);
		titulo.setY(y);
	}

	/**
	 * Asigna el sub titulo a mostrar.
	 * 
	 * @param texto
	 *            Titulo.
	 */
	public void setSubTitulo(String texto) {
		this.textoSubTitulo = texto;
		this.subTitulo.setTexto(textoSubTitulo);
		this.actualizarPosicionSubTitulo();
	}
	
	private void actualizarPosicionSubTitulo() {
		float x = (padre.getWidth() - subTitulo.getWidth()) / 2;
		float y = titulo.getY() - titulo.getHeight() - (distanciaPrimerElementoMenu / 2);
		subTitulo.setX(x);
		subTitulo.setY(y);
	}

	/**
	 * Asigna las opciones del menu.
	 * 
	 * @param opcionesMenu
	 *            Opciones de menu.
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
		elementosTextoMenu = null;
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

		if (textoSubTitulo != null && textoSubTitulo != "") {
			subTitulo.renderizar(spriteBatch);
		}

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

			if (fuente != elementoTexto.getFuente()) {
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
