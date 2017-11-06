package com.space.invaders.actores;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.space.invaders.actores.util.Temporizador;

/**
 * Representa un elemento animado del juego.
 */
public abstract class ElementoSecuenciaImagen extends ElementoImagen{
	
	/**
	 * Texturas utilizadas por la animación.
	 */
	private List<Texture> texturasAnimacion;
	
	/**
	 * Indica si la animacion del elemento se encuentra activa.
	 */
	private boolean animar;
	
	/**
	 * Intervalo de la animación.
	 */
	private float intervaloAnimacion = 0.25f;

	/**
	 * Indice de la textura actual.
	 */
	private int indiceTexturaActual = 0;

	/**
	 * Temporizador que lleva la cuenta de tiempo para cambiar las texturas de la animación.
	 */
	protected Temporizador temporizador;	
	/**
	 * Crea una nueva instancia de un Elemento Animado del Juego.
	 */
	public ElementoSecuenciaImagen() {
		super();
		
	}
	
	/**
	 * Crea una nueva instancia de elemento de juego.
	 * @param intervaloAnimacion Intervalo de cambio de texturas para la animación.
	 */
	public ElementoSecuenciaImagen(float intervaloAnimacion) {
		super();
		texturasAnimacion = new ArrayList<Texture>();
		this.setIntervaloAnimacion(intervaloAnimacion);
	}
	
	/**
	 * Crea una nueva instancia de elemento animado de juego, con una lista de texturas utilizadas para la animación.
	 * @param texturas Texturas utilizadas para la animación.
	 * @param intervaloAnimacion Intervalo de cambio de texturas para la animación.
	 */
	public ElementoSecuenciaImagen(List<Texture> texturas, float intervaloAnimacion) {
		super(texturas.get(0));
		texturasAnimacion = texturas;
		this.setIntervaloAnimacion(intervaloAnimacion);
	}
	
	/**
	 * Actualiza el elemento de juego de acuerdo al cambio de tiempo.
	 * @param deltaTiempo Cambio de tiempo.
	 */
	@Override
	public void actualizar(float deltaTiempo) {
		actualizar(getActor(), deltaTiempo);
	}

	
	protected void actualizar(ActorImagen actor, float deltaTiempo) {

		if(!animar || temporizador == null || texturasAnimacion == null || texturasAnimacion.size() <= 1)
		{
			return;
		}
		
		boolean esTiempo = temporizador.esTiempo(deltaTiempo);
		
		if(!esTiempo) {
			return;
		}
		
		int indiceTexturaNueva;
	    if(indiceTexturaActual+1 < texturasAnimacion.size()) {
	    	indiceTexturaNueva = indiceTexturaActual+1;
	    }else {
	    	indiceTexturaNueva = 0;
	    }
		
	    Texture texturaNueva = null;
	    texturaNueva = texturasAnimacion.get(indiceTexturaNueva);
		indiceTexturaActual = indiceTexturaNueva;
		
		setTextura(actor, texturaNueva);
	}
	
	/**
	 * Obtiene la intervalo de animación.
	 */
	public float getIntervaloAnimacion() {
		return intervaloAnimacion;
	}
	
	/**
	 * Obtiene las texturas de la animación del elemento.
	 * @return Texturas de la animación.
	 */
	public List<Texture> getTexturasAnimacion() {
		return texturasAnimacion;
	}
	
	/**
	 * Activa o desactiva la animación del elemento.
	 */
	public void setAnimar(boolean animar) {
		this.animar = animar;
	}
	
	/**
	 * Asigna el tiempo de intervalo de cambio de texturas para la animación.
	 * @param intervaloAnimacion
	 */
	public void setIntervaloAnimacion(float intervaloAnimacion) {
		this.intervaloAnimacion = intervaloAnimacion;
		if(temporizador == null) {
			this.temporizador = new Temporizador(intervaloAnimacion);
		}else {
			temporizador.setTiempo(intervaloAnimacion);
		}
	}
	
	/**
	 * Asigna las texturas de animación del elemento.
	 * @param texturasAnimacion Texturas de la animación.
	 */
	public void setTexturasAnimacion(List<Texture> texturasAnimacion) {
		this.texturasAnimacion = texturasAnimacion;
		setTextura(texturasAnimacion.get(0));
	}
	
	@Override
	public void disponer() {
		setAnimar(false);
		texturasAnimacion.clear();
		temporizador = null;
	} 

}
