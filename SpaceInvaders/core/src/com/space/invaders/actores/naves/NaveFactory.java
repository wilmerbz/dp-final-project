package com.space.invaders.actores.naves;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.space.invaders.recursos.texturas.AdministradorTexturas;
import com.space.invaders.recursos.texturas.IAdministradorTexturas;
import com.space.invaders.recursos.texturas.NombreTextura;
/**
 * Fabrica de las naves enemigas y de la nave del jugador.
 */
public class NaveFactory implements INaveFactory {

	@Override
	public Nave crearNave(TipoNave tipoNave) {
		float tiempoAnimacion = 0.25f;
		if (tipoNave.name().equals("Jugador")) {
			
			
			Texture texturaNaveJugador = AdministradorTexturas.getInstancia().obtenerTextura(NombreTextura.ENEMIGO_CALAMAR_0);
			List<Texture> texturasNaveJugador = new ArrayList<Texture>();
			texturasNaveJugador.add(texturaNaveJugador);
			Nave naveJugador = new NaveJugador(texturasNaveJugador, tiempoAnimacion);
	
			return naveJugador;
		}
		return null;

	}

	@Override
	public List<Nave> crearNaves(TipoNave tipoNave, int contadorEnemigos) {
		IAdministradorTexturas administradorTexturas = AdministradorTexturas.getInstancia();
		float tiempoAnimacion = 0.25f;
		if (tipoNave.name().equals("Calamar")) {

			List<Texture> texturasEnemigo = new ArrayList<Texture>();
			List<Nave> navesEnemigas = new ArrayList<Nave>();

			Texture textura0 = administradorTexturas.obtenerTextura(NombreTextura.ENEMIGO_CALAMAR_0);
			Texture textura1 = administradorTexturas.obtenerTextura(NombreTextura.ENEMIGO_CALAMAR_1);
			texturasEnemigo.add(textura0);
			texturasEnemigo.add(textura1);

			for (int i = 0; i < contadorEnemigos; i++) {

				Nave naveEnemiga = new InvasorCalamar(texturasEnemigo, tiempoAnimacion);
				naveEnemiga.setAnimar(true);
				naveEnemiga.setPosition((i + 1) * 40, 500);

				navesEnemigas.add(naveEnemiga);

			}
			return navesEnemigas;

		} else if (tipoNave.name().equals("Cangrejo")) {
			List<Texture> texturasEnemigo = new ArrayList<Texture>();
			List<Nave> navesEnemigas = new ArrayList<Nave>();

			Texture textura0 = administradorTexturas.obtenerTextura(NombreTextura.ENEMIGO_CANGREJO_0);
			Texture textura1 = administradorTexturas.obtenerTextura(NombreTextura.ENEMIGO_CANGREJO_1);
			texturasEnemigo.add(textura0);
			texturasEnemigo.add(textura1);

			for (int i = 0; i < contadorEnemigos; i++) {

				Nave naveEnemiga = new InvasorCalamar(texturasEnemigo, tiempoAnimacion);
				naveEnemiga.setAnimar(true);
				naveEnemiga.setPosition((i + 1) * 40, 600);

				navesEnemigas.add(naveEnemiga);

			}
			return navesEnemigas;

		}else if (tipoNave.name().equals("Pulpo")) {
			List<Texture> texturasEnemigo = new ArrayList<Texture>();
			List<Nave> navesEnemigas = new ArrayList<Nave>();

			Texture textura0 = administradorTexturas.obtenerTextura(NombreTextura.ENEMIGO_PULPO_0);
			Texture textura1 = administradorTexturas.obtenerTextura(NombreTextura.ENEMIGO_PULPO_1);
			texturasEnemigo.add(textura0);
			texturasEnemigo.add(textura1);

			for (int i = 0; i < contadorEnemigos; i++) {

				Nave naveEnemiga = new InvasorCalamar(texturasEnemigo, tiempoAnimacion);
				naveEnemiga.setAnimar(true);
				naveEnemiga.setPosition((i + 1) * 40, 700);

				navesEnemigas.add(naveEnemiga);

			}
			return navesEnemigas;

		}


		return null;

	}

}
