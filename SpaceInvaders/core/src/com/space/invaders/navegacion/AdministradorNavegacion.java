package com.space.invaders.navegacion;
import java.security.InvalidParameterException;
import java.util.Hashtable;

import com.space.invaders.interfaces.controladores.IControlador;
import com.space.invaders.interfaces.controladores.IControladorEstadoJuego;
import com.space.invaders.interfaces.controladores.IControladorPrincipal;
import com.space.invaders.interfaces.navegacion.IAdministradorNavegacion;
import com.space.invaders.interfaces.navegacion.IControladorFactory;
import com.space.invaders.interfaces.vistas.IVista;

/***
 * Administrador de navegaci�n que permite navegar entre controladores, sin que tengan referencia entre ellos.
 */
public class AdministradorNavegacion implements IAdministradorNavegacion {
	
	private IControladorFactory controladorFactory;
	private IControladorPrincipal controladorPrincipal;
	private Hashtable<NombreRuta, RutaControlador> controladores;
	
	///#region Singleton
	private static AdministradorNavegacion instancia;
	
	/***
	 * Obtiene la instancia singleton del administrador de navegaci�n.
	 * @return IAdministradorNavegacion Administrador de Navegaci�n.
	 */
	public static IAdministradorNavegacion getInstancia() {
		if(instancia == null) {
			instancia = new AdministradorNavegacion();
		}
		
		return instancia;
	}
	
	/***
	 * Constructor privado que crea una instancia de Administrador Navegaci�n.
	 */
	private AdministradorNavegacion() {
		controladores = new Hashtable<NombreRuta, RutaControlador>();
		controladorFactory = new ControladorFactory();
	}
	
	///#endregion
	
	@Override
	public void setControladorPrincipal(IControladorPrincipal controladorPrincipal) {
		this.controladorPrincipal = controladorPrincipal;
	}
	
	@Override
	public void agregarRuta(NombreRuta nombreRuta, String nombreClaseControlador, boolean isSingleton) {
		
		removerRuta(nombreRuta);
		
		RutaControlador informacionRuta = new RutaControlador(nombreRuta, nombreClaseControlador, isSingleton);
		controladores.put(nombreRuta, informacionRuta);
		
	}
	
	@Override
	public void removerRuta(NombreRuta nombreRuta) {
		
		if(controladores.containsKey(nombreRuta)) {
			controladores.remove(nombreRuta);
		}
	}
	
	@Override
	public void navegar(NombreRuta nombreRuta) {
		
		IControlador controlador = getControlador(nombreRuta);
		controlador.inicializar();
		
		if(controlador instanceof IControladorEstadoJuego) {
			controladorPrincipal.establecerControladorEstadoJuegoActual((IControladorEstadoJuego)controlador);
		}
		
	}
	
	
	/**
	 * Establece el controlador actual del estado del juego, en el controlador principal.
	 * @param controladorJuego Controlador del estado del juego.
	 */
	@Override
	public void establecerControladorEstadoJuegoActual(IControladorEstadoJuego controladorEstadoJuego) {
		controladorPrincipal.establecerControladorEstadoJuegoActual(controladorEstadoJuego);
	}
	
	
	protected IControlador getControlador(NombreRuta nombreRuta) {
		
		RutaControlador informacionControlador = getInformacionControlador(nombreRuta);
		
		if(informacionControlador == null) {
			throw new InvalidParameterException("No se ha registrado una ruta con el nombre indicado.");
		}
		
		IControlador controlador = controladorFactory.crearControlador(informacionControlador);
		return controlador;
		
	}
	
	
	protected RutaControlador getInformacionControlador(NombreRuta nombreRuta) {
		if(!controladores.containsKey(nombreRuta)) {
			return null;
		}
		
		RutaControlador informacionRuta =   controladores.get(nombreRuta);
		return informacionRuta;
	}
	
}