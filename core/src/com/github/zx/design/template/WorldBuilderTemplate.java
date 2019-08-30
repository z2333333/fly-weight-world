package com.github.zx.design.template;

import com.github.zx.render.RenderManager;

/**
 * @Author: zx
 * @Date: 2019/8/2 16:48
 */
public abstract class WorldBuilderTemplate {

    public abstract void builderLand();
    public abstract void builderWater();
    public abstract void builderStone();
    public abstract void builderPlant();
    public abstract void builderAnimal();

    private RenderManager renderManager;

    public WorldBuilderTemplate(RenderManager renderManager){
        this.renderManager = renderManager;
    }

    public void worldBuilder(){
        builderLand();
        builderWater();
        builderStone();
        builderPlant();
        builderAnimal();
    }

    public RenderManager getRenderManager() {
        return renderManager;
    }
}
