package com.github.zx.design.template;

import com.github.zx.render.RenderManager;

/**
 * @Author: zx
 * @Date: 2019/8/2 16:48
 */
public abstract class WorldBuilderTemplate {

    public abstract void builderLand();
    private RenderManager renderManager;

    public WorldBuilderTemplate(RenderManager renderManager){
        this.renderManager = renderManager;
    }

    public void worldBuilder(){
        builderLand();
    }

    public RenderManager getRenderManager() {
        return renderManager;
    }
}
