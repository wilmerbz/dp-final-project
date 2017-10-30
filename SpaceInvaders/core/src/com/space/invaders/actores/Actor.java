package com.space.invaders.actores;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Actor extends Image implements Cloneable {

	/**
	 * Crea una nueva instancia de elemento de juego.
	 */
	public Actor() {
		super();
	}

	/**
	 * Crea una nueva instancia de elemento de juego.
	 */
	public Actor(Texture texture) {
		super(texture);

	}

	/*
	 * Implementación metodo para clonar un actor.
	 */
	@Override
	public Actor clone() {
		Actor copiaElemento = null;
		try {
			copiaElemento = (Actor) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return copiaElemento;
	}
}
