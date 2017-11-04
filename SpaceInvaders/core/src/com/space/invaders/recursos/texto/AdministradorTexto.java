package com.space.invaders.recursos.texto;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.space.invaders.recursos.texturas.AdministradorTexturas;
import com.space.invaders.recursos.texturas.IAdministradorTexturas;

/**
 * Clase que sirve de fachada para interactuar con las clases del framework para
 * el manejo de texto.
 */
public class AdministradorTexto implements IAdministradorTexto {

	private static IAdministradorTexto _instancia;
	private HashMap<String, FreeTypeFontGenerator> generadoresFuente;
	private final String FORMATO_RUTA_FUENTE = "fuentes/%s.ttf";

	/**
	 * Crea una nueva instancia del Administrador de Texto. Constructor privado para
	 * la implementación del patrón singleton.
	 */
	private AdministradorTexto() {
		generadoresFuente = new HashMap<String, FreeTypeFontGenerator>();
	}

	/**
	 * Obtiene la instancia unica del administrador de texto.
	 * 
	 * @return Administrador de texto.
	 */
	public synchronized static IAdministradorTexto getInstancia() {
		if (_instancia == null) {
			_instancia = new AdministradorTexto();
		}

		return _instancia;
	}

	@Override
	public BitmapFont obtenerFuente(String nombreFuente, FreeTypeFontParameter parametros) {

		FreeTypeFontGenerator generadorFuente = null;
		if(generadoresFuente.containsKey(nombreFuente)) {
			generadorFuente = generadoresFuente.get(nombreFuente);
		}else {
			String rutaFuente = String.format(FORMATO_RUTA_FUENTE, nombreFuente);
			generadorFuente = new FreeTypeFontGenerator(Gdx.files.internal(rutaFuente));
			generadoresFuente.put(nombreFuente, generadorFuente);
		}

		BitmapFont fuente = generadorFuente.generateFont(parametros);

		return fuente;
	}
	
	@Override
	public BitmapFont obtenerFuente(String nombreFuente, int tamano, Color color) {

		FreeTypeFontParameter fontParameter = new FreeTypeFontParameter();
		fontParameter.size = tamano;
		fontParameter.color = color;

		BitmapFont fuente = obtenerFuente(nombreFuente, fontParameter);

		return fuente;
	}
	
	@Override
	public BitmapFont obtenerFuente(String nombreFuente, int tamano, Color color, Color colorSombra) {

		FreeTypeFontParameter fontParameter = new FreeTypeFontParameter();
		fontParameter.size = tamano;
		fontParameter.color = color;
		fontParameter.shadowColor = colorSombra;
		fontParameter.shadowOffsetX = 1;
		fontParameter.shadowOffsetY = 1;

		BitmapFont fuente = obtenerFuente(nombreFuente, fontParameter);

		return fuente;
	}

	@Override
	public GlyphLayout crearGlifoTexto(String texto, BitmapFont fuente) {
		GlyphLayout glyphLayout = new GlyphLayout();
		glyphLayout.setText(fuente, texto);
		return glyphLayout;
	}

}
