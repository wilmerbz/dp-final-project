package com.space.invaders;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.space.invaders.controladores.ControladorPrincipal;
import com.space.invaders.interfaces.controladores.IControladorPrincipal;
import com.space.invaders.interfaces.estados.IAdministradorEstados;
import com.space.invaders.navegacion.AdministradorEstados;
import com.space.invaders.navegacion.NombreEstado;

public class SpaceInvadersGame extends ApplicationAdapter {

	
	public static int WIDTH;
	public static int HEIGHT;
	public static OrthographicCamera camara;
	
	private IControladorPrincipal _controladorPrincipal;
	
	@Override
	public void create () {
		inicializarNavegacion();
		inicializarCamara();
	}
	
	/**
	 * Inicializa la navegaci�n del juego.
	 */
	private void inicializarNavegacion() {
		_controladorPrincipal = new ControladorPrincipal();
		
		IAdministradorEstados administradorNavegacion = AdministradorEstados.getInstancia();
		administradorNavegacion.setControladorPrincipal(_controladorPrincipal);
		
		administradorNavegacion.agregarEstado(NombreEstado.Bienvenida, "com.space.invaders.controladores.ControladorEstadoBienvenida", true);
		administradorNavegacion.agregarEstado(NombreEstado.MenuPrincipal, "com.space.invaders.controladores.ControladorEstadoMenuPrincipal", true);
		administradorNavegacion.agregarEstado(NombreEstado.Juego, "com.space.invaders.controladores.ControladorEstadoJuego", true);
		
		administradorNavegacion.navegar(NombreEstado.Bienvenida);
		//administradorNavegacion.navegar(NombreRuta.Juego);
	}

	/**
	 * Inicializa la camara del juego, de acuerdo al tama�o configurado.
	 */
	private void inicializarCamara() {
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();
		
		camara = new OrthographicCamera(WIDTH, HEIGHT);
		camara.translate(WIDTH/2, HEIGHT/2);
		camara.update();
	}
	
	@Override
	public void render () {
		//Limpia la pantalla pintando el color negro.
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		_controladorPrincipal.actualizar(Gdx.graphics.getDeltaTime());
		_controladorPrincipal.renderizar();
		_controladorPrincipal.manejarEntradas();		
	}
	
	@Override
	public void dispose () {
		_controladorPrincipal.dispose();
	}
	

}
