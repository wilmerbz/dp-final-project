package com.space.invaders.entidades.menu;

import java.util.ArrayList;
import java.util.List;

import com.space.invaders.navegacion.NombreEstado;

/**
 * Elemento de submenu.
 */
public class OpcionSubMenu extends OpcionMenu {

	private List<OpcionMenu> hijos;
	
	/**
	 * Crea una nueva instancia del elemento de tipo submenu.	
	 * @param nombreEstado
	 * @param descripcion
	 */
	public OpcionSubMenu(NombreEstado nombreEstado, String descripcion) {
		super(nombreEstado, descripcion);
		hijos = new ArrayList<OpcionMenu>();
	}

	/**
	 * Obtiene la lista de hijos del elemento de menú.
	 * @return Hijos.
	 */
	public List<OpcionMenu> getHijos(){
		return hijos;
	}
	
	/**
	 * Agregar el elemento hijo.
	 * @param hijo Elemento hijo.
	 */
	public void agregarHijo(OpcionMenu hijo) {
		if(hijos.contains(hijo)) 
		{
			return;
		}
		
		hijo.setOpcionMenuPadre(this);
		hijos.add(hijo);
	}
	
	/**
	 * Remueve el elemento hijo.
	 * @param hijo Elemento hijo.
	 */
	public void removerHijo(OpcionMenu hijo) {
		if(!hijos.contains(hijo)) 
		{
			return;
		}
		
		hijos.remove(hijo);
	}
	
}