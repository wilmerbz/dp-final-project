package com.space.invaders.controladores;

import com.space.invaders.controladores.base.ControladorEstadoJuegoBase;
import com.space.invaders.vistas.VistaBienvenida;

public class ControladorBienvenida extends ControladorEstadoJuegoBase {

	protected VistaBienvenida vistaBienvenida;
	
	/**
	 * Crea una nueva instancia del controlador de la bienvenida del juego.
	 */
	public ControladorBienvenida() {
		vistaBienvenida = new VistaBienvenida(this);
		
	}
	
	@Override
	public void inicializar() {
		// TODO Auto-generated method stub
		System.out.println("Iniciando ControladorBienvenida");
		vistaBienvenida.inicializar();
		
	}

	@Override
	public void actualizar(float deltaTiempo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void renderizar() {
		vistaBienvenida.renderizar();
	}

	@Override
	public void manejarEntradas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
