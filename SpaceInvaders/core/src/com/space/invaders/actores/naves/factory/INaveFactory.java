package com.space.invaders.actores.naves.factory;

import java.util.List;

import com.space.invaders.actores.naves.Nave;
import com.space.invaders.actores.naves.TipoNave;

/**
 * Define la interfaz de la fabrica de Naves.
 */
public interface INaveFactory {

	public Nave crearNave(TipoNave tipoNave);

	public List<Nave> crearNaves(TipoNave tipoNave, int i);
}
