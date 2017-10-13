package com.space.invaders.controladores;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.space.invaders.actores.ElementoJuego;
import com.space.invaders.actores.naves.InvasorCalamar;
import com.space.invaders.actores.naves.NaveJugador;
import com.space.invaders.controladores.base.ControladorEstadoJuegoBase;
import com.space.invaders.entidades.Jugador;
import com.space.invaders.interfaces.controladores.IControlador;
import com.space.invaders.interfaces.controladores.IControladorEstadoJuego;
import com.space.invaders.interfaces.mensajes.IColega;
import com.space.invaders.interfaces.mensajes.IMediador;
import com.space.invaders.recursos.texturas.AdministradorTexturas;
import com.space.invaders.recursos.texturas.NombreTextura;
import com.space.invaders.vistas.VistaJuego;

public class ControladorJuego extends ControladorEstadoJuegoBase implements IColega{
	private int contadorVisualizaciones = 0;
	private IMediador mediador;
	private VistaJuego vistaJuego;
	
	public ControladorJuego() {
		vistaJuego = new VistaJuego(this);
		elementosJuego = new ArrayList<ElementoJuego>();
		navesEnemigas = new ArrayList<ElementoJuego>();
	}
	private List<ElementoJuego> elementosJuego;
	private List<ElementoJuego> navesEnemigas;
	private ElementoJuego naveJugador;
	
	private Texture[] texturasEnemigo;
	
	@Override
	public void inicializar() {
		contadorVisualizaciones++;
		// TODO Auto-generated method stub
		System.out.println("Iniciando ControladorJuego: "+ contadorVisualizaciones);
		
		int contadorEnemigos = 100;
		texturasEnemigo = new Texture[2];
		texturasEnemigo[0] = AdministradorTexturas.getInstancia().obtenerTextura(NombreTextura.ENEMIGO_CALAMAR_0);
		texturasEnemigo[1] = AdministradorTexturas.getInstancia().obtenerTextura(NombreTextura.ENEMIGO_CALAMAR_1);
		
		for (int i = 0; i < contadorEnemigos; i++) {
			
			InvasorCalamar calamar = new InvasorCalamar(texturasEnemigo[0]);
			 calamar.setPosition((i+1)*40, 500);
			 elementosJuego.add(calamar);
			 navesEnemigas.add(calamar);
		}
		
		Texture texturaNaveJugador = AdministradorTexturas.getInstancia().obtenerTextura(NombreTextura.ENEMIGO_CALAMAR_0);
		
		naveJugador = new NaveJugador(texturaNaveJugador);
		elementosJuego.add(naveJugador);
		
	}

	@Override
	public void setMediador(IMediador mediador) {
		// TODO Auto-generated method stub
		this.mediador = mediador;
	}

	@Override
	public void recibirMensaje(String mensaje, Object data) {
		// TODO Auto-generated method stub
		Jugador jugador = (Jugador) data;
		System.out.println("Mensaje recibido por ControladorJuego: "+ mensaje+ " - Nombre: "+jugador.getNombre() + " - Nickname: "+ jugador.getNickname());
	}

	private float timerLimit = 0.25f;
	private float timer = 0f;
	private long time = 0;
	
	private int indiceTexturaNueva = 0;
	private int indiceTexturaActual = 0;
	
	@Override
	public void actualizar(float deltaTiempo) {
		
		
		//Cada segundo!
		timer += deltaTiempo;
		if (timer >= timerLimit) {
			time++;
		    System.out.println("Timer Execution: "+ time);
		    timer -= timerLimit;
		    
		    if(indiceTexturaActual+1 < texturasEnemigo.length) {
		    	indiceTexturaNueva = indiceTexturaActual+1;
		    }else {
		    	indiceTexturaNueva = 0;
		    }
		    
		}
		
		Texture texturaNueva = null;
		if(indiceTexturaActual != indiceTexturaNueva) {
			texturaNueva = texturasEnemigo[indiceTexturaNueva];
			indiceTexturaActual = indiceTexturaNueva;
		}
		
		float radians = 3.1415f / 2;
		float dx = MathUtils.cos(radians);
		float speed = 7000;
		
		for (int i = 0; i < navesEnemigas.size(); i++) {
			
			ElementoJuego elementoJuego = navesEnemigas.get(i);
			if(texturaNueva!=null) {
				elementoJuego.setDrawable(new SpriteDrawable(new Sprite(texturaNueva)));
			}
			float x = elementoJuego.getX()+ (dx*speed);
			elementoJuego.setX(x);
		}
		
		vistaJuego.actualizar(deltaTiempo);
	}

	@Override
	public void renderizar() {
		// TODO Auto-generated method stub
		vistaJuego.renderizar();
	}

	@Override
	public void manejarEntradas() {
		// TODO Auto-generated method stub
		float direccion = 0;
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			direccion = -1;
		}
		
		
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			direccion = 1;
		}
		
		if(direccion == 0) return;
		
		float radians = 3.1415f / 2;
		float dx = MathUtils.cos(radians);
		float speed = 28000 * direccion;
		
		float x = naveJugador.getX() + (dx*speed);
		naveJugador.setX(x);
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		vistaJuego.dispose();
	}

	public List<ElementoJuego> obtenerElementosJuego() {
		return elementosJuego;
	}

}