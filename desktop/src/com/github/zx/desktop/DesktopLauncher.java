package com.github.zx.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.github.zx.FlyWeightWorldLauncher;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//config.fullscreen = true;
//        Graphics.DisplayMode displayMode = LwjglApplicationConfiguration.getDesktopDisplayMode();
//        config.setFromDisplayMode(displayMode);
        config.width=800;
        config.height=480;
		new LwjglApplication(new FlyWeightWorldLauncher(), config);
	}
}
