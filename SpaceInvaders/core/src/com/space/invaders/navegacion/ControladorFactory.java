package com.space.invaders.navegacion;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.space.invaders.interfaces.controladores.IControlador;
import com.space.invaders.interfaces.estados.IControladorFactory;
import com.space.invaders.interfaces.mensajes.IColega;
import com.space.invaders.mensajes.MediadorPrincipal;

/**
 * Fabrica de controladores.
 */
public class ControladorFactory implements IControladorFactory{

	@Override
	public IControlador crearControlador(ConfiguracionControladorEstado informacionRuta) {
		// TODO Auto-generated method stub
		if(informacionRuta.isSingleton() && informacionRuta.getInstanciaControlador() != null) {
			return informacionRuta.getInstanciaControlador();
		}
		
		IControlador controlador = null;
		
		try {
			String nombreClaseControlador = informacionRuta.getNombreClaseControlador();
			Class<?> claseControlador = Class.forName(nombreClaseControlador);
			Constructor<?> contructorControlador = claseControlador.getConstructor();
			controlador = (IControlador) contructorControlador.newInstance();
			
			if(informacionRuta.isSingleton()) {
				informacionRuta.setInstanciaControlador(controlador);
			}
			
			if(controlador instanceof IColega) {
				MediadorPrincipal.getInstancia().registrarColega((IColega)controlador);
			}
			
		}catch(ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return controlador;
	}

}
