package com.github.zx;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.github.zx.design.template.WorldBuilderTemplate;
import com.github.zx.prepare.WorldBuilder;
import com.github.zx.render.RenderManager;

/**
 * @Author: zx
 * @Date: 2019/8/1 15:26
 */
public class FlyWeightWorldApplication {

    private final RenderManager renderManager;

    private FlyWeightWorldApplication(){
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        Gdx.app.log("runtime","启动时配置");
        renderManager = new RenderManager();
        WorldBuilderTemplate worldBuilderTemplate = new WorldBuilder(renderManager);
        worldBuilderTemplate.worldBuilder();
    }

    public void draw(){
        renderManager.getSpriteBatch().begin();
        renderManager.draw();
        renderManager.getSpriteBatch().end();
    }

    private static class FlyWeightWorldApplicationHolder{
        private static FlyWeightWorldApplication instance = new FlyWeightWorldApplication();
    }

    public static final FlyWeightWorldApplication getInstance(){
        return FlyWeightWorldApplicationHolder.instance;
    }

    public RenderManager getRenderManager() {
        return renderManager;
    }
}
