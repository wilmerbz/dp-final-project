package com.space.invaders.actores;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Actor de tipo Imagen.
 */
public class ActorImagen extends Image implements Cloneable {

	/**
	 * Crea una nueva instancia de elemento de juego.
	 */
	public ActorImagen() {
		super();
	}

	/**
	 * Crea una nueva instancia de elemento de juego.
	 */
	public ActorImagen(Texture texture) {
		super(texture);
	}

	/*
	 * Implementación metodo para clonar un actor.
	 */
	@Override
	public ActorImagen clone() {
		ActorImagen copiaActorImagen = null;
		try {
			copiaActorImagen = (ActorImagen) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return copiaActorImagen;
	}
}
