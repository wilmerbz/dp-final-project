package com.space.invaders.actores;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Representa un elemento que se pinta en el juego, utilizando una imagen.
 */
public abstract class ElementoJuego extends Image{

	/**
	 * Crea una nueva instancia de elemento de juego.
	 */
	public ElementoJuego(Texture texture) {
		super(texture);
		
		//Texture texture = new Texture("images/logo.png");
		//Image image = new Image(texture);
		//setDrawable(texture);
	}
	
}
