package com.space.invaders.actores.naves;

import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.space.invaders.actores.direccion.DireccionX;
import com.space.invaders.actores.direccion.DireccionY;
import com.space.invaders.actores.disparos.Disparo;
import com.space.invaders.actores.disparos.FachadaCreacionDisparo;
import com.space.invaders.recursos.sonido.AdministradorSonidos;
import com.space.invaders.recursos.sonido.NombreSonido;

/**
 * Clase abstracta para las naves enemigas.
 */
public abstract class NaveEnemiga extends Nave {

	
	/**
	 * Indica si la nave enemiga fue destruida.
	 */
	private boolean destruida;
	
	/**
	 * Puntos que se obtienen al destruir la nave enemiga.
	 */
	protected long puntos;
	
	public NaveEnemiga() {
		
	}
	
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
		setDireccionX(DireccionX.Derecha);
		setDireccionY(DireccionY.Abajo);
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
	 * Obtiene los puntos que se otorgan cuando la nave es destruida.
	 * @return Puntos.
	 */
	public long getPuntos() {
		return puntos;
	}
	
	
	/**
	 * Asigna los puntos.
	 * @param puntos Puntos.
	 */
	public void setPuntos(long puntos) {
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
				cambioFilaY = actor.getY() - (actor.getHeight() + 10);
				cambiandoFila = true;
			}
			
			moverY();
			
			if(actor.getY() <= cambioFilaY) {
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
		AdministradorSonidos.getInstancia().reproducirSonido(NombreSonido.IMPACTO_NAVE_ENEMIGA);
		setDestruida(true);
	}
}
