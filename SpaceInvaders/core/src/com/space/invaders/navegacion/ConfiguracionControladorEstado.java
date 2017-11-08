package com.space.invaders.navegacion;

import com.space.invaders.interfaces.controladores.IControlador;

/**
 * Representa la informacion de una ruta de controlador.
 */
 public class ConfiguracionControladorEstado {
	
	private NombreEstado nombreEstado;
	private String nombreClaseControlador;
	private Boolean singleton;
	private IControlador instanciaControlador;
	
	/**
	 * Crea una nueva instancia del estado de controlador.
	 * @param nombreEstado Nombre del estado.
	 * @param nombreClaseControlador Nombre de la clase del controlador.
	 * @param isSingleton Indica si la instancia del controlador es singleton.
	 */
	public ConfiguracionControladorEstado(NombreEstado nombreEstado, String nombreClaseControlador, boolean isSingleton) {
		this.nombreEstado = nombreEstado;
		this.nombreClaseControlador = nombreClaseControlador;
		this.singleton = isSingleton;
	}
	
	/**
	 * Obtiene el nombre del estado.
	 * @return Nombre del estado.
	 */
	public NombreEstado getNombreEstado() {
		return nombreEstado;
	}
	
	/**
	 * Asigna el nombre del estado.
	 * @param nombreEstado Nombre del estado.
	 */
	public void setNombreEstado(NombreEstado nombreEstado) {
		this.nombreEstado = nombreEstado;
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
	public void setNombreClaseControladorEstado(String nombreClaseControladorEstado) {
		this.nombreClaseControlador = nombreClaseControladorEstado;
	}
	
	/**
	 * Indica si el la instancia del controlador es unica o se crea una nueva en cada vez que se cambie al este estado.
	 * @return Retorna true si la instancia es singleton; de lo contrario false. 
	 */
	public Boolean isSingleton() {
		return singleton;
	}
	
	/**
	 * Asigna el valor que indica si el la instancia del controlador es unica o se crea una nueva en cada navegaci�n.
	 * @param isSingleton true si la instancia es singleton; de lo contrario false.
	 */
	public void setSingleton(Boolean isSingleton) {
		this.singleton = isSingleton;
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
