package com.space.invaders.modelos;

import java.util.ArrayList;
import java.util.List;

import com.space.invaders.entidades.menu.OpcionMenu;
import com.space.invaders.entidades.menu.OpcionMenuHoja;
import com.space.invaders.entidades.menu.OpcionSubMenu;
import com.space.invaders.modelos.base.ModeloMenuBase;
import com.space.invaders.navegacion.NombreEstado;

/**
 * Modelo del Menu Principal.
 */
public class ModeloMenuPrincipal extends ModeloMenuBase{
	
	/**
	 * Crea una nueva instancia del Modelo del Menu Principal.
	 */
	public ModeloMenuPrincipal() {
		inicializar();
	}

	@Override
	protected List<OpcionMenu> inicializarOpcionesMenu() {
		List<OpcionMenu> opcionesMenu  = new ArrayList<OpcionMenu>();
		OpcionSubMenu jugar = new OpcionSubMenu(NombreEstado.Juego, "Jugar");
		
		OpcionMenu nuevoJuego = new OpcionMenuHoja(NombreEstado.NuevoJuego, "Nuevo Juego");
		OpcionMenu cargarJuego = new OpcionMenuHoja(NombreEstado.CargarJuego, "Cargar Juego");
		OpcionMenu regresar = new OpcionMenuHoja(NombreEstado.Regresar, "< Regresar");
		
		jugar.agregarHijo(nuevoJuego);
		jugar.agregarHijo(cargarJuego);
		jugar.agregarHijo(regresar);
		
		OpcionMenu mejoresPuntajes = new OpcionMenuHoja(NombreEstado.MejoresPuntajes, "Mejores Puntajes");
		OpcionMenu instrucciones = new OpcionMenuHoja(NombreEstado.Instrucciones, "Instrucciones");
		OpcionMenu salir = new OpcionMenuHoja(NombreEstado.Salir, "Salir");
		
		opcionesMenu.add(jugar);
		opcionesMenu.add(mejoresPuntajes);
		opcionesMenu.add(instrucciones);
		opcionesMenu.add(salir);
		
		return opcionesMenu;
	}

}