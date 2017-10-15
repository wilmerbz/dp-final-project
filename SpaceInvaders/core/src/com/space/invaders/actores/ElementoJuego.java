package com.space.invaders.actores;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.space.invaders.actores.direccion.DireccionX;
import com.space.invaders.actores.direccion.DireccionY;

/**
 * Representa un elemento que se pinta en el juego, utilizando una imagen.
 */
public abstract class ElementoJuego extends Image{

	private DireccionX direccionX;
	private DireccionY direccionY;

	/**
	 * Crea una nueva instancia de elemento de juego.
	 */
	public ElementoJuego() {
		super();
		
	}

	/**
	 * Crea una nueva instancia de elemento de juego.
	 */
	public ElementoJuego(Texture texture) {
		super(texture);
		
	}

	/**
	 * Actualiza el elemento de juego de acuerdo al cambio de tiempo.
	 * @param deltaTiempo Cambio de tiempo.
	 */
	public void actualizar(float deltaTiempo) {
		
	}

	/**
	 * Obtiene la direccion en X.
	 * @return Direccion en X
	 */
	public DireccionX getDireccionX() {
		return direccionX;
	}
	
	/**
	 * Obtiene la direccion en Y.
	 * @return Direccion en Y
	 */
	public DireccionY getDireccionY() {
		return direccionY;
	}
	
	/**
	 * Asigna la direccion en X.
	 * @param direccionX the direccionX to set
	 */
	public void setDireccionX(DireccionX direccionX) {
		this.direccionX = direccionX;
	}
	
	
	/**
	 * Asigna la direccion en Y.
	 * @param direccionY the direccionY to set
	 */
	public void setDireccionY(DireccionY direccionY) {
		this.direccionY = direccionY;
	}
	
	/**
	 * Asigna la nueva textura al elemento de juego.
	 * @param texturaNueva Nueva textura para el elemento de juego.
	 */
	public void setTextura(Texture texturaNueva) 
	{
		Sprite sprite = new Sprite(texturaNueva);
		SpriteDrawable spriteDrawable = new SpriteDrawable(sprite);
		this.setDrawable(spriteDrawable);
	}
	
}
