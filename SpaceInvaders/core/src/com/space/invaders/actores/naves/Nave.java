package com.space.invaders.actores.naves;

import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.space.invaders.actores.ElementoAnimadoJuego;
import com.space.invaders.actores.disparos.Disparo;

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
	 * Disparo actual de la nave.
	 */
	protected Disparo disparo;
	
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
	
	/**
	 * Valida si el disparo dado impactó la nave.
	 * @param disparo Disparo a validar.
	 * @return Retorna true si el disparo impactó la nave; de lo contrario retorna false.
	 */
	public boolean validarImpacto(Disparo disparo) {
		
		SpriteDrawable spriteDrawableDisparo = (SpriteDrawable) disparo.getDrawable();
		Sprite spriteDisparo = spriteDrawableDisparo.getSprite();
		Rectangle rectanguloDisparo = spriteDisparo.getBoundingRectangle();
		
		SpriteDrawable spriteDrawableNave = (SpriteDrawable) this.getDrawable();
		Sprite spriteNave = spriteDrawableNave.getSprite();
		Rectangle rectanguloNave = spriteNave.getBoundingRectangle();
		
		boolean impacto = rectanguloNave.overlaps(rectanguloDisparo);
		
		if(impacto) {
			System.out.println("Boooommm!!!");
		}
	
		return impacto;
	}


	/**
	 * Crea un nuevo disparo para la nave.
	 * @return Disparo creado.
	 */
	public abstract Disparo disparar();
	
	/**
	 * Asigna la ubicacion inicial del disparo.
	 * @param disparo
	 */
	protected void setUbicacionInicialDisparo(Disparo disparo) {
		float x = getX() + (getWidth()/2) - (disparo.getWidth()/2);
		float y = getY() + disparo.getHeight();
		disparo.setX(x);
		disparo.setY(y);
	}
	
	@Override
	public void actualizar(float deltaTiempo) {
		super.actualizar(deltaTiempo);
		
		if(disparo != null) {

			if(disparo.validarUbicacionLimiteY()) {
				disparo = null;
				System.out.println("Disparo alcanzó el límite.");
			}else {
				disparo.actualizar(deltaTiempo);
			}
				
		}
	}
	
	@Override
	public void renderizar(SpriteBatch batch) {
		super.renderizar(batch);
		
		if(disparo!=null) {
			disparo.renderizar(batch);
		}
	}
	
	/**
	 * Obtiene el disparo actual de la nave.
	 * @return Disparo.
	 */
	public Disparo getDisparo() {
		return disparo;
	} 
	
	
}
