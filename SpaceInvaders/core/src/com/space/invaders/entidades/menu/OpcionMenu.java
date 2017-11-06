package com.space.invaders.entidades.menu;

import com.space.invaders.navegacion.NombreEstado;

/**
 * Representa una opcion de menu.
 * Clase base del composite de opciones de menu.
 */
public abstract class OpcionMenu {

	private String descripcion;
	
	private NombreEstado nombreEstado;
	
	private boolean seleccionado = false;
	
	private OpcionMenu opcionMenuPadre;

	/**
	 * Crea una nueva instancia de Elemento Menu.
	 * @param nombreEstado Nombre del estado a ejecutar.
	 * @param descripcion Descripcion de la opción.
	 */
	public OpcionMenu(NombreEstado nombreEstado, String descripcion) {
		super();
		this.nombreEstado = nombreEstado;
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
	public OpcionMenu getOpcionMenuPadre() {
		return opcionMenuPadre;
	}

	/**
	 * Obtiene el nombre del estado a ejecutar.
	 * @return Nombre del estado.
	 */
	public NombreEstado getNombreRuta() {
		return nombreEstado;
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
	public void setOpcionMenuPadre(OpcionMenu opcionMenuPadre) {
		this.opcionMenuPadre = opcionMenuPadre;
	}

	/**
	 * Asigna el nombre del estado a ejecutar.
	 * @param nombreEstado Nombre del estado.
	 */
	public void setNombreRuta(NombreEstado nombreEstado) {
		this.nombreEstado = nombreEstado;
	}

	/**
	 * Asigna el valor que indica si el elemento es el elemento activo.
	 * @param seleccionado
	 */
	public void setSeleccionado(boolean seleccionado) {
		this.seleccionado = seleccionado;
	}
	
	/**
	 * Obtiene el valor que indica si el elemento es el elemento activo.
	 * @return
	 */
	public boolean isSeleccionado() {
		return seleccionado;
	}
	
	
	
}