package com.space.invaders.controladores;

import com.space.invaders.entidades.Jugador;
import com.space.invaders.interfaces.controladores.IControlador;
import com.space.invaders.interfaces.mensajes.IColega;
import com.space.invaders.interfaces.mensajes.IMediador;
import com.space.invaders.navegacion.AdministradorNavegacion;
import com.space.invaders.navegacion.NombreRuta;

public class ControladorMenuPrincipal implements IControlador, IColega {
	
	private IMediador mediador;
	
	@Override
	public void inicializar() {
		// TODO Auto-generated method stub
		System.out.println("Iniciando ControladorMenuPrincipal");
		//AdministradorNavegacion.getInstancia().navegar(NombreRuta.Juego);
		
		//Jugador jugador = new Jugador("Wilmer", "WBZ");
		//mediador.enviarMensaje(this, "This is a test message from MenuPrincipal: ", jugador);
	}

	@Override
	public void setMediador(IMediador mediador) {
		this.mediador = mediador;
	}

	@Override
	public void recibirMensaje(String mensaje, Object data) {
		// TODO Auto-generated method stub
	}

}
