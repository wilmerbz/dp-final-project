package com.space.invaders.mensajes;

import java.util.HashSet;
import java.util.Iterator;

import com.space.invaders.interfaces.mensajes.IColega;
import com.space.invaders.interfaces.mensajes.IMediador;

public class MediadorPrincipal implements IMediador {
	
	private HashSet<IColega> colegas;
	
	private static MediadorPrincipal instancia;
	private MediadorPrincipal() {
		colegas = new HashSet<IColega>();
	}
	public static MediadorPrincipal getInstancia() {
		if(instancia == null) 
		{
			instancia = new MediadorPrincipal();
		}
		return instancia;
	}
	
	
	@Override
	public void registrarColega(IColega colega) {
		// TODO Auto-generated method stub
		colegas.add(colega);
		colega.setMediador(this);
	}

	@Override
	public void desregistrarColega(IColega colega) {
		// TODO Auto-generated method stub
		colegas.remove(colega);
	}

	@Override
	public void enviarMensaje(IColega sender, String mensaje, Object data) {
		Iterator<IColega> iterator = colegas.iterator();
		
		while(iterator.hasNext()) {
			IColega colega = iterator.next();
			if(colega == sender) 
				continue;
			
			try {
				colega.recibirMensaje(mensaje, data);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}	
		
	}
	
}
