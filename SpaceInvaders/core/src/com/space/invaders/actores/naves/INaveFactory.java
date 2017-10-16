package com.space.invaders.actores.naves;

import java.util.List;

/**
 * Define la interfaz de la fabrica de Naves.
 */
public interface INaveFactory {

	public Nave crearNave(TipoNave tipoNave);

	public List<Nave> crearNaves(TipoNave tipoNave, int i);
}
