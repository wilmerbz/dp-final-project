package com.space.invaders.controladores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.space.invaders.controladores.base.ControladorEstadoJuegoBase;
import com.space.invaders.entidades.menu.ElementoMenu;
import com.space.invaders.entidades.menu.SubMenu;
import com.space.invaders.interfaces.mensajes.IColega;
import com.space.invaders.interfaces.mensajes.IMediador;
import com.space.invaders.modelos.ModeloMenuPrincipal;
import com.space.invaders.navegacion.NombreRuta;
import com.space.invaders.vistas.VistaMenuPrincipal;

/**
 * Controlador del menu principal.
 */
public class ControladorMenuPrincipal extends ControladorEstadoJuegoBase implements IColega {
	
	private IMediador mediador;
	private VistaMenuPrincipal vistaMenuPrincipal;
	private ModeloMenuPrincipal modeloMenuPrincipal;
	
	/**
	 * Crea un nuevo controlador de para el Menu Principal.
	 */
	public ControladorMenuPrincipal() {
		vistaMenuPrincipal = new VistaMenuPrincipal(this);	
		modeloMenuPrincipal = new ModeloMenuPrincipal();
	}
	
	@Override
	public void inicializar() {

		System.out.println("Iniciando ControladorMenuPrincipal");
		vistaMenuPrincipal.inicializar();
		vistaMenuPrincipal.setElementosMenu(modeloMenuPrincipal.getElementosMenu());
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
			
			ElementoMenu elementoMenuActual = modeloMenuPrincipal.getElementoMenuActual();
			
			if(elementoMenuActual!=null) {
				NombreRuta nombreRuta = elementoMenuActual.getNombreRuta();
				
				switch (nombreRuta) {
					case SeleccionarJugador:
					case NuevoJuego:
					case CargarJuego:
						navegarControlador(NombreRuta.Juego);
						break;
					case Salir:
						Gdx.app.exit();
						break;
					case Regresar:
						modeloMenuPrincipal.cargarOpcionesPadre();
						vistaMenuPrincipal.setElementosMenu(modeloMenuPrincipal.getElementosMenu());
						break;
					default:
						if(modeloMenuPrincipal.esSubMenu()) {
							modeloMenuPrincipal.cargarOpcionesSubMenu();
							vistaMenuPrincipal.setElementosMenu(modeloMenuPrincipal.getElementosMenu());
						}else {
							navegarControlador(nombreRuta);
						}
						
						break;
					}
				
			}
			
		}
		
		if(Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
			modeloMenuPrincipal.moverElementoAnterior();
		}
		
		if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
			modeloMenuPrincipal.moverElementoSiguiente();
		}
		
		if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
			modeloMenuPrincipal.cargarOpcionesPadre();
			vistaMenuPrincipal.setElementosMenu(modeloMenuPrincipal.getElementosMenu());
		}
	}

	@Override
	public void dispose() {
		vistaMenuPrincipal.dispose();
	}

}