package com.space.invaders.recursos.texturas;

import com.badlogic.gdx.graphics.Texture;

/***
 * Administra las texturas y permite reutilizarlas, por medio del patrón Flyweight.
 */
public interface IAdministradorTexturas {

	/**
	 * Obtiene una textura.
	 * @param textura Nombre de la textur a obtener.
	 * @return Textura.
	 */
	Texture obtenerTextura(String textura);
	
}
