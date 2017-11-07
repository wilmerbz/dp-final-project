package com.space.invaders.entidades.iterador;

/**
 * Interfaz para iteradores genericos.
 * @param <T> Tipo del los elementos a iterar.
 */
public interface IteradorGenerico<T> {
	/**
	 * Valida si el iterador puede moverse al siguiente elemento.
	 * @return
	 */
    public boolean hasNext();
    /**
     * Mueve el iterador al siguiente elemento.
     * @return Siguiente elemento.
     */
    public T next();
    /**
     * Mueve el iterador al primer elemento.
     * @return Primer elemento.
     */
    public T first();
}
