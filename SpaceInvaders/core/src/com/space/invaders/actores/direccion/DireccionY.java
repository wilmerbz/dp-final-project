package com.space.invaders.actores.direccion;

/**
 * Representa la dirección en Y.
 */
public enum DireccionY {
	Arriba (-1),
	Ninguna (0),
	Abajo (1);
	
	private int multiplicadorY;
	
	private DireccionY(int multiplicadorY) {
		this.multiplicadorY = multiplicadorY;
	}
	
	/**
	 * Obtiene el multiplicador de dirección en Y.
	 * @return Multiplicador de dirección.
	 */
	public int getMultiplicadorY() {
		return multiplicadorY;
	}
	
}
