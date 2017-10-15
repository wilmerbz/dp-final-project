package com.space.invaders.actores.disparos.builder;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.space.invaders.actores.direccion.DireccionX;
import com.space.invaders.actores.direccion.DireccionY;
import com.space.invaders.recursos.texturas.AdministradorTexturas;
import com.space.invaders.recursos.texturas.IAdministradorTexturas;
import com.space.invaders.recursos.texturas.NombreTextura;

/**
 * Builder concreto de Disparo, para construir disparos enemigos.
 */
public class DisparoEnemigoBuilder extends DisparoBuilder {

	/**
	 * Construye las texturas del disparo enemigo.
	 */
	@Override
	public void construirTextura() {
		IAdministradorTexturas adminTexturas = AdministradorTexturas.getInstancia();
		Texture texturaDisparoEnemigo0 = adminTexturas.obtenerTextura(NombreTextura.DISPARO_ENEMIGO_0);
		Texture texturaDisparoEnemigo1 = adminTexturas.obtenerTextura(NombreTextura.DISPARO_ENEMIGO_1);
		List<Texture> texturasDisparoEnemigo = new ArrayList<Texture>();
		texturasDisparoEnemigo.add(texturaDisparoEnemigo0);
		texturasDisparoEnemigo.add(texturaDisparoEnemigo1);
		disparo.setTexturasAnimacion(texturasDisparoEnemigo);
	}

	/**
	 * Construye la dirección del disparo.
	 */
	@Override
	public void construirDireccion() {
		DireccionX direccionX = DireccionX.Ninguna;
		DireccionY direccionY = DireccionY.Abajo;
		
		disparo.setDireccionX(direccionX);
		disparo.setDireccionY(direccionY);
	}

}
