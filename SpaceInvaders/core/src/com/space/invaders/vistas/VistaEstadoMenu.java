package com.space.invaders.vistas;

import java.util.List;

import com.space.invaders.controladores.ControladorEstadoNivelCompletado;
import com.space.invaders.entidades.menu.OpcionMenu;
import com.space.invaders.interfaces.controladores.IControladorEstadoJuego;
import com.space.invaders.vistas.base.VistaEstadoJuego;

/**
 * Vista del Estado de Nivel Completado.
 */
public class VistaEstadoMenu extends VistaEstadoJuego {
	
	private VistaMenu vistaMenu;

	/**
	 * Crea una nueva instancia del estado del Menu Principal del juego.
	 * 
	 * @param controladorEstadoJuego
	 *            Controlador del estado del juego.
	 */
	public VistaEstadoMenu(IControladorEstadoJuego controladorEstadoJuego, String titulo) {
		super(controladorEstadoJuego);

		vistaMenu = new VistaMenu(this, titulo);
	}
	
	/**
	 * Asigna el titulo de la vista de menu.
	 * @return
	 */
	public void setTitulo(String titulo) {
		vistaMenu.setTitulo(titulo);
	}

	@Override
	public void inicializar() {
		super.inicializar();
		
		vistaMenu.inicializar();
	}

	/**
	 * Asigna las opciones del menu.
	 * 
	 * @param opcionesMenu
	 *            Opciones de menu.
	 */
	public void setOpcionesMenu(List<OpcionMenu> opcionesMenu) {
		vistaMenu.setOpcionesMenu(opcionesMenu);
	}

	@Override
	public void actualizar(float deltaTiempo) {
		vistaMenu.actualizar(deltaTiempo);
	}

	@Override
	public void renderizar() {

		spriteBatch.begin();

		vistaMenu.renderizar();

		spriteBatch.end();
	}

	@Override
	public void dispose() {
		spriteBatch.dispose();
	}

}
