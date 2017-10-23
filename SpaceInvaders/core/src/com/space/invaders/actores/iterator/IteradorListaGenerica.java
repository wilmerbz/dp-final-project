package com.space.invaders.actores.iterator;

import java.util.List;

/**
 * Iterador para listas genericas.
 * @param <T> Tipo del los elementos a iterar.
 */
public class IteradorListaGenerica<T> implements IteradorGenerico<T>{
	
	   	private int pos;
	    private List<T> items;
	    
	    /**
	     * Crea una nueva instancia del iterador de lista generica.
	     * @param list Lista generica a iterar.
	     */
		public IteradorListaGenerica(List<T> list){
	        super();
	        pos = -1;
	        this.items = list;
	    }

	    @Override
	    public boolean hasNext() {
	        return (pos + 1) < items.size();
	    }

	    @Override
	    public T next() {
	    	
	    	if(!hasNext())
	    	{
	    		return null;
	    	}
	    	
	    	pos++;
	        T jugador = items.get(pos);
	        
	        return jugador;
	    }

	    @Override
	    public T first() {
	        pos = 0;
	        T elemento = items.get(pos);
	        return elemento;
	    }

}
