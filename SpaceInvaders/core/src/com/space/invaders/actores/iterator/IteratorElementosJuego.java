package com.space.invaders.actores.iterator;

import java.util.ArrayList;
import java.util.List;

import com.space.invaders.actores.naves.NaveEnemiga;

public class IteratorElementosJuego<navesEnemigas> implements Iterator<Object>{
	
	   private int pos = 0;
	    private List<navesEnemigas> elementosJuego = new ArrayList<navesEnemigas>();;
	    
	    @SuppressWarnings("unchecked")
		public IteratorElementosJuego(List<NaveEnemiga> navesEnemigas){
	        super();
	        this.elementosJuego =  (List<navesEnemigas>) navesEnemigas;
	    }

	    @Override
	    public boolean hasNext() {
	        return pos + 1 <= elementosJuego.size();
	    }

	    @Override
	    public navesEnemigas next() {
	        navesEnemigas jugador = elementosJuego.get(pos);
	        pos++;
	        return jugador;
	    }

	    @Override
	    public Object first() {
	        pos = 0;
	        navesEnemigas elemento = elementosJuego.get(pos);
	        pos++;
	        return elemento;
	    }

}
