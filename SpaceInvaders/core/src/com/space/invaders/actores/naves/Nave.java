package com.space.invaders.actores.naves;

import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.TextureAtlasData.Region;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.space.invaders.actores.Actor;
import com.space.invaders.actores.ElementoAnimadoJuego;
import com.space.invaders.actores.ElementoJuego;
import com.space.invaders.actores.direccion.DireccionY;
import com.space.invaders.actores.disparos.Disparo;

/**
 * Clase base para las naves.
 */
public abstract class Nave extends ElementoAnimadoJuego implements Cloneable {

	/**
	 * Disparo actual de la nave.
	 */
	protected Disparo disparo;
	
	/**
	 * Velocidad de disparos.
	 */
	protected float velocidadDisparo;
	
	public Nave() {
		
	}

	/**
	 * Crea una nueva instancia de Nave.
	 * 
	 * @param intervaloAnimacion
	 *            Intervalo de cambio de texturas para la animación.
	 */
	public Nave(float intervaloAnimacion) {
		super(intervaloAnimacion);
	}

	/**
	 * Crea una nueva instancia de Nave.
	 * 
	 * @param texturas
	 *            Texturas utilizadas para la animación.
	 * @param intervaloAnimacion
	 *            Intervalo de cambio de texturas para la animación.
	 */
	public Nave(List<Texture> texturas, float intervaloAnimacion) {
		super(texturas, intervaloAnimacion);
	}

	public Nave(NaveEnemiga naveEnemiga) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actualizar(float deltaTiempo) {
		super.actualizar(deltaTiempo);

		if (disparo != null) {

			if (disparo.alcanzoUbicacionLimiteY()) {
				disparo.setVisible(false);
				disparo = null;
			} else {
				disparo.actualizar(deltaTiempo);
			}

		}
	}

	
	/*
	 * Implementación metodo para clonar elemento juego.
	 */
	@Override
	public Nave clone() {
		Nave copiaElemento = null;
		copiaElemento = (Nave) super.clone();
		if(this.temporizador!=null) {
		copiaElemento.temporizador = this.temporizador.clone();
		}
		
		return copiaElemento;
	}
	
	
	/**
	 * Crea un nuevo disparo para la nave.
	 * 
	 * @return Disparo creado.
	 */
	public abstract Disparo disparar();

	/**
	 * Obtiene el disparo actual de la nave.
	 * 
	 * @return Disparo.
	 */
	public Disparo getDisparo() {
		return disparo;
	}

	@Override
	public void renderizar(SpriteBatch batch) {
		super.renderizar(batch);

		if (disparo != null) {
			disparo.renderizar(batch);
		}
	}

	/**
	 * Asigna la ubicacion inicial del disparo.
	 * 
	 * @param disparo
	 */
	protected void setUbicacionInicialDisparo(Disparo disparo) {
		Image actorDisparo= disparo.getActor();
	
		float x = getActor().getX() + (getActor().getWidth() / 2) - (actorDisparo.getWidth() / 2);
		float y = getActor().getY();
		int multiplicadorDiferenciaAlturaY = 1;
		if (disparo.getDireccionY() == DireccionY.Abajo) {
			multiplicadorDiferenciaAlturaY = 0;
		}
		
		y+= getActor().getHeight() * multiplicadorDiferenciaAlturaY;
		
		
		actorDisparo.setX(x);
		actorDisparo.setY(y);
	}
	

	/**
	 * Valida si el disparo dado impactó la nave.
	 * 
	 * @param disparo
	 *            Disparo a validar.
	 * @return Retorna true si el disparo impactó la nave; de lo contrario retorna
	 *         false.
	 */
	public boolean validarImpacto(Disparo disparo) {
		return validarImpacto(getActor(), disparo);
	}
	
	
	protected boolean validarImpacto(Actor actor, Disparo disparo) {
		Image actorDisparo= disparo.getActor();		
		SpriteDrawable spriteDrawableDisparo = (SpriteDrawable) actorDisparo.getDrawable();
		Sprite spriteDisparo = spriteDrawableDisparo.getSprite();
		Rectangle rectanguloDisparo = spriteDisparo.getBoundingRectangle();

		Rectangle rectanguloNave = new Rectangle(actor.getX(), actor.getY(), actor.getWidth(), actor.getHeight());

		boolean impacto = rectanguloNave.overlaps(rectanguloDisparo);

		if (impacto) {
			disparo.setImpactado(true);
			impactada();
		}

		return impacto;
	}
	
	/**
	 * Metodo que se llama cuando la nave ha sido impactada.
	 */
	public abstract void impactada();
	
	/**
	 * Obtiene la velocidad de los disparos.
	 * @return Velocidad de disparos.
	 */
	public float getVelocidadDisparo() {
		return velocidadDisparo;
	}

	/**
	 * Asigna la velocidad de los disparos.
	 * @param velocidadDisparo Velocidad de disparos.
	 */
	public void setVelocidadDisparo(float velocidadDisparo) {
		this.velocidadDisparo = velocidadDisparo;
	}

}
