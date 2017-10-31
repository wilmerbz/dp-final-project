package com.space.invaders.actores.naves.decorador;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicTreeUI.SelectionModelPropertyChangeHandler;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.space.invaders.actores.disparos.Disparo;
import com.space.invaders.actores.naves.NaveEnemiga;
import com.space.invaders.recursos.sonido.AdministradorSonidos;
import com.space.invaders.recursos.sonido.NombreSonido;
import com.space.invaders.recursos.texturas.AdministradorTexturas;
import com.space.invaders.recursos.texturas.IAdministradorTexturas;
import com.space.invaders.recursos.texturas.NombreTextura;

/**
 * Decorador de naves enemigas que agrega escudo resistente a un disparo.
 */
public class DecoradorNaveEnemigaEscudo extends DecoradorNaveEnemiga {

	private boolean escudoImpactado;

	/**
	 * Crea una nueva instancia del decorador de nave enemiga.
	 * 
	 * @param naveEnemiga
	 */
	public DecoradorNaveEnemigaEscudo(NaveEnemiga naveEnemiga) {
		super(naveEnemiga);

		Inicializar();

	}

	/**
	 * Inicializa los elementos del decorador.
	 */
	private void Inicializar() {
		IAdministradorTexturas administradorTexturas = AdministradorTexturas.getInstancia();
		float intervaloAnimacion = 0.1f;
		List<Texture> texturas = new ArrayList<Texture>();
		Texture textura0 = administradorTexturas.obtenerTextura(NombreTextura.ESCUDO_ENEMIGO_0);
		Texture textura1 = administradorTexturas.obtenerTextura(NombreTextura.ESCUDO_ENEMIGO_1);
		texturas.add(textura0);
		texturas.add(textura1);
		setTexturasAnimacion(texturas);
		setIntervaloAnimacion(intervaloAnimacion);
		setAnimar(true);

		this.actor.setX(naveEnemiga.getActor().getX());
		this.actor.setY(naveEnemiga.getActor().getY());
	}

	@Override
	public void actualizar(float deltaTiempo) {
		naveEnemiga.actualizar(deltaTiempo);

		actualizar(getActorDecorador(), deltaTiempo);
		this.actor.setX(naveEnemiga.getActor().getX());
		this.actor.setY(naveEnemiga.getActor().getY());
	}

	@Override
	public void setTextura(Texture textura) {
		setTextura(getActorDecorador(), textura);
	}

	@Override
	public void renderizar(SpriteBatch batch) {
		naveEnemiga.renderizar(batch);
		if (!escudoImpactado) {
			getActorDecorador().draw(batch, 1);
		}
	}

	@Override
	public boolean validarImpacto(Disparo disparo) {
		if (!escudoImpactado) {
			escudoImpactado = validarImpacto(actor, disparo);
			if(escudoImpactado) {
				AdministradorSonidos.getInstancia().reproducirSonido(NombreSonido.IMPACTO_ESCUDO_NAVE_ENEMIGA);
			}
			return false;
		} else {
			boolean naveImpactada = super.validarImpacto(disparo);
			if(naveImpactada) {
				System.out.println("Nave enemiga impactada!");
			}
			return naveImpactada;
		}
	}
	
	@Override
	public long getPuntos() {
		long puntosNave = naveEnemiga.getPuntos();
		long puntosMultiplicados = puntosNave * 2;
		return puntosMultiplicados;
	}
	
	@Override
	public void impactada() {
		if(escudoImpactado) {
			naveEnemiga.impactada();
			setDestruida(true);
		}
	}

}
