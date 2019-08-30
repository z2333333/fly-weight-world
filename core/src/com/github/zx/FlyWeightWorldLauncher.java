package com.github.zx;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class FlyWeightWorldLauncher extends ApplicationAdapter {
    FlyWeightWorldApplication flyWeightWorldApplication;

	@Override
	public void create () {
	    flyWeightWorldApplication = FlyWeightWorldApplication.getInstance();
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        Gdx.app.log("runtime","窗口配置完毕!");
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        flyWeightWorldApplication.draw();
	}
	
	@Override
	public void dispose () {
	}
}
