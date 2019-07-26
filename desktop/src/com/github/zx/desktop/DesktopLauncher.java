package com.github.zx.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.github.zx.FlyweightWorldApplication;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//config.fullscreen = true;
        config.width=480*3;
        config.height=320*3;
		new LwjglApplication(new FlyweightWorldApplication(), config);
	}
}
