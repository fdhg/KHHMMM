package com.fdhg.projects.khhmmm.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.fdhg.projects.khhmmm.KHHMMM;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = KHHMMM.TITLE;
		config.width = KHHMMM.WIDTH / 2;
		config.height = KHHMMM.HEIGHT / 2;

		new LwjglApplication(new KHHMMM(), config);
	}
}