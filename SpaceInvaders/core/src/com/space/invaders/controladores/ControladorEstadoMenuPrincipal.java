package com.space.invaders.controladores;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.space.invaders.controladores.base.ControladorEstadoJuegoBase;
import com.space.invaders.entidades.menu.OpcionMenu;
import com.space.invaders.interfaces.mensajes.IColega;
import com.space.invaders.interfaces.mensajes.IMediador;
import com.space.invaders.modelos.ModeloMenuPrincipal;
import com.space.invaders.navegacion.NombreEstado;
import com.space.invaders.recursos.sonido.NombreSonido;
import com.space.invaders.vistas.VistaEstadoMenu;

/**
 * Controlador del menu principal.
 */
public class ControladorEstadoMenuPrincipal extends ControladorEstadoJuegoBase implements IColega {
	
	private final String titulo = "* SPACE INVADERS *";
	private IMediador mediador;
	private VistaEstadoMenu vista;
	private ModeloMenuPrincipal modelo;
	
	/**
	 * Crea un nuevo controlador de para el Menu Principal.
	 */
	public ControladorEstadoMenuPrincipal() {
		vista = new VistaEstadoMenu(this, titulo);	
		modelo = new ModeloMenuPrincipal();
	}
	
	@Override
	public void inicializar() {
		vista.inicializar();
		vista.setOpcionesMenu(modelo.getElementosMenu());
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
		vista.renderizar();
	}

	@Override
	public void manejarEntradas() {
		
		if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
			
			OpcionMenu elementoMenuActual = modelo.getElementoMenuActual();
			
			if(elementoMenuActual!=null) {
				NombreEstado nombreEstado = elementoMenuActual.getNombreRuta();
				
				switch (nombreEstado) {
					case NuevoJuego:
						reproducirSonido(NombreSonido.MENU_SELECCIONAR);
						cambiarEstado(NombreEstado.Juego);
						mediador.enviarMensaje(this,"IniciarJuego", null);
						
						break;
					case CargarJuego:
						reproducirSonido(NombreSonido.MENU_SELECCIONAR);
						cambiarEstado(NombreEstado.Juego);
						mediador.enviarMensaje(this,"CargarJuego", null);
						break;
					case Salir:
						Gdx.app.exit();
						break;
					case Regresar:
						reproducirSonido(NombreSonido.MENU_REGRESAR);
						modelo.cargarOpcionesPadre();
						vista.setOpcionesMenu(modelo.getElementosMenu());
						break;
					default:
						reproducirSonido(NombreSonido.MENU_SELECCIONAR);
						try {
							if(modelo.esSubMenu()) {
								modelo.cargarOpcionesSubMenu();
								vista.setOpcionesMenu(modelo.getElementosMenu());
							}else {
								cambiarEstado(nombreEstado);
							}
						} catch (Exception e) {
							
						}
						
						break;
					}
				
			}
			
		}
		
		if(Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
			reproducirSonido(NombreSonido.MENU_MOVER);
			modelo.moverElementoAnterior();
		}
		
		if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
			reproducirSonido(NombreSonido.MENU_MOVER);
			modelo.moverElementoSiguiente();
		}
		
		if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
			reproducirSonido(NombreSonido.MENU_REGRESAR);
			modelo.cargarOpcionesPadre();
			vista.setOpcionesMenu(modelo.getElementosMenu());
		}
	}

	@Override
	public void dispose() {
		vista.dispose();
	}

	/**
	 * Obtiene los elementos del menu.
	 * @return Elementos menu.
	 */
	public List<OpcionMenu> getElementosMenu() {
		return modelo.getElementosMenu();
	}

}