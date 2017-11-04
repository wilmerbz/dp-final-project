package com.space.invaders.entidades.menu;

import java.util.ArrayList;
import java.util.List;

import com.space.invaders.navegacion.NombreEstado;

/**
 * Elemento de submenu.
 */
public class SubMenu extends ElementoMenu {

	private List<ElementoMenu> hijos;
	
	/**
	 * Crea una nueva instancia del elemento de tipo submenu.	
	 * @param nombreEstado
	 * @param descripcion
	 */
	public SubMenu(NombreEstado nombreEstado, String descripcion) {
		super(nombreEstado, descripcion);
		hijos = new ArrayList<ElementoMenu>();
	}

	/**
	 * Obtiene la lista de hijos del elemento de menú.
	 * @return Hijos.
	 */
	public List<ElementoMenu> getHijos(){
		return hijos;
	}
	
	/**
	 * Agregar el elemento hijo.
	 * @param hijo Elemento hijo.
	 */
	public void agregarHijo(ElementoMenu hijo) {
		if(hijos.contains(hijo)) 
		{
			return;
		}
		
		hijo.setElementoMenuPadre(this);
		hijos.add(hijo);
	}
	
	/**
	 * Remueve el elemento hijo.
	 * @param hijo Elemento hijo.
	 */
	public void removerHijo(ElementoMenu hijo) {
		if(!hijos.contains(hijo)) 
		{
			return;
		}
		
		hijos.remove(hijo);
	}
	
}