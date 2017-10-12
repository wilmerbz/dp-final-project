package com.space.invaders.controladores;

import com.space.invaders.controladores.base.ControladorEstadoJuegoBase;
import com.space.invaders.entidades.Jugador;
import com.space.invaders.interfaces.controladores.IControlador;
import com.space.invaders.interfaces.controladores.IControladorEstadoJuego;
import com.space.invaders.interfaces.mensajes.IColega;
import com.space.invaders.interfaces.mensajes.IMediador;

public class ControladorJuego extends ControladorEstadoJuegoBase implements IColega{
	private int contadorVisualizaciones = 0;
	private IMediador mediador;
	@Override
	public void inicializar() {
		contadorVisualizaciones++;
		// TODO Auto-generated method stub
		System.out.println("Iniciando ControladorJuego: "+contadorVisualizaciones);
	}

	@Override
	public void setMediador(IMediador mediador) {
		// TODO Auto-generated method stub
		this.mediador = mediador;
	}

	@Override
	public void recibirMensaje(String mensaje, Object data) {
		// TODO Auto-generated method stub
		Jugador jugador = (Jugador) data;
		System.out.println("Mensaje recibido por ControladorJuego: "+ mensaje+ " - Nombre: "+jugador.getNombre() + " - Nickname: "+ jugador.getNickname());
	}

	@Override
	public void actualizar(float deltaTiempo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void renderizar() {
		// TODO Auto-generated method stub
		
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