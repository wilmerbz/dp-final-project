package com.space.invaders.actores;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.space.invaders.recursos.texturas.AdministradorTexturas;
import com.space.invaders.recursos.texturas.IAdministradorTexturas;

/**
* Permite dibujar un fondo que se mueve de manera infinita.
 */
public class FondoInfinito extends Actor {

    private final TextureRegion textureRegion;
    private Rectangle textureRegionBounds1;
    private Rectangle textureRegionBounds2;
	protected static int WIDTH;
	protected static int HEIGHT;
    private int speed = 100;

    /**
     * Crea un anueva instancia de Fondo Infinito utilizando la textura indicada.
     * @param nombreTextura Nombre de textura del fondo.
     */
    public FondoInfinito(String nombreTextura) {
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();
		
    	IAdministradorTexturas administradorTexturas = AdministradorTexturas.getInstancia();
        textureRegion = new TextureRegion(administradorTexturas.obtenerTextura(nombreTextura));
        textureRegionBounds1 = new Rectangle(0, 0 , WIDTH, HEIGHT);
        textureRegionBounds2 = new Rectangle(0, 0-HEIGHT , WIDTH, HEIGHT);
    }

    @Override
    public void act(float delta) {
        if (topBoundsReached(delta)) {
            resetBounds();
        } else {
            updateYBounds(delta);
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(textureRegion, textureRegionBounds1.x, textureRegionBounds1.y, WIDTH, HEIGHT);
        batch.draw(textureRegion, textureRegionBounds2.x, textureRegionBounds2.y, WIDTH, HEIGHT);
    }

    private boolean topBoundsReached(float delta) {
        return (textureRegionBounds2.y + (delta * speed)) >= (0);
    }

    private void updateYBounds(float delta) {
        textureRegionBounds1.y += (delta * speed);
        textureRegionBounds2.y += (delta * speed);
    }

    private void resetBounds() {
        textureRegionBounds1 = textureRegionBounds2;
        textureRegionBounds2 = new Rectangle(0, 0-HEIGHT, WIDTH, HEIGHT);
    }

}