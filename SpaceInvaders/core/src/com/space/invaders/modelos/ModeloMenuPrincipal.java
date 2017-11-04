package com.space.invaders.modelos;

import java.util.ArrayList;
import java.util.List;

import com.space.invaders.entidades.menu.ElementoMenu;
import com.space.invaders.entidades.menu.OpcionMenu;
import com.space.invaders.entidades.menu.SubMenu;
import com.space.invaders.interfaces.modelos.IModelo;
import com.space.invaders.navegacion.NombreEstado;

/**
 * Modelo del Menu Principal.
 */
public class ModeloMenuPrincipal implements IModelo{

	private List<ElementoMenu> elementosMenuRaiz;
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
		if(elementosMenuRaiz != null)
			return;
		
		elementosMenuRaiz = new ArrayList<ElementoMenu>();
		
		SubMenu jugar = new SubMenu(NombreEstado.Juego, "Jugar");
		
		ElementoMenu nuevoJuego = new OpcionMenu(NombreEstado.NuevoJuego, "Nuevo Juego");
		ElementoMenu cargarJuego = new OpcionMenu(NombreEstado.CargarJuego, "Cargar Juego");
		ElementoMenu regresar = new OpcionMenu(NombreEstado.Regresar, "< Regresar");
		
		jugar.agregarHijo(nuevoJuego);
		jugar.agregarHijo(cargarJuego);
		jugar.agregarHijo(regresar);
		
		ElementoMenu mejoresPuntajes = new OpcionMenu(NombreEstado.MejoresPuntajes, "Mejores Puntajes");
		ElementoMenu instrucciones = new OpcionMenu(NombreEstado.Instrucciones, "Instrucciones");
		ElementoMenu salir = new OpcionMenu(NombreEstado.Salir, "Salir");
		
		elementosMenuRaiz.add(jugar);
		elementosMenuRaiz.add(mejoresPuntajes);
		elementosMenuRaiz.add(instrucciones);
		elementosMenuRaiz.add(salir);
		
		setElementosMenu(elementosMenuRaiz);
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
	 * Asigna la lista de elementos de menu.
	 * @param elementosMenu Elementos de menu.
	 */
	public void setElementosMenu(List<ElementoMenu> elementosMenu)
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
	public ElementoMenu getElementoMenuActual() {
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
		ElementoMenu elemento = getElementoMenuActual();
		boolean esSubMenu = elemento!=null && elemento instanceof SubMenu;
		return esSubMenu;
	}
	
	/**
	 * Carga las opciones del submenu seleccionado.
	 */
	public void cargarOpcionesSubMenu() {
		
		if(esSubMenu()) {
			SubMenu subMenu = (SubMenu) getElementoMenuActual();
			setElementosMenu(subMenu.getHijos());
		}
	}
	
	/**
	 * Carga las opciones del submenu seleccionado.
	 */
	public void cargarOpcionesPadre() {
		ElementoMenu elementoMenu = getElementoMenuActual();
		if(elementoMenu==null || elementoMenu.getElementoMenuPadre() == null || elementoMenu.getElementoMenuPadre().getElementoMenuPadre() == null) {
			if(elementosMenu != elementosMenuRaiz) {
				setElementosMenu(elementosMenuRaiz);
			}
			return;
		}
		
		SubMenu subMenu = (SubMenu) elementoMenu.getElementoMenuPadre().getElementoMenuPadre();
		if(subMenu!=null) {
			setElementosMenu(subMenu.getHijos());
		}
	}

}