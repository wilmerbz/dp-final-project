package com.space.invaders.modelos;

import java.util.ArrayList;
import java.util.List;

import com.space.invaders.entidades.menu.OpcionMenu;
import com.space.invaders.entidades.menu.OpcionMenuHoja;
import com.space.invaders.modelos.base.ModeloMenuBase;
import com.space.invaders.navegacion.NombreEstado;

public class ModeloMenuNivelCompletado extends ModeloMenuBase{
	
	@Override
	protected List<OpcionMenu> inicializarOpcionesMenu() {
		List<OpcionMenu> opcionesMenu  = new ArrayList<OpcionMenu>();
		
		OpcionMenuHoja siguienteNivel = new OpcionMenuHoja(NombreEstado.SiguienteNivel, "Siguiente Nivel");
		OpcionMenuHoja reiniciarNivel = new OpcionMenuHoja(NombreEstado.ReiniciarNivel, "Reiniciar Nivel");
		OpcionMenuHoja menuPrincipal = new OpcionMenuHoja(NombreEstado.MenuPrincipal, "Menu Principal");
		OpcionMenuHoja salir = new OpcionMenuHoja(NombreEstado.Salir, "Salir");
		
		opcionesMenu.add(siguienteNivel);
		opcionesMenu.add(reiniciarNivel);
		opcionesMenu.add(menuPrincipal);
		opcionesMenu.add(salir);
		
		
		return opcionesMenu;
	}

}
