package com.space.invaders.actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.space.invaders.actores.direccion.DireccionX;
import com.space.invaders.actores.direccion.DireccionY;
import com.space.invaders.actores.naves.Nave;

/**
 * Representa un elemento que se pinta en el juego, utilizando una imagen.
 */
public abstract class ElementoJuego extends Image{

	protected DireccionX direccionX;
	protected float velocidadX = 1;
	protected DireccionY direccionY;
	protected float velocidadY = 1;
	protected boolean visible = true;

	/**
	 * Crea una nueva instancia de elemento de juego.
	 */
	public ElementoJuego() {
		super();
	}

	/**
	 * Crea una nueva instancia de elemento de juego.
	 */
	public ElementoJuego(Texture texture) {
		super(texture);
		
	}

	/**
	 * Actualiza el elemento de juego de acuerdo al cambio de tiempo.
	 * @param deltaTiempo Cambio de tiempo.
	 */
	public abstract void actualizar(float deltaTiempo);
	
	/**
	 * Renderiza el elemento.
	 * @param batch Sprite batch a utilizar.
	 */
	public void renderizar(SpriteBatch batch) {
		if(!visible) {
			return;
		}
		
		this.draw(batch, 1);
	}
	
	/**
	 * Dispone del elemento.
	 */
	public abstract void disponer();
	
	
	/**
	 * Obtiene la direccion en X.
	 * @return Direccion en X.
	 */
	public DireccionX getDireccionX() {
		return direccionX;
	}
	
	/**
	 * Obtiene la direccion en Y.
	 * @return Direccion en Y.
	 */
	public DireccionY getDireccionY() {
		return direccionY;
	}

	/**
	 * Obtiene la velocidad en X del elemento.
	 * @return Velocidad en X.
	 */
	public float getVelocidadX() {
		return velocidadX;
	}

	/**
	 * Obtiene la velocidad del elemento en Y.
	 * @return Velocidad en Y.
	 */
	public float getVelocidadY() {
		return velocidadY;
	}

	/**
	 * Asigna la direccion en X del elemento.
	 * @param direccionX Direccion en X.
	 */
	public void setDireccionX(DireccionX direccionX) {
		this.direccionX = direccionX;
	}
	
	/**
	 * Asigna la direccion en Y.
	 * @param direccionY Direccion en Y.
	 */
	public void setDireccionY(DireccionY direccionY) {
		this.direccionY = direccionY;
	}
	
	/**
	 * Asigna la nueva textura al elemento de juego.
	 * @param textura Nueva textura para el elemento de juego.
	 */
	public void setTextura(Texture textura) 
	{
		Sprite sprite = new Sprite(textura);
		SpriteDrawable spriteDrawable = new SpriteDrawable(sprite);
		this.setDrawable(spriteDrawable);
		this.setSize(textura.getWidth(), textura.getHeight());
	}
	
	
	/**
	 * Asigna la velocidad en X del elemento.
	 * @param velocidadX Velocidad en X.
	 */
	public void setVelocidadX(float velocidadX) {
		this.velocidadX = velocidadX;
	}
	
	/**
	 * Asigna la velocidad en Y del elemento.
	 * @param velocidadY Velocidad en Y.
	 */
	public void setVelocidadY(float velocidadY) {
		this.velocidadY = velocidadY;
	}
	
	/**
	 * Indica si el elemento es visible.
	 * @return Retorna true si el elemento es visible; de lo contrario retorna false.
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * Cambia la visibilidad del elemento.
	 * @param visible Es visible.
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	
	/**
	 * Mueve el elemento de acuerdo a la configuración de dirección y velocidad.
	 */
	public void mover() {
		moverX();
		moverY();
	}
	
	/**
	 * Mueve el elemento en X de acuerdo a la configuración de dirección y velocidad.
	 */
	public boolean moverX() {
		return moverX(direccionX, velocidadX);
	}
	
	/**
	 * Mueve el elemento en X de acuerdo a la configuración de dirección y velocidad.
	 * @param direccion Direccion en X.
	 * @param velocidad Velocidad de moviemiento.
	 */
	public boolean moverX(DireccionX direccion, float velocidad) {
	
		if(alcanzoUbicacionLimiteX(direccion))
			return false;
		
		float x = getX() + (velocidad * direccion.getMultiplicadorX());
		this.setX(x);
		return true;
	}
	
	/**
	 * Mueve el elemento en Y de acuerdo a la configuración de dirección y velocidad.
	 */
	public boolean moverY() {
		return moverY(direccionY, velocidadY);
	}
	
	/**
	 * Mueve el elemento en Y de acuerdo a la configuración de dirección y velocidad.
	 * @param direccion Direccion en Y.
	 * @param velocidad Velocidad de moviemiento.
	 */
	public boolean moverY(DireccionY direccion, float velocidad) {
		
		if(alcanzoUbicacionLimiteY(direccion))
			return false;
		
		float y = getY() + (velocidadY * direccion.getMultiplicadorY());
		this.setY(y);
		return true;
	}
	
	/**
	 * Mueve el elemento hacia la derecha.
	 */
	public void moverDerecha() {
		moverX(DireccionX.Derecha, velocidadX);
	}
	
	/**
	 * Mover elemento hacia la izquierda.
	 */
	public void moverIzquierda() {
		moverX(DireccionX.Izquierda, velocidadX);
	}

	
	/**
	 * Valida si el elemento alcanzó la ubicación limite en X.
	 * @return Retorna true si el elemento alcanzo la ubicacion limite en X.
	 */
	public boolean alcanzoUbicacionLimiteX() {
		return alcanzoUbicacionLimiteX(this.direccionX);
	}
	
	
	/**
	 * Valida si el elemento alcanzó la ubicación limite en X.
	 * @return Retorna true si el elemento alcanzo la ubicacion limite en X.
	 */
	public boolean alcanzoUbicacionLimiteX(DireccionX direccionX) {
		float x = getX();
		float width = getWidth();
		float graphicsWidth = Gdx.graphics.getWidth();
		
		boolean alcanzoLimiteX = (direccionX == DireccionX.Izquierda && x < 0) || (direccionX == DireccionX.Derecha && x > graphicsWidth-width);
		return alcanzoLimiteX;
	}
	
	/**
	 * Valida si el elemento alcanzó la ubicación limite en X.
	 * @return Retorna true si el elemento alcanzo la ubicacion limite en X.
	 */
	public boolean alcanzoUbicacionLimiteY() {
		return alcanzoUbicacionLimiteY(this.direccionY);
	}
	
	/**
	 * Valida si el elemento alcanzó la ubicación limite en Y.
	 * @return Retorna true si el elemento alcanzo la ubicacion limite en Y.
	 */
	public boolean alcanzoUbicacionLimiteY(DireccionY direccionY) {
		float y = getY();
		float graphicsHeight = Gdx.graphics.getHeight();
		boolean alcanzoLimiteY =(direccionY == DireccionY.Abajo && y < 0) || (direccionY == DireccionY.Arriba && y > graphicsHeight);
		return alcanzoLimiteY;
	}
	
	

}
