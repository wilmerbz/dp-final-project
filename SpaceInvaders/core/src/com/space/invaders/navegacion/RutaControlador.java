package com.space.invaders.navegacion;

import com.space.invaders.interfaces.controladores.IControlador;

/**
 * Representa la información de una ruta de controlador.
 */
 public class RutaControlador {
	
	private NombreRuta nombreRuta;
	private String nombreClaseControlador;
	private Boolean isSingleton;
	private IControlador instanciaControlador;
	
	/**
	 * Crea una nueva instancia de la ruta de controlador.
	 * @param nombreRuta Nombre de la ruta.
	 * @param nombreClaseControlador Nombre de la clase del controlador.
	 * @param isSingleton Indica si la instancia del controlador es singleton.
	 */
	public RutaControlador(NombreRuta nombreRuta, String nombreClaseControlador, boolean isSingleton) {
		this.nombreRuta = nombreRuta;
		this.nombreClaseControlador = nombreClaseControlador;
		this.isSingleton = isSingleton;
	}
	
	/**
	 * Obtiene el nombre de la ruta.
	 * @return Nombre de la ruta.
	 */
	public NombreRuta getNombreRuta() {
		return nombreRuta;
	}
	
	/**
	 * Asigna el nombre de la ruta.
	 * @param nombreRuta Nombre de la ruta.
	 */
	public void setNombreRuta(NombreRuta nombreRuta) {
		this.nombreRuta = nombreRuta;
	}
	
	/**
	 * Obtiene el nombre de la clase del controlador.
	 * @return Nombre de clase del controlador.
	 */
	public String getNombreClaseControlador() {
		return nombreClaseControlador;
	}
	
	/**
	 * Asigna el nombre de la clase del controlador.
	 * @param nombreClaseControlador Nombre de la clase del controlador.
	 */
	public void setNombreClaseControlador(String nombreClaseControlador) {
		this.nombreClaseControlador = nombreClaseControlador;
	}
	
	/**
	 * Indica si el la instancia del controlador es unica o se crea una nueva en cada navegación.
	 * @return Retorna true si la instancia es singleton; de lo contrario false. 
	 */
	public Boolean getIsSingleton() {
		return isSingleton;
	}
	
	/**
	 * Asigna el valor que indica si el la instancia del controlador es unica o se crea una nueva en cada navegación.
	 * @param isSingleton true si la instancia es singleton; de lo contrario false.
	 */
	public void setIsSingleton(Boolean isSingleton) {
		this.isSingleton = isSingleton;
	}
	
	/**
	 * Obtiene la instancia unica (Singleton) del controlador, cuando ya ha sido inicializada.
	 * @return Instancia del controlador.
	 */
	public IControlador getInstanciaControlador() {
		return instanciaControlador;
	}

	/**
	 * Asigna la instancia unica del controlador.
	 * @param instanciaControlador Instancia unica del controlador.
	 */
	public void setInstanciaControlador(IControlador instanciaControlador) {
		this.instanciaControlador = instanciaControlador;
	}
	
}
