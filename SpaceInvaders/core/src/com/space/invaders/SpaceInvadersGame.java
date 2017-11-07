package com.space.invaders;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.space.invaders.controladores.ControladorPrincipal;
import com.space.invaders.interfaces.controladores.IControladorPrincipal;
import com.space.invaders.interfaces.estados.IAdministradorEstados;
import com.space.invaders.navegacion.AdministradorEstados;
import com.space.invaders.navegacion.NombreEstado;

public class SpaceInvadersGame extends ApplicationAdapter {

	protected static int WIDTH;
	protected static int HEIGHT;
	protected static OrthographicCamera camara;
	private IControladorPrincipal _controladorPrincipal;

	/**
	 * Obtiene la camara principal del juego.
	 * @return Camara del juego.
	 */
	public static Camera getCamara() {
		return camara;
	}

	/**
	 * Obtiene la altura de la ventana del juego.
	 * @return Altura.
	 */
	public static int getHEIGHT() {
		return HEIGHT;
	}

	/**
	 * Obtiene el ancho de la ventana del juego.
	 * @return Ancho.
	 */
	public static int getWIDTH() {
		return WIDTH;
	}

	
	@Override
	public void create () {
		inicializarCamara();
		inicializarEstados();
	}
	
	@Override
	public void dispose () {
		_controladorPrincipal.dispose();
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
	
	/**
	 * Inicializa los estados del juego.
	 */
	private void inicializarEstados() {
		_controladorPrincipal = new ControladorPrincipal();
		
		IAdministradorEstados administradorEstados = AdministradorEstados.getInstancia();
		administradorEstados.setControladorPrincipal(_controladorPrincipal);
		
		administradorEstados.agregarEstado(NombreEstado.Bienvenida, "com.space.invaders.controladores.ControladorEstadoBienvenida", true);
		administradorEstados.agregarEstado(NombreEstado.MenuPrincipal, "com.space.invaders.controladores.ControladorEstadoMenuPrincipal", true);
		administradorEstados.agregarEstado(NombreEstado.Juego, "com.space.invaders.controladores.ControladorEstadoPartidaJuego", true);
		administradorEstados.agregarEstado(NombreEstado.NivelCompletado, "com.space.invaders.controladores.ControladorEstadoNivelCompletado", true);
		administradorEstados.agregarEstado(NombreEstado.NivelFallido, "com.space.invaders.controladores.ControladorEstadoNivelFallido", true);
		
		administradorEstados.setEstado(NombreEstado.Bienvenida);
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
	

}
