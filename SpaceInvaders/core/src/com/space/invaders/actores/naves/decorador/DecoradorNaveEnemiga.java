package com.space.invaders.actores.naves.decorador;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.space.invaders.actores.ActorImagen;
import com.space.invaders.actores.direccion.DireccionX;
import com.space.invaders.actores.direccion.DireccionY;
import com.space.invaders.actores.disparos.Disparo;
import com.space.invaders.actores.naves.NaveEnemiga;

/**
 * Clase base para los decoradores de Naves Enemigas.
 */
public abstract class DecoradorNaveEnemiga extends NaveEnemiga{
	
	protected NaveEnemiga naveEnemiga;

	/**
	 * Crea una nueva instancia del decorador de nave enemiga.
	 * @param naveEnemiga
	 */
	public DecoradorNaveEnemiga(NaveEnemiga naveEnemiga) {
		super();
		this.naveEnemiga = naveEnemiga;
	}

	@Override
	public ActorImagen getActor() {		
		return naveEnemiga.getActor();
	}
	
	protected ActorImagen getActorDecorador() {		
		return actor;
	}

	@Override
	public void actualizar(float deltaTiempo) {
		naveEnemiga.actualizar(deltaTiempo);
	}
	
	protected void actualizarDecorador(float deltaTiempo) {
		super.actualizar(deltaTiempo);
	}

	@Override
	public void renderizar(SpriteBatch batch) {
		naveEnemiga.renderizar(batch);
	}
	
	protected void renderizarDecorador(SpriteBatch batch) {
		super.renderizar(batch);
	}

	@Override	
	public DireccionX getDireccionX() {
		return naveEnemiga.getDireccionX();
	}
	
	@Override
	public DireccionY getDireccionY() {
		return naveEnemiga.getDireccionY();
	}


	@Override
	public float getVelocidadX() {
		return naveEnemiga.getVelocidadX();
	}

	@Override
	public float getVelocidadY() {
		return naveEnemiga.getVelocidadY();
	}
	
	@Override
	public void setDireccionX(DireccionX direccionX) {
		this.naveEnemiga.setDireccionX(direccionX);
	}
	
	@Override
	public void setDireccionY(DireccionY direccionY) {
		this.naveEnemiga.setDireccionY(direccionY);
	}

	@Override
	public void setVelocidadX(float velocidadX) {
		this.naveEnemiga.setVelocidadX(velocidadX);
	}
	

	@Override
	public void setVelocidadY(float velocidadY) {
		this.naveEnemiga.setVelocidadY(velocidadY);
	}

	@Override
	public DecoradorNaveEnemiga clone() {
		DecoradorNaveEnemiga decoradorClonado =(DecoradorNaveEnemiga) super.clone();
		decoradorClonado.naveEnemiga = (NaveEnemiga) this.naveEnemiga.clone();
		
		return decoradorClonado;
	}
	
	@Override
	public long getPuntos() {
		return this.naveEnemiga.getPuntos();
	}
	
	@Override
	public boolean validarImpacto(Disparo disparo) {
		return this.naveEnemiga.validarImpacto(disparo);
	}
	
	@Override
	public void impactada() {
		this.naveEnemiga.impactada();
	}
	@Override
	public Disparo disparar() {
		return naveEnemiga.disparar();
	}
	
	@Override
	public Disparo getDisparo() {
		return naveEnemiga.getDisparo();
	}
	
	
	@Override
	public float getX() {
		return naveEnemiga.getX();
	}

	@Override
	public void setX(float x) {
		naveEnemiga.setX(x);
	}

	@Override
	public float getY() {
		return naveEnemiga.getY();
	}

	@Override
	public void setY(float y) {
		naveEnemiga.setY(y);
	}
	
	@Override
	public float getWidth() {
		return naveEnemiga.getWidth();
	}
	
	@Override
	public float getHeight() {
		return naveEnemiga.getHeight();
	}
	
	@Override
	public void setWidth(float width) {
		naveEnemiga.setWidth(width);
	}
	
	@Override
	public void setHeight(float height) {
		naveEnemiga.setHeight(height);
	}
}
