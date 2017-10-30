package com.space.invaders.actores.naves.decorator;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.space.invaders.actores.Actor;
import com.space.invaders.actores.direccion.DireccionX;
import com.space.invaders.actores.direccion.DireccionY;
import com.space.invaders.actores.naves.NaveEnemiga;

public abstract class NaveEnemigaNivel extends NaveEnemiga{
	
	protected NaveEnemiga naveEnemiga;

	public NaveEnemigaNivel(NaveEnemiga naveEnemiga) {
		this.naveEnemiga = naveEnemiga;
	}

	@Override
	public Actor getActor() {		
		return naveEnemiga.getActor();
	}
	/**
	 * Actualiza el elemento de juego de acuerdo al cambio de tiempo.
	 * @param deltaTiempo Cambio de tiempo.
	 */
	@Override
	public void actualizar(float deltaTiempo) {
		naveEnemiga.actualizar(deltaTiempo);
	}
	/**
	 * Renderiza el elemento.
	 * @param batch Sprite batch a utilizar.
	 */
	@Override
	public void renderizar(SpriteBatch batch) {
		naveEnemiga.renderizar(batch);
	}
	/**
	 * Obtiene la direccion en X.
	 * @return Direccion en X.
	 */
	@Override	
	public DireccionX getDireccionX() {
		return naveEnemiga.getDireccionX();
	}
	
	/**
	 * Obtiene la direccion en Y.
	 * @return Direccion en Y.
	 */
	@Override
	public DireccionY getDireccionY() {
		return naveEnemiga.getDireccionY();
	}

	/**
	 * Obtiene la velocidad en X del elemento.
	 * @return Velocidad en X.
	 */
	@Override
	public float getVelocidadX() {
		return naveEnemiga.getVelocidadX();
	}

	/**
	 * Obtiene la velocidad del elemento en Y.
	 * @return Velocidad en Y.
	 */
	@Override
	public float getVelocidadY() {
		return naveEnemiga.getVelocidadY();
	}
	
	/**
	 * Asigna la direccion en X del elemento.
	 * @param direccionX Direccion en X.
	 */
	@Override
	public void setDireccionX(DireccionX direccionX) {
		this.naveEnemiga.setDireccionX(direccionX);
	}
	
	/**
	 * Asigna la direccion en Y.
	 * @param direccionY Direccion en Y.
	 */
	@Override
	public void setDireccionY(DireccionY direccionY) {
		this.naveEnemiga.setDireccionY(direccionY);
	}
	/**
	 * Asigna la velocidad en X del elemento.
	 * @param velocidadX Velocidad en X.
	 */
	@Override
	public void setVelocidadX(float velocidadX) {
		this.naveEnemiga.setVelocidadX(velocidadX);
	}
	
	/**
	 * Asigna la velocidad en Y del elemento.
	 * @param velocidadY Velocidad en Y.
	 */
	@Override
	public void setVelocidadY(float velocidadY) {
		this.naveEnemiga.setVelocidadY(velocidadY);
	}

	
}
