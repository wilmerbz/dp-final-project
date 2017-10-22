package com.space.invaders.actores.naves;

import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.space.invaders.actores.direccion.DireccionX;
import com.space.invaders.actores.disparos.Disparo;
import com.space.invaders.actores.disparos.FachadaCreacionDisparo;

public abstract class NaveEnemiga extends Nave {

	/**
	 * Puntos que proporciona la nave enemiga cuando es destruida.
	 */
	private int puntos;
	
	/**
	 * Indica si la nave enemiga fue destruida.
	 */
	private boolean destruida;
	
	/**
	 * Crea una nueva instancia de NaveEnemiga.
	 * @param intervaloAnimacion Intervalo de cambio de texturas para la animación.
	 */
	public NaveEnemiga(float intervaloAnimacion) {
		super(intervaloAnimacion);
	}

	/**
	 * Crea una nueva instancia de NaveEnemiga.
	 * @param texturas Texturas utilizadas para la animación.
	 * @param intervaloAnimacion Intervalo de cambio de texturas para la animación.
	 */
	public NaveEnemiga(List<Texture> texturas, float intervaloAnimacion) {
		super(texturas, intervaloAnimacion);
	}

	/**
	 * Crea un nuevo disparo para la nave enemiga.
	 * @return Disparo creado.
	 */
	public Disparo disparar() {
		if(disparo!=null && !disparo.isImpactado()) {
			return null;
		}
		
		disparo = FachadaCreacionDisparo.getInstancia().construirDisparoEnemigo();
		setUbicacionInicialDisparo(disparo);
		return disparo;
	}
	
	/**
	 * Obtener puntos.
	 * @return Puntos.
	 */
	public int getPuntos() {
		return puntos;
	}
	
	
	/**
	 * Asigna los puntos.
	 * @param puntos Puntos.
	 */
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	/**
	 * Obtiene el valor que indica si la nave fue destruida.
	 * @return Retorna true si la nave se encuentra destruida; de lo contrario retorna false.
	 */
	public boolean isDestruida() {
		return destruida;
	}

	/**
	 * Asigna el valor que indica si la nave fue destruda.
	 * @param destruida Indica si la nave fue destruda.
	 */
	public void setDestruida(boolean destruida) {
		this.destruida = destruida;
	}
	
	private boolean cambiandoFila = false;
	private float cambioFilaY;
	@Override
	public void actualizar(float deltaTiempo) {
		super.actualizar(deltaTiempo);
		
		boolean puedeMoverX = moverX();
		
		if(!puedeMoverX) {
			if(!cambiandoFila) {
				cambioFilaY = getY() - (getHeight() + 10);
				cambiandoFila = true;
			}
			
			moverY();
			
			if(getY() <= cambioFilaY) {
				cambiandoFila = false;
				DireccionX nuevaDireccionX;
				
				switch (getDireccionX()) {
				case Derecha:
					nuevaDireccionX = DireccionX.Izquierda;
					break;
				case Izquierda:
					nuevaDireccionX = DireccionX.Derecha;
					break;
				default:
					nuevaDireccionX = DireccionX.Ninguna;
					break;
				}
				
				setDireccionX(nuevaDireccionX);
			}
		}
	}
	
	@Override
	public void renderizar(SpriteBatch batch) {
		if(isDestruida())
			return;
		
		super.renderizar(batch);

	}
	
	@Override
	public void impactada() {
		setDestruida(true);
	}
}
