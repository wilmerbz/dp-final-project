package com.space.invaders.actores.naves;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.space.invaders.actores.direccion.DireccionX;
import com.space.invaders.actores.direccion.DireccionY;
import com.space.invaders.recursos.texturas.AdministradorTexturas;
import com.space.invaders.recursos.texturas.IAdministradorTexturas;
import com.space.invaders.recursos.texturas.NombreTextura;

/**
 * Fabrica de las naves enemigas y de la nave del jugador.
 */
public class NaveFactory implements INaveFactory{

	@Override
	public Nave crearNave(TipoNave tipoNave) {

		IAdministradorTexturas administradorTexturas = AdministradorTexturas.getInstancia();
		float tiempoAnimacion = 0.25f;
		List<Texture> texturasEnemigo = new ArrayList<Texture>();
		Texture textura0;
		Texture textura1;
		Nave nave = null;

		switch (tipoNave) {
		case Calamar:
			textura0 = administradorTexturas.obtenerTextura(NombreTextura.ENEMIGO_CALAMAR_0);
			textura1 = administradorTexturas.obtenerTextura(NombreTextura.ENEMIGO_CALAMAR_1);
			texturasEnemigo.add(textura0);
			texturasEnemigo.add(textura1);
			nave = new InvasorCalamar(texturasEnemigo, tiempoAnimacion);
			nave.setDireccionX(DireccionX.Derecha);
			nave.setDireccionY(DireccionY.Abajo);
			nave.setAnimar(true);

			break;
		case Cangrejo:
			textura0 = administradorTexturas.obtenerTextura(NombreTextura.ENEMIGO_CANGREJO_0);
			textura1 = administradorTexturas.obtenerTextura(NombreTextura.ENEMIGO_CANGREJO_1);
			texturasEnemigo.add(textura0);
			texturasEnemigo.add(textura1);
			nave = new InvasorCangrejo(texturasEnemigo, tiempoAnimacion);
			nave.setDireccionX(DireccionX.Derecha);
			nave.setDireccionY(DireccionY.Abajo);
			nave.setAnimar(true);

			break;
		case Pulpo:
			textura0 = administradorTexturas.obtenerTextura(NombreTextura.ENEMIGO_PULPO_0);
			textura1 = administradorTexturas.obtenerTextura(NombreTextura.ENEMIGO_PULPO_1);
			texturasEnemigo.add(textura0);
			texturasEnemigo.add(textura1);
			nave = new InvasorPulpo(texturasEnemigo, tiempoAnimacion);
			nave.setDireccionX(DireccionX.Derecha);
			nave.setDireccionY(DireccionY.Abajo);
			nave.setAnimar(true);

			break;
		case Jugador:

			Texture texturaNaveJugador = administradorTexturas.obtenerTextura(NombreTextura.NAVE_JUGADOR_0);
			List<Texture> texturasNaveJugador = new ArrayList<Texture>();
			texturasNaveJugador.add(texturaNaveJugador);
			nave = new NaveJugador(texturasNaveJugador, tiempoAnimacion);

			break;

		default:
			break;

		}

		return nave;
	}

	@Override
	public List<Nave> crearNaves(TipoNave tipoNave, int contadorEnemigos) {
		

		List<Nave> navesEnemigas = new ArrayList<Nave>();
		Nave naveEnemiga = crearNave(tipoNave);
		Nave copiaNaveEnemiga;
		
		for (int i = 0; i < contadorEnemigos; i++) {
			copiaNaveEnemiga = (Nave)naveEnemiga.clone();	
			navesEnemigas.add(copiaNaveEnemiga);
		}
		
		return navesEnemigas;

	}

}
