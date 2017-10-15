package com.space.invaders.actores;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

/**
 * Representa un elemento que se pinta en el juego, utilizando una imagen.
 */
public abstract class ElementoJuego extends Image{

	
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
	 * Asigna la nueva textura al elemento de juego.
	 * @param texturaNueva Nueva textura para el elemento de juego.
	 */
	public void setTextura(Texture texturaNueva) 
	{
		Sprite sprite = new Sprite(texturaNueva);
		SpriteDrawable spriteDrawable = new SpriteDrawable(sprite);
		this.setDrawable(spriteDrawable);
	}
	
	/**
	 * Actualiza el elemento de juego de acuerdo al cambio de tiempo.
	 * @param deltaTiempo Cambio de tiempo.
	 */
	public void actualizar(float deltaTiempo) {
		
	}
	
}
