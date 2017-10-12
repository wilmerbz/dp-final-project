package com.space.invaders.controladores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.space.invaders.controladores.base.ControladorEstadoJuegoBase;
import com.space.invaders.entidades.Jugador;
import com.space.invaders.interfaces.controladores.IControlador;
import com.space.invaders.interfaces.mensajes.IColega;
import com.space.invaders.interfaces.mensajes.IMediador;
import com.space.invaders.modelos.ModeloMenuPrincipal;
import com.space.invaders.navegacion.AdministradorNavegacion;
import com.space.invaders.navegacion.NombreRuta;
import com.space.invaders.vistas.VistaMenuPrincipal;

public class ControladorMenuPrincipal extends ControladorEstadoJuegoBase implements IColega {
	
	private IMediador mediador;
	private VistaMenuPrincipal vistaMenuPrincipal;
	private ModeloMenuPrincipal modeloMenuPrincipal;
	
	public ControladorMenuPrincipal() {
		vistaMenuPrincipal = new VistaMenuPrincipal(this);	
		modeloMenuPrincipal = new ModeloMenuPrincipal();
	}
	
	@Override
	public void inicializar() {

		System.out.println("Iniciando ControladorMenuPrincipal");
		vistaMenuPrincipal.inicializar();
		vistaMenuPrincipal.setElementosMenu(modeloMenuPrincipal.getElementosMenu());
		
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

	@Override
	public void actualizar(float deltaTiempo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void renderizar() {
		// TODO Auto-generated method stub
		vistaMenuPrincipal.renderizar();
	}

	@Override
	public void manejarEntradas() {
		if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
			System.out.println("ENTER Menu!");
		}
		
		if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
			System.out.println("Move menu UP!");
		}
		
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			System.out.println("Move menu DOWN!");
		}
		
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		vistaMenuPrincipal.dispose();
	}

}
