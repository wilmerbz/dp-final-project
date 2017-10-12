package com.space.invaders.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.space.invaders.SpaceInvadersGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Space Invaders © 2018";
		
		//https://pacoup.com/2011/06/12/list-of-true-169-resolutions/
		config.width = 1152;
		config.height= 648;
		config.fullscreen= false;
		config.resizable = false;
		
		new LwjglApplication(new SpaceInvadersGame(), config);
	}
}
