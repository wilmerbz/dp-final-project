package com.space.invaders.actores;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.space.invaders.interfaces.actores.IElementoJuego;
import com.space.invaders.recursos.texto.AdministradorTexto;
import com.space.invaders.recursos.texto.IAdministradorTexto;
import com.space.invaders.recursos.texto.NombreFuente;

/**
 * Representa un elemento de texto del juego.
 */
public class ElementoTexto implements IElementoJuego {

	private String texto;
	private int tamano;
	private Color color;
	private Color colorSombra;

	private float x;
	private float y;

	private String nombreFuente;
	private BitmapFont fuente;
	private GlyphLayout glyphLayout;

	/**
	 * Crea un nuevo elemento de juego.
	 * 
	 * @param texto
	 *            Texto del elemento.
	 * @param fuente
	 *            Fuente.
	 */
	public ElementoTexto(String texto, BitmapFont fuente) {
		super();
		this.texto = texto;
		this.fuente = fuente;
		inicializar();
	}

	/**
	 * Crea un nuevo elemento de texto.
	 * 
	 * @param texto
	 *            Texto del elemento.
	 * @param nombreFuente
	 *            Nombre de la fuente.
	 * @param tamano
	 *            Tamano del texto.
	 * @param color
	 *            Color del texto.
	 */
	public ElementoTexto(String texto, String nombreFuente, int tamano, Color color) {
		this.texto = texto;
		this.nombreFuente = nombreFuente;
		this.tamano = tamano;
		this.color = color;
		inicializar();
	}

	/**
	 * Crea un nuevo elemento de texto.
	 * 
	 * @param texto
	 *            Texto del elemento.
	 * @param nombreFuente
	 *            Nombre de la fuente.
	 * @param tamano
	 *            Tamano del texto.
	 * @param color
	 *            Color del texto.
	 * @param colorSombra
	 *            Color de sombra del texto.
	 */
	public ElementoTexto(String texto, String nombreFuente, int tamano, Color color, Color colorSombra) {
		this.texto = texto;
		this.nombreFuente = nombreFuente;
		this.tamano = tamano;
		this.color = color;
		this.colorSombra = colorSombra;
		inicializar();
	}

	public void inicializar() {

		IAdministradorTexto administradorTexto = AdministradorTexto.getInstancia();

		if (fuente == null) {
			if (colorSombra != null) {
				fuente = administradorTexto.obtenerFuente(nombreFuente, tamano, color, colorSombra);
			} else {
				fuente = administradorTexto.obtenerFuente(nombreFuente, tamano, color);
			}
		}

		glyphLayout = administradorTexto.crearGlifoTexto(texto, fuente);
	}

	@Override
	public void actualizar(float deltaTiempo) {

	}

	@Override
	public void renderizar(SpriteBatch spriteBatch) {
		fuente.draw(spriteBatch, glyphLayout, getX(), getY());
	}

	/**
	 * Obtiene el texto del elemento.
	 * 
	 * @return Texto del elemento.
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * Asigna el texto del elemento.
	 * 
	 * @param texto
	 *            Texto a asignar.
	 */
	public void setTexto(String texto) {
		this.texto = texto;
		glyphLayout.setText(fuente, texto);
	}

	/**
	 * Obtiene el tamano del texto.
	 * 
	 * @return Tamano del texto.
	 */
	public int getTamano() {
		return tamano;
	}

	/**
	 * Asgigna el tamano del texto.
	 * 
	 * @param tamano
	 *            Tamano del texto.
	 */
	public void setTamano(int tamano) {
		this.tamano = tamano;
	}

	/**
	 * Obtiene el color del texto.
	 * 
	 * @return Color del texto.
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Asigna el color del texto.
	 * 
	 * @param Color
	 *            del texto.
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * Obtiene el color de la sombra del texto.
	 * 
	 * @return Color de la sombra del texto.
	 */
	public Color getColorSombra() {
		return colorSombra;
	}

	/**
	 * Asigna el color de la sombra del texto.
	 * 
	 * @param colorSombra
	 *            Color de la sombra del texto.
	 */
	public void setColorSombra(Color colorSombra) {
		this.colorSombra = colorSombra;
	}

	@Override
	public float getX() {
		return x;
	}

	@Override
	public void setX(float x) {
		this.x = x;
	}

	@Override
	public float getY() {
		return y;
	}

	@Override
	public void setY(float y) {
		this.y = y;
	}

	@Override
	public float getWidth() {
		return glyphLayout.width;
	}

	@Override
	public float getHeight() {
		// TODO Auto-generated method stub
		return glyphLayout.height;
	}

	@Override
	public void setWidth(float width) {
		glyphLayout.width = width;
	}

	@Override
	public void setHeight(float height) {
		glyphLayout.height = height;
	}

	

	/**
	 * Obtiene la fuente del elemento.
	 * @return Fuente.
	 */
	public BitmapFont getFuente() {
		return fuente;
	}

	/**
	 * Asigna la fuente del elemento.
	 * @param fuente Fuente.
	 */
	public void setFuente(BitmapFont fuente) {
		this.fuente = fuente;
		glyphLayout.setText(fuente, texto);
	}
	
}
