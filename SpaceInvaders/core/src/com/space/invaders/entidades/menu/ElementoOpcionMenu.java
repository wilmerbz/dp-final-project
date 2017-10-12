package com.space.invaders.entidades.menu;

import com.space.invaders.navegacion.NombreRuta;

/**
 * Representa una opción del menú.
 * Nodo hoja de elementos de menú.
 */
public class ElementoOpcionMenu extends ElementoMenu {

	/**
	 * Crea una nueva instancia de opción de menú.
	 * @param nombreRuta Nombre de la ruta del controlador a ejecutar.
	 * @param descripcion Descripcion de la opción.
	 */
	public ElementoOpcionMenu(NombreRuta nombreRuta, String descripcion) {
		super(nombreRuta, descripcion);
		
	}

}