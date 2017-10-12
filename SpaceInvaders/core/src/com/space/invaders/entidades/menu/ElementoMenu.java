package com.space.invaders.entidades.menu;

import com.space.invaders.navegacion.NombreRuta;

/**
 * Representa un elemento de menu.
 * Clase base del composite de opciones de menu.
 */
public abstract class ElementoMenu {

	private String descripcion;
	
	private NombreRuta nombreRuta;
	
	private ElementoMenu elementoMenuPadre;

	/**
	 * Crea una nueva instancia de Elemento Menu.
	 * @param nombreRuta Nombre de la ruta del controlador a ejecutar.
	 * @param descripcion Descripcion de la opción.
	 */
	public ElementoMenu(NombreRuta nombreRuta, String descripcion) {
		super();
		this.nombreRuta = nombreRuta;
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene la descripcion.
	 * @return Descripcion.
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Obtiene el elemento de menú padre.
	 * @return Padre.
	 */
	public ElementoMenu getElementoMenuPadre() {
		return elementoMenuPadre;
	}

	/**
	 * Obtiene el nombre de la ruta del controlador a ejecutar.
	 * @return Nombre de la ruta.
	 */
	public NombreRuta getNombreRuta() {
		return nombreRuta;
	}

	/**
	 * Asigna la descripcion.
	 * @param descripcion Descripcion.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Asigna el elemento de menu padre.
	 * @param elementoMenuPadre Padre.
	 */
	public void setElementoMenuPadre(ElementoMenu elementoMenuPadre) {
		this.elementoMenuPadre = elementoMenuPadre;
	}

	/**
	 * Asigna el nombre de la ruta del controlador a ejecutar.
	 * @param nombreRuta Nombre de la ruta.
	 */
	public void setNombreRuta(NombreRuta nombreRuta) {
		this.nombreRuta = nombreRuta;
	}
	
	
	
}