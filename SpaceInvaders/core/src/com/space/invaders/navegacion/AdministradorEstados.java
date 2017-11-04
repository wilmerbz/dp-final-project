package com.space.invaders.navegacion;
import java.security.InvalidParameterException;
import java.util.Hashtable;

import com.space.invaders.interfaces.controladores.IControlador;
import com.space.invaders.interfaces.controladores.IControladorEstadoJuego;
import com.space.invaders.interfaces.controladores.IControladorPrincipal;
import com.space.invaders.interfaces.estados.IAdministradorEstados;
import com.space.invaders.interfaces.estados.IControladorFactory;
import com.space.invaders.interfaces.vistas.IVista;

/***
 * Administrador de navegaci�n que permite navegar entre controladores, sin que tengan referencia entre ellos.
 */
public class AdministradorEstados implements IAdministradorEstados {
	
	private IControladorFactory controladorFactory;
	private IControladorPrincipal controladorPrincipal;
	private Hashtable<NombreEstado, ConfiguracionControladorEstado> controladores;
	
	///#region Singleton
	private static AdministradorEstados instancia;
	
	/***
	 * Obtiene la instancia singleton del administrador de Estados.
	 * @return IAdministradorNavegacion Administrador de Estados.
	 */
	public static IAdministradorEstados getInstancia() {
		if(instancia == null) {
			instancia = new AdministradorEstados();
		}
		
		return instancia;
	}
	
	/***
	 * Constructor privado que crea una instancia de Administrador Navegaci�n.
	 */
	private AdministradorEstados() {
		controladores = new Hashtable<NombreEstado, ConfiguracionControladorEstado>();
		controladorFactory = new ControladorFactory();
	}
	
	///#endregion
	
	@Override
	public void setControladorPrincipal(IControladorPrincipal controladorPrincipal) {
		this.controladorPrincipal = controladorPrincipal;
	}
	
	@Override
	public void agregarEstado(NombreEstado nombreEstado, String nombreClaseControlador, boolean isSingleton) {
		
		removerEstado(nombreEstado);
		
		ConfiguracionControladorEstado informacionRuta = new ConfiguracionControladorEstado(nombreEstado, nombreClaseControlador, isSingleton);
		controladores.put(nombreEstado, informacionRuta);
		
	}
	
	@Override
	public void removerEstado(NombreEstado nombreEstado) {
		
		if(controladores.containsKey(nombreEstado)) {
			controladores.remove(nombreEstado);
		}
	}
	
	@Override
	public void navegar(NombreEstado nombreEstado) {
		
		IControlador controlador = getControlador(nombreEstado);
		controlador.inicializar();
		
		if(controlador instanceof IControladorEstadoJuego) {
			controladorPrincipal.setControladorEstadoJuegoActual((IControladorEstadoJuego)controlador);
		}
		
	}
	
	
	/**
	 * Establece el controlador actual del estado del juego, en el controlador principal.
	 * @param controladorJuego Controlador del estado del juego.
	 */
	@Override
	public void establecerControladorEstadoJuegoActual(IControladorEstadoJuego controladorEstadoJuego) {
		controladorPrincipal.setControladorEstadoJuegoActual(controladorEstadoJuego);
	}
	
	
	protected IControlador getControlador(NombreEstado nombreEstado) {
		
		ConfiguracionControladorEstado informacionControlador = getInformacionControlador(nombreEstado);
		
		if(informacionControlador == null) {
			throw new InvalidParameterException("No se ha registrado una ruta con el nombre indicado.");
		}
		
		IControlador controlador = controladorFactory.crearControlador(informacionControlador);
		return controlador;
		
	}
	
	
	protected ConfiguracionControladorEstado getInformacionControlador(NombreEstado nombreEstado) {
		if(!controladores.containsKey(nombreEstado)) {
			return null;
		}
		
		ConfiguracionControladorEstado informacionRuta =   controladores.get(nombreEstado);
		return informacionRuta;
	}
	
}