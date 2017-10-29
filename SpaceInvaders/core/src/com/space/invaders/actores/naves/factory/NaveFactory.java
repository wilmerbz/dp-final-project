package com.space.invaders.actores.naves.factory;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.space.invaders.actores.direccion.DireccionX;
import com.space.invaders.actores.direccion.DireccionY;
import com.space.invaders.actores.naves.InvasorCalamar;
import com.space.invaders.actores.naves.InvasorCangrejo;
import com.space.invaders.actores.naves.InvasorPulpo;
import com.space.invaders.actores.naves.Nave;
import com.space.invaders.actores.naves.NaveEnemiga;
import com.space.invaders.actores.naves.NaveJugador;
import com.space.invaders.actores.naves.TipoNave;
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
			NaveEnemiga invasorCalamar = new InvasorCalamar(texturasEnemigo, tiempoAnimacion);
			invasorCalamar.setDireccionX(DireccionX.Derecha);
			invasorCalamar.setDireccionY(DireccionY.Abajo);
			invasorCalamar.setPuntos(50);
			nave = invasorCalamar;
			
			break;
		case Cangrejo:
			textura0 = administradorTexturas.obtenerTextura(NombreTextura.ENEMIGO_CANGREJO_0);
			textura1 = administradorTexturas.obtenerTextura(NombreTextura.ENEMIGO_CANGREJO_1);
			texturasEnemigo.add(textura0);
			texturasEnemigo.add(textura1);
			NaveEnemiga invasorCangrejo = new InvasorCangrejo(texturasEnemigo, tiempoAnimacion);
			invasorCangrejo.setDireccionX(DireccionX.Derecha);
			invasorCangrejo.setDireccionY(DireccionY.Abajo);
			invasorCangrejo.setPuntos(100);
			nave = invasorCangrejo;
			
			break;
		case Pulpo:
			textura0 = administradorTexturas.obtenerTextura(NombreTextura.ENEMIGO_PULPO_0);
			textura1 = administradorTexturas.obtenerTextura(NombreTextura.ENEMIGO_PULPO_1);
			texturasEnemigo.add(textura0);
			texturasEnemigo.add(textura1);
			NaveEnemiga invasorPulpo = new InvasorPulpo(texturasEnemigo, tiempoAnimacion);
			invasorPulpo.setDireccionX(DireccionX.Derecha);
			invasorPulpo.setDireccionY(DireccionY.Abajo);
			invasorPulpo.setPuntos(200);
			nave = invasorPulpo;
			break;
		case Jugador:

			Texture texturaNaveJugador0 = administradorTexturas.obtenerTextura(NombreTextura.NAVE_JUGADOR_PERSONAJE_1_0);
			Texture texturaNaveJugador1 = administradorTexturas.obtenerTextura(NombreTextura.NAVE_JUGADOR_PERSONAJE_1_1);
			List<Texture> texturasNaveJugador = new ArrayList<Texture>();
			texturasNaveJugador.add(texturaNaveJugador0);
			texturasNaveJugador.add(texturaNaveJugador1);
			nave = new NaveJugador(texturasNaveJugador, tiempoAnimacion*2);

			break;

		default:
			break;

		}

		nave.setAnimar(true);
		
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
