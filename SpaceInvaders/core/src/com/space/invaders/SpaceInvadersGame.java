package com.space.invaders;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.space.invaders.controladores.ControladorPrincipal;
import com.space.invaders.interfaces.controladores.IControladorPrincipal;
import com.space.invaders.interfaces.navegacion.IAdministradorNavegacion;
import com.space.invaders.navegacion.AdministradorNavegacion;

import com.space.invaders.navegacion.NombreRuta;

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
		
		IAdministradorNavegacion administradorNavegacion = AdministradorNavegacion.getInstancia();
		administradorNavegacion.setControladorPrincipal(_controladorPrincipal);
		
		administradorNavegacion.agregarRuta(NombreRuta.Bienvenida, "com.space.invaders.controladores.ControladorBienvenida", true);
		administradorNavegacion.agregarRuta(NombreRuta.MenuPrincipal, "com.space.invaders.controladores.ControladorMenuPrincipal", true);
		administradorNavegacion.agregarRuta(NombreRuta.Juego, "com.space.invaders.controladores.ControladorJuego", true);
		
		administradorNavegacion.navegar(NombreRuta.Bienvenida);
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
		
		//Limpia la pantalla utilizando el color negro.
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
