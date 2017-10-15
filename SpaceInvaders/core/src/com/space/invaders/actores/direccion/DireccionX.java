package com.space.invaders.actores.direccion;

/**
 * Representa la dirección en X.
 */
public enum DireccionX {
	Derecha (1),
	Ninguna (0),
	Izquierda (-1);
	
	private final int multiplicadorX;
	
	private DireccionX(int multiplicadorX) {
		this.multiplicadorX = multiplicadorX;
	}
	
	/**
	 * Obtiene el multiplicador de dirección en X.
	 * @return Multiplicador de dirección.
	 */
	public int getMultiplicador() {
		return multiplicadorX;
	}
	
}
