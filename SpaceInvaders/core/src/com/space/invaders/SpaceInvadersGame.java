package com.space.invaders;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.space.invaders.controladores.ControladorPrincipal;
import com.space.invaders.interfaces.controladores.IControladorPrincipal;
import com.space.invaders.interfaces.navegacion.IAdministradorNavegacion;
import com.space.invaders.navegacion.AdministradorNavegacion;

import com.space.invaders.navegacion.NombreRuta;

public class SpaceInvadersGame extends ApplicationAdapter {

	private IControladorPrincipal _controladorPrincipal;
	
	@Override
	public void create () {
		inicializarNavegacion();
		
	}
	
	private void inicializarNavegacion() {
		_controladorPrincipal = new ControladorPrincipal();
		IAdministradorNavegacion administradorNavegacion = AdministradorNavegacion.getInstancia();
		administradorNavegacion.setControladorPrincipal(_controladorPrincipal);
		
		administradorNavegacion.agregarRuta(NombreRuta.Bienvenida, "com.space.invaders.controladores.ControladorBienvenida", true);
		administradorNavegacion.agregarRuta(NombreRuta.MenuPrincipal, "com.space.invaders.controladores.ControladorMenuPrincipal", true);
		administradorNavegacion.agregarRuta(NombreRuta.Juego, "com.space.invaders.controladores.ControladorJuego", true);
		
		administradorNavegacion.navegar(NombreRuta.Bienvenida);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		_controladorPrincipal.renderizar();
		
	}
	
	@Override
	public void dispose () {
		_controladorPrincipal.dispose();
	}
	

}
