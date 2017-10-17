package com.space.invaders.actores.util;

/**
 * Permite llevar el conteo del tiempo y determinar si ya se ha alcanzado
 * determinado límite.
 */
public class Temporizador implements Cloneable {

	private float tiempo;
	private float contadorTiempo;

	@Override
	public Temporizador clone() {
		Temporizador temporizador = null;
		try {
			temporizador = (Temporizador) super.clone();
		} catch (CloneNotSupportedException ex) {
			System.out.println(" no se puede duplicar");
		}
		return temporizador;
	}

	/**
	 * Crea un nuevo temporizador.
	 * 
	 * @param tiempo
	 *            Tiempo de espera.
	 */
	public Temporizador(float tiempo) {
		this.tiempo = tiempo;
		this.contadorTiempo = 0f;
	}

	/**
	 * Valida si el contador de tiempo ha alcanzado el tiempo esperado.
	 * 
	 * @param deltaTiempo
	 *            Tiempo transcurrido desde la ultima revisión.
	 * @return Retorna true si se ha alcanzado el tiempo esperado; de lo contrario
	 *         retorna false.
	 */
	public boolean esTiempo(float deltaTiempo) {
		boolean esTiempo = false;
		contadorTiempo += deltaTiempo;
		if (contadorTiempo >= tiempo) {
			contadorTiempo -= tiempo;
			esTiempo = true;
		}

		return esTiempo;
	}

	/**
	 * Obtiene el tiempo de espera del temporizador.
	 * 
	 * @return
	 */
	public float getTiempo() {
		return tiempo;
	}

	/**
	 * Asigna el tiempo de espera del temporizador.
	 * 
	 * @param tiempo
	 *            Tiempo de espera del temporizador.
	 */
	public void setTiempo(float tiempo) {
		this.tiempo = tiempo;
	}

}
