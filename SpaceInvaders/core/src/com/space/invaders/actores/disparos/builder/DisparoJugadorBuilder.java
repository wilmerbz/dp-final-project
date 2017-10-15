/**
 * 
 */
package com.space.invaders.actores.disparos.builder;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.space.invaders.actores.direccion.DireccionX;
import com.space.invaders.actores.direccion.DireccionY;
import com.space.invaders.actores.disparos.Disparo;
import com.space.invaders.recursos.texturas.AdministradorTexturas;
import com.space.invaders.recursos.texturas.IAdministradorTexturas;
import com.space.invaders.recursos.texturas.NombreTextura;

/**
 * Builder concreto de Disparo, para construir disparos del jugador.
 */
public class DisparoJugadorBuilder extends DisparoBuilder {


	/* (non-Javadoc)
	 * @see com.space.invaders.actores.disparos.builder.DisparoBuilder#construirTextura()
	 */
	@Override
	public void construirTextura() {
		IAdministradorTexturas adminTexturas = AdministradorTexturas.getInstancia();
		Texture texturaDisparoJugador0 = adminTexturas.obtenerTextura(NombreTextura.DISPARO_JUGADOR_0);
		Texture texturaDisparoJugador1 = adminTexturas.obtenerTextura(NombreTextura.DISPARO_JUGADOR_0);
		List<Texture> texturasDisparoJugador = new ArrayList<Texture>();
		texturasDisparoJugador.add(texturaDisparoJugador0);
		texturasDisparoJugador.add(texturaDisparoJugador1);
		disparo.setTexturasAnimacion(texturasDisparoJugador);
	}

	/* (non-Javadoc)
	 * @see com.space.invaders.actores.disparos.builder.DisparoBuilder#construirDireccion()
	 */
	@Override
	public void construirDireccion() {
		DireccionX direccionX = DireccionX.Ninguna;
		DireccionY direccionY = DireccionY.Arriba;
		
		disparo.setDireccionX(direccionX);
		disparo.setDireccionY(direccionY);
	}


}
