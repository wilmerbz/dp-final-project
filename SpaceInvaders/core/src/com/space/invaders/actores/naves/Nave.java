package com.space.invaders.actores.naves;

import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.space.invaders.actores.ElementoAnimadoJuego;
import com.space.invaders.actores.ElementoJuego;

/**
 * Clase base para las naves.
 */
public abstract class Nave extends ElementoAnimadoJuego implements Cloneable {
	
	/*
	 * Implementaci�n metodo para clonar naves
	 *
	 */
	 public Nave clone(){
	        Nave copiaNave=null;
	        try{
	        	copiaNave=(Nave) super.clone();
	        }catch(CloneNotSupportedException ex){
	            System.out.println(" no se puede duplicar");
	        }
	        return copiaNave;
	    }
	/**
	 * Crea una nueva instancia de Nave.
	 * @param intervaloAnimacion Intervalo de cambio de texturas para la animación.
	 */
	public Nave(float intervaloAnimacion) {
		super(intervaloAnimacion);
	}
	
	/**
	 * Crea una nueva instancia de Nave.
	 * @param texturas Texturas utilizadas para la animación.
	 * @param intervaloAnimacion Intervalo de cambio de texturas para la animación.
	 */
	public Nave(List<Texture> texturas, float intervaloAnimacion) {
		super(texturas, intervaloAnimacion);
	}

}
