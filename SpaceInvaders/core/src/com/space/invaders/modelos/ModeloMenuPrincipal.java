package com.space.invaders.modelos;

import java.util.ArrayList;
import java.util.List;

import com.space.invaders.entidades.menu.ElementoMenu;
import com.space.invaders.entidades.menu.ElementoOpcionMenu;
import com.space.invaders.interfaces.modelos.IModelo;
import com.space.invaders.navegacion.NombreRuta;

/**
 * Modelo del Menu Principal.
 */
public class ModeloMenuPrincipal implements IModelo{

	private List<ElementoMenu> elementosMenu;
	
	/**
	 * Crea una nueva instancia del Modelo del Menu Principal.
	 */
	public ModeloMenuPrincipal() {
		inicializar();
	}
	
	@Override
	public void inicializar() {
		// TODO Auto-generated method stub
		if(elementosMenu !=null)
			return;
		
		elementosMenu = new ArrayList<ElementoMenu>();
		
		ElementoMenu jugar = new ElementoOpcionMenu(NombreRuta.SeleccionarJugador, "Seleccionar Jugador");
		ElementoMenu mejoresPuntajes = new ElementoOpcionMenu(NombreRuta.MejoresPuntajes, "Mejores Puntajes");
		ElementoMenu instrucciones = new ElementoOpcionMenu(NombreRuta.Instrucciones, "Instrucciones");
		
		elementosMenu.add(jugar);
		elementosMenu.add(mejoresPuntajes);
		elementosMenu.add(instrucciones);
	}
	
	/**
	 * Obtiene la lista de elementos de menu.
	 * @return Elementos de menu.
	 */
	public List<ElementoMenu> getElementosMenu()
	{
		return elementosMenu;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
