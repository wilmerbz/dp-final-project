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
	
	private int indiceElementoMenuActual;
	private ElementoMenu elementoMenuActual;
	
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
		ElementoMenu salir = new ElementoOpcionMenu(NombreRuta.Salir, "Salir");
		
		elementosMenu.add(jugar);
		elementosMenu.add(mejoresPuntajes);
		elementosMenu.add(instrucciones);
		elementosMenu.add(salir);
		
		indiceElementoMenuActual = 0;
		setElementoMenuActual();
	}
	
	/**
	 * Obtiene la lista de elementos de menu.
	 * @return Elementos de menu.
	 */
	public List<ElementoMenu> getElementosMenu()
	{
		return elementosMenu;
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
	public ElementoMenu getElementoMenuActual() {
		return elementoMenuActual;
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}