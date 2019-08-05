package com.github.zx.prepare;

import com.github.zx.design.template.WorldBuilderTemplate;
import com.github.zx.object.MossyLand;
import com.github.zx.render.RenderManager;
import com.github.zx.render.StaticRender;

/**
 * @Author: zx
 * @Date: 2019/8/2 16:58
 */
public class WorldBuilder extends WorldBuilderTemplate {

    public WorldBuilder(RenderManager renderManager) {
        super(renderManager);
    }

    @Override
    public void builderLand() {
        //new object 存入对应render
        MossyLand mossyLand = new MossyLand();
        this.getRenderManager().setWorldObjectChunkMap(0,0,mossyLand, StaticRender.class);
    }
}
