package com.space.invaders.controladores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.space.invaders.controladores.base.ControladorEstadoJuegoBase;
import com.space.invaders.navegacion.NombreEstado;
import com.space.invaders.vistas.VistaEstadoBienvenida;

/**
 * Controlador de la bienvenida del juego.
 */
public class ControladorEstadoBienvenida extends ControladorEstadoJuegoBase {

	protected VistaEstadoBienvenida vistaEstadoBienvenida;
	
	/**
	 * Crea una nueva instancia del controlador de la bienvenida del juego.
	 */
	public ControladorEstadoBienvenida() {
		vistaEstadoBienvenida = new VistaEstadoBienvenida(this);
		
	}
	
	@Override
	public void inicializar() {
		// TODO Auto-generated method stub
		System.out.println("Iniciando ControladorBienvenida");
		vistaEstadoBienvenida.inicializar();
		
	}

	@Override
	public void actualizar(float deltaTiempo) {
		vistaEstadoBienvenida.actualizar(deltaTiempo);
	}

	@Override
	public void renderizar() {
		vistaEstadoBienvenida.renderizar();
	}

	@Override
	public void manejarEntradas() {
		//vistaBienvenida.manejarEntradas();
		
		if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
			System.out.println("Enter! Navigate to Main Menu!");
			navegarControlador(NombreEstado.MenuPrincipal);
		}
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		vistaEstadoBienvenida.dispose();
	}

}