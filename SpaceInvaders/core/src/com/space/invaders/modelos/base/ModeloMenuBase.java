package com.space.invaders.modelos.base;

import java.util.ArrayList;
import java.util.List;

import com.space.invaders.entidades.menu.OpcionMenu;
import com.space.invaders.entidades.menu.OpcionMenuHoja;
import com.space.invaders.entidades.menu.OpcionSubMenu;
import com.space.invaders.interfaces.modelos.IModelo;
import com.space.invaders.navegacion.NombreEstado;

/**
 * Modelo del Menu Principal.
 */
public abstract class ModeloMenuBase implements IModelo{

	protected List<OpcionMenu> elementosMenuRaiz;
	protected List<OpcionMenu> elementosMenu;
	
	protected int indiceElementoMenuActual;
	protected OpcionMenu elementoMenuActual;
	
	/**
	 * Crea una nueva instancia del Modelo del Menu Principal.
	 */
	public ModeloMenuBase() {
		inicializar();
	}
	
	@Override
	public void inicializar() {
		if(elementosMenuRaiz != null)
			return;
		
		elementosMenuRaiz = inicializarOpcionesMenu();
		
		setElementosMenu(elementosMenuRaiz);
	}
	
	/**
	 * Inicializa las opciones de menu.
	 */
	protected abstract List<OpcionMenu> inicializarOpcionesMenu();
	
	/**
	 * Obtiene la lista de elementos de menu.
	 * @return Elementos de menu.
	 */
	public List<OpcionMenu> getElementosMenu()
	{
		return elementosMenu;
	}
	
	/**
	 * Asigna la lista de elementos de menu.
	 * @param elementosMenu Elementos de menu.
	 */
	public void setElementosMenu(List<OpcionMenu> elementosMenu)
	{
		indiceElementoMenuActual = 0;
		this.elementosMenu = elementosMenu;
		setElementoMenuActual();
	}

	/**
	 * Mueve la seleccion al siguiente elemento de menu.
	 */
	public void moverElementoSiguiente() {
		if(elementosMenu!=null && indiceElementoMenuActual< elementosMenu.size()-1) {
			indiceElementoMenuActual++;
		}
		setElementoMenuActual();
	}
	
	/**
	 * Mueve la seleccion al elemento de menu anterior.
	 */
	public void moverElementoAnterior() {
		if(indiceElementoMenuActual>0) {
			indiceElementoMenuActual--;
		}
		setElementoMenuActual();
	}
	
	/**
	 * Asigna el elemento de menu seleccionado.
	 */
	private void setElementoMenuActual() {
		if(elementoMenuActual!=null) {
			elementoMenuActual.setSeleccionado(false);
		}
		elementoMenuActual = elementosMenu.get(indiceElementoMenuActual);
		elementoMenuActual.setSeleccionado(true);
	}
	
	/**
	 * Obtiene el elemento de menu actual.
	 * @return Elemento de menu.
	 */
	public OpcionMenu getElementoMenuActual() {
		return elementoMenuActual;
	}
	
	@Override
	public void dispose() {
		elementosMenu = null;
		elementosMenuRaiz = null;
	}
	
	/**
	 * Valida si el elemento seleccionado actual es un submenu.
	 * @return Retorna true si el elemento actual es un submenu; de lo contrario retorna false.
	 */
	public boolean esSubMenu() {
		OpcionMenu elemento = getElementoMenuActual();
		boolean esSubMenu = elemento!=null && elemento instanceof OpcionSubMenu;
		return esSubMenu;
	}
	
	/**
	 * Carga las opciones del submenu seleccionado.
	 */
	public void cargarOpcionesSubMenu() {
		
		if(esSubMenu()) {
			OpcionSubMenu subMenu = (OpcionSubMenu) getElementoMenuActual();
			setElementosMenu(subMenu.getHijos());
		}
	}
	
	/**
	 * Carga las opciones del submenu seleccionado.
	 */
	public void cargarOpcionesPadre() {
		OpcionMenu elementoMenu = getElementoMenuActual();
		if(elementoMenu==null || elementoMenu.getOpcionMenuPadre() == null || elementoMenu.getOpcionMenuPadre().getOpcionMenuPadre() == null) {
			if(elementosMenu != elementosMenuRaiz) {
				setElementosMenu(elementosMenuRaiz);
			}
			return;
		}
		
		OpcionSubMenu subMenu = (OpcionSubMenu) elementoMenu.getOpcionMenuPadre().getOpcionMenuPadre();
		if(subMenu!=null) {
			setElementosMenu(subMenu.getHijos());
		}
	}

}