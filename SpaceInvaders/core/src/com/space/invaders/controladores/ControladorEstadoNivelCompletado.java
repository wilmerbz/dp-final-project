package com.space.invaders.controladores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.space.invaders.controladores.base.ControladorEstadoJuegoBase;
import com.space.invaders.entidades.menu.OpcionMenu;
import com.space.invaders.interfaces.mensajes.IColega;
import com.space.invaders.interfaces.mensajes.IMediador;
import com.space.invaders.modelos.ModeloMenuNivelCompletado;
import com.space.invaders.navegacion.NombreEstado;
import com.space.invaders.recursos.sonido.NombreSonido;
import com.space.invaders.vistas.VistaEstadoMenu;

public class ControladorEstadoNivelCompletado extends ControladorEstadoJuegoBase implements IColega{

	private VistaEstadoMenu vista;
	public ModeloMenuNivelCompletado modelo;
	private final String textoTitulo = "¡Nivel Completado!";
	
	public ControladorEstadoNivelCompletado() {
		vista = new VistaEstadoMenu(this, textoTitulo);
		
		modelo = new ModeloMenuNivelCompletado(); 
	}
	
	@Override
	public void actualizar(float deltaTiempo) {
		vista.actualizar(deltaTiempo);
	}

	@Override
	public void renderizar() {
		vista.renderizar();
	}

	@Override
	public void manejarEntradas() {
		
		if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
			reproducirSonido(NombreSonido.MENU_SELECCIONAR);
			OpcionMenu elementoMenuActual = modelo.getElementoMenuActual();

			if (elementoMenuActual != null) {
				NombreEstado nombreEstado = elementoMenuActual.getNombreRuta();

				switch (nombreEstado) {
				case SiguienteNivel:
					cambiarEstado(NombreEstado.Juego);
					mediador.enviarMensaje(this,"SiguienteNivel", null);
					break;
				case ReiniciarNivel:
					cambiarEstado(NombreEstado.Juego);
					mediador.enviarMensaje(this,"ReiniciarNivel", null);
					break;
				case MenuPrincipal:
					cambiarEstado(NombreEstado.MenuPrincipal);
					break;
				case Salir:
					Gdx.app.exit();
					break;
				default:
					break;
				}

			}
		}

		if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
			reproducirSonido(NombreSonido.MENU_MOVER);
			modelo.moverElementoAnterior();
		}

		if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
			reproducirSonido(NombreSonido.MENU_MOVER);
			modelo.moverElementoSiguiente();
		}
		
	}

	@Override
	public void dispose() {
		vista.dispose();
	}

	@Override
	public void inicializar() {
		vista.inicializar();
		vista.setOpcionesMenu(modelo.getElementosMenu());
	}

	private IMediador mediador;
	
	@Override
	public void setMediador(IMediador mediador) {
		this.mediador = mediador;
	}

	@Override
	public void recibirMensaje(String mensaje, Object data) {
		// TODO Auto-generated method stub
		
	}

}
