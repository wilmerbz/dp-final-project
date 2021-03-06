package com.space.invaders.modelos;

import java.util.ArrayList;
import java.util.List;

import com.space.invaders.entidades.menu.OpcionMenu;
import com.space.invaders.entidades.menu.OpcionMenuHoja;
import com.space.invaders.modelos.base.ModeloMenuBase;
import com.space.invaders.navegacion.NombreEstado;

public class ModeloMenuPausa extends ModeloMenuBase{
	
	@Override
	protected List<OpcionMenu> inicializarOpcionesMenu() {
		List<OpcionMenu> opcionesMenu  = new ArrayList<OpcionMenu>();
		OpcionMenuHoja continuar = new OpcionMenuHoja(NombreEstado.Continuar, "Continuar");
		OpcionMenuHoja reiniciar = new OpcionMenuHoja(NombreEstado.ReiniciarNivel, "Reiniciar");
		OpcionMenuHoja menuPrincipal = new OpcionMenuHoja(NombreEstado.MenuPrincipal, "Menú Principal");
		OpcionMenuHoja salir = new OpcionMenuHoja(NombreEstado.Salir, "Salir");
		
		opcionesMenu.add(continuar);
		opcionesMenu.add(reiniciar);
		opcionesMenu.add(menuPrincipal);
		opcionesMenu.add(salir);
		
		return opcionesMenu;
	}

}