package com.space.invaders.controladores;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.space.invaders.controladores.base.ControladorEstadoJuegoBase;
import com.space.invaders.entidades.menu.ElementoMenu;
import com.space.invaders.interfaces.mensajes.IColega;
import com.space.invaders.interfaces.mensajes.IMediador;
import com.space.invaders.modelos.ModeloMenuPrincipal;
import com.space.invaders.navegacion.NombreEstado;
import com.space.invaders.recursos.sonido.AdministradorSonidos;
import com.space.invaders.recursos.sonido.NombreSonido;
import com.space.invaders.vistas.VistaEstadoMenuPrincipal;

/**
 * Controlador del menu principal.
 */
public class ControladorEstadoMenuPrincipal extends ControladorEstadoJuegoBase implements IColega {
	
	private IMediador mediador;
	private VistaEstadoMenuPrincipal vistaEstadoMenuPrincipal;
	private ModeloMenuPrincipal modeloMenuPrincipal;
	
	/**
	 * Crea un nuevo controlador de para el Menu Principal.
	 */
	public ControladorEstadoMenuPrincipal() {
		vistaEstadoMenuPrincipal = new VistaEstadoMenuPrincipal(this);	
		modeloMenuPrincipal = new ModeloMenuPrincipal();
	}
	
	@Override
	public void inicializar() {
		System.out.println("Iniciando ControladorMenuPrincipal");
		vistaEstadoMenuPrincipal.inicializar();
		vistaEstadoMenuPrincipal.setElementosMenu(modeloMenuPrincipal.getElementosMenu());
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
		vistaEstadoMenuPrincipal.renderizar();
	}

	@Override
	public void manejarEntradas() {
		
		if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
			
			ElementoMenu elementoMenuActual = modeloMenuPrincipal.getElementoMenuActual();
			
			if(elementoMenuActual!=null) {
				NombreEstado nombreEstado = elementoMenuActual.getNombreRuta();
				
				switch (nombreEstado) {
					case SeleccionarJugador:
					case NuevoJuego:
					case CargarJuego:
						AdministradorSonidos.getInstancia().reproducirSonido(NombreSonido.MENU_SELECCIONAR);
						navegarControlador(NombreEstado.Juego);
						break;
					case Salir:
						Gdx.app.exit();
						break;
					case Regresar:
						AdministradorSonidos.getInstancia().reproducirSonido(NombreSonido.MENU_REGRESAR);
						modeloMenuPrincipal.cargarOpcionesPadre();
						vistaEstadoMenuPrincipal.setElementosMenu(modeloMenuPrincipal.getElementosMenu());
						break;
					default:
						AdministradorSonidos.getInstancia().reproducirSonido(NombreSonido.MENU_SELECCIONAR);
						try {
							if(modeloMenuPrincipal.esSubMenu()) {
								modeloMenuPrincipal.cargarOpcionesSubMenu();
								vistaEstadoMenuPrincipal.setElementosMenu(modeloMenuPrincipal.getElementosMenu());
							}else {
								navegarControlador(nombreEstado);
							}
						} catch (Exception e) {
							
						}
						
						
						break;
					}
				
			}
			
		}
		
		if(Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
			AdministradorSonidos.getInstancia().reproducirSonido(NombreSonido.MENU_MOVER);
			modeloMenuPrincipal.moverElementoAnterior();
		}
		
		if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
			AdministradorSonidos.getInstancia().reproducirSonido(NombreSonido.MENU_MOVER);
			modeloMenuPrincipal.moverElementoSiguiente();
		}
		
		if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
			AdministradorSonidos.getInstancia().reproducirSonido(NombreSonido.MENU_REGRESAR);
			modeloMenuPrincipal.cargarOpcionesPadre();
			vistaEstadoMenuPrincipal.setElementosMenu(modeloMenuPrincipal.getElementosMenu());
		}
	}

	@Override
	public void dispose() {
		vistaEstadoMenuPrincipal.dispose();
	}

	/**
	 * Obtiene los elementos del menu.
	 * @return Elementos menu.
	 */
	public List<ElementoMenu> getElementosMenu() {
		return modeloMenuPrincipal.getElementosMenu();
	}

}