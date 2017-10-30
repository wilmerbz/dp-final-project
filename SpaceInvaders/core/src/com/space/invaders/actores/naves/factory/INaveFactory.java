package com.space.invaders.actores.naves.factory;

import java.util.List;

import com.space.invaders.actores.naves.Nave;
import com.space.invaders.actores.naves.TipoNave;

/**
 * Define la interfaz de la fabrica de Naves.
 */
public interface INaveFactory {

	/**
	 * Factory method que crea una nave de acuerdo al Tipo de Nave indicado. 
	 * @param tipoNave Tipo de nave a crear.
	 * @return Nave creada.
	 */
	public Nave crearNave(TipoNave tipoNave);

	/**
	 * Factory method que crea la cantidad de naves indicada por parámetro, para el Tipo de Nave especificado. 
	 * @param tipoNave Tipo de nave a crear.
	 * @param cantidadNaves Cantidad de naves a crear.
	 * @return Lista que contiene las naves creadas.
	 */
	public List<Nave> crearNaves(TipoNave tipoNave, int cantidadNaves);
}
