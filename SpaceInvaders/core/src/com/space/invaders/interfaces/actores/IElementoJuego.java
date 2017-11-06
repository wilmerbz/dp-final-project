package com.space.invaders.interfaces.actores;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Interfaz para los elementos del juego.
 */
public interface IElementoJuego {

	/**
	 * Actualiza el elemento de juego de acuerdo al cambio de tiempo.
	 * 
	 * @param deltaTiempo
	 *            Cambio de tiempo.
	 */
	void actualizar(float deltaTiempo);

	/**
	 * Renderiza el elemento.
	 * 
	 * @param batch
	 *            Sprite batch a utilizar.
	 */
	void renderizar(SpriteBatch batch);

	/**
	 * Obtiene la posicion en X del elemento.
	 * 
	 * @return Posicion en X del elemento.
	 */
	float getX();

	/**
	 * Asigna la posicion en X del elemento.
	 * 
	 * @param x
	 *            La posicion en X del elemento.
	 */
	void setX(float x);

	/**
	 * Obtiene la posicion en Y del elemento.
	 * 
	 * @return Posicion en Y del elemento.
	 */
	float getY();

	/**
	 * Asigna la posicion en Y del elemento.
	 * 
	 * @param y
	 *            La posicion en Y del elemento.
	 */
	void setY(float y);

	/**
	 * Obtiene el ancho del elemento.
	 * 
	 * @return Ancho del elemento.
	 */
	float getWidth();

	/**
	 * Obtiene el alto del elemento.
	 * 
	 * @return Alto del elemento.
	 */
	float getHeight();

	/**
	 * Asigna el ancho del elemento.
	 * 
	 * @param width
	 *            Ancho del elemento.
	 */
	void setWidth(float width);

	/**
	 * Asigna el alto del elemento.
	 * 
	 * @param height
	 *            Alto del elemento.
	 */
	void setHeight(float height);
}
