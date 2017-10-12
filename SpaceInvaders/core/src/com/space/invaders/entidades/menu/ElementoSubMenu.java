package com.space.invaders.entidades.menu;

import java.util.ArrayList;
import java.util.List;

import com.space.invaders.navegacion.NombreRuta;

/**
 * Elemento de submenu.
 */
public class ElementoSubMenu extends ElementoMenu {

	private List<ElementoMenu> hijos;
	
	/**
	 * Crea una nueva instancia del elemento de tipo submenu.	
	 * @param nombreRuta
	 * @param descripcion
	 */
	public ElementoSubMenu(NombreRuta nombreRuta, String descripcion) {
		super(nombreRuta, descripcion);
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
