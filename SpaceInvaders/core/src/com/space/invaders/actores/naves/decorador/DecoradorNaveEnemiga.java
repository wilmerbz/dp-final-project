package com.space.invaders.actores.naves.decorador;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.space.invaders.actores.Actor;
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
		this.naveEnemiga = naveEnemiga;
	}

	@Override
	public Actor getActor() {		
		return naveEnemiga.getActor();
	}
	
	protected Actor getActorDecorador() {		
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
}
