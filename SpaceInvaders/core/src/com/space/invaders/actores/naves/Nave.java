package com.space.invaders.actores.naves;

import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.TextureAtlasData.Region;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.space.invaders.actores.ElementoAnimadoJuego;
import com.space.invaders.actores.ElementoJuego;
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

	/**
	 * Valida si el disparo dado impactó la nave.
	 * 
	 * @param disparo
	 *            Disparo a validar.
	 * @return Retorna true si el disparo impactó la nave; de lo contrario retorna
	 *         false.
	 */
	public boolean validarImpacto(Disparo disparo) {

		SpriteDrawable spriteDrawableDisparo = (SpriteDrawable) disparo.getDrawable();
		Sprite spriteDisparo = spriteDrawableDisparo.getSprite();
		Rectangle rectanguloDisparo = spriteDisparo.getBoundingRectangle();

		Rectangle rectanguloNave = new Rectangle(getX(), getY(), getWidth(), getHeight());

		boolean impacto = rectanguloNave.overlaps(rectanguloDisparo);

		if (impacto) {
			impactada();
		}

		return impacto;
	}

	
	/**
	 * Metodo que se llama cuando la nave ha sido impactada.
	 */
	public abstract void impactada();
	
	
	/**
	 * Crea un nuevo disparo para la nave.
	 * 
	 * @return Disparo creado.
	 */
	public abstract Disparo disparar();

	/**
	 * Asigna la ubicacion inicial del disparo.
	 * 
	 * @param disparo
	 */
	protected void setUbicacionInicialDisparo(Disparo disparo) {
		float x = getX() + (getWidth() / 2) - (disparo.getWidth() / 2);
		float y = getY() + disparo.getHeight();
		disparo.setX(x);
		disparo.setY(y);
	}

	@Override
	public void actualizar(float deltaTiempo) {
		super.actualizar(deltaTiempo);

		if (disparo != null) {

			if (disparo.validarUbicacionLimiteY()) {
				disparo = null;
				System.out.println("Disparo alcanzó el límite.");
			} else {
				disparo.actualizar(deltaTiempo);
			}

		}
	}

	@Override
	public void renderizar(SpriteBatch batch) {
		super.renderizar(batch);

		if (disparo != null) {
			disparo.renderizar(batch);
		}
	}

	/**
	 * Obtiene el disparo actual de la nave.
	 * 
	 * @return Disparo.
	 */
	public Disparo getDisparo() {
		return disparo;
	}
	

	/*
	 * Implementación metodo para clonar elemento juego.
	 */
	@Override
	public Nave clone() {
		Nave copiaElemento = null;
		try {
			copiaElemento = (Nave) super.clone();
			copiaElemento.temporizador = this.temporizador.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return copiaElemento;
	}

}
