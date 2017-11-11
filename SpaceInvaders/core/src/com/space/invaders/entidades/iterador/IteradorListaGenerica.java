package com.space.invaders.entidades.iterador;

import java.util.List;

/**
 * Iterador para listas genericas.
 * @param <T> Tipo del los elementos a iterar.
 */
public class IteradorListaGenerica<T> implements IteradorGenerico<T>{
	
	   	private int posicion;
	    private List<T> lista;
	    
	    /**
	     * Crea una nueva instancia del iterador de lista generica.
	     * @param list Lista generica a iterar.
	     */
		public IteradorListaGenerica(List<T> list){
	        super();
	        posicion = -1;
	        this.lista = list;
	    }

	    @Override
	    public boolean hasNext() {
	        return (posicion + 1) < lista.size();
	    }

	    @Override
	    public T next() {
	    	
	    	if(!hasNext())
	    	{
	    		return null;
	    	}
	    	
	    	posicion++;
	        T elemento = lista.get(posicion);
	        
	        return elemento;
	    }

	    @Override
	    public T first() {
	        posicion = 0;
	        T elemento = lista.get(posicion);
	        return elemento;
	    }

}
