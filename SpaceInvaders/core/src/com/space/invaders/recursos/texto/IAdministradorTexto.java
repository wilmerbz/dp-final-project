package com.space.invaders.recursos.texto;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

/**
 * Clase que administra la generacion de texto para ser pintado en el juego.
 * @author bravow
 *
 */
public interface IAdministradorTexto {
	
	/**
	 * Obtiene una fuenta para un nombre de fuente dado.
	 * @param nombreFuente Nombre de la fuente a utilizar.
	 * @param tamano Tamano del texto.
	 * @param color Color del texto.
	 * @return Fuente creada.
	 */
	BitmapFont obtenerFuente(String nombreFuente, int tamano, Color color);
	
	/**
	 * Obtiene una fuenta para un nombre de fuente dado.
	 * @param nombreFuente Nombre de la fuente a utilizar.
	 * @param tamano Tamano del texto.
	 * @param color Color del texto.
	 * @param colorSombra Color de sombra del texto.
	 * @return Fuente creada.
	 */
	BitmapFont obtenerFuente(String nombreFuente, int tamano, Color color, Color colorSombra);

	/**
	 * Obtiene una fuente configurada con los parametros dados.
	 * @param nombreFuente Nombre de la fuente a utilizar.
	 * @param parametros Parametros de la fuente.
	 * @return Fuente creada.
	 */
	BitmapFont obtenerFuente(String nombreFuente, FreeTypeFontParameter parametros);
	
	/**
	 * Crea un glifo que representa el texto con la fuente indicada.
	 * @param texto Texto representado por el glifo.
	 * @param fuente Fuente a utilizar para el gligo del texto.
	 * @return Glifo generado.
	 */
	GlyphLayout crearGlifoTexto(String texto, BitmapFont fuente);
	
}
