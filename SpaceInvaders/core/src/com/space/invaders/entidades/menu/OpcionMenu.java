package com.space.invaders.entidades.menu;

import com.space.invaders.navegacion.NombreEstado;

/**
 * Representa una opción del menú.
 * Nodo hoja de elementos de menú.
 */
public class OpcionMenu extends ElementoMenu {

	/**
	 * Crea una nueva instancia de opción de menú.
	 * @param nombreEstado Nombre del estado a ejecutar.
	 * @param descripcion Descripcion de la opción.
	 */
	public OpcionMenu(NombreEstado nombreEstado, String descripcion) {
		super(nombreEstado, descripcion);
		
	}

}