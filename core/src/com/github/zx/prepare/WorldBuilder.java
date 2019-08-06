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
        int mapSize = 128;
        for (int i = 0; i <= mapSize; i++) {
            for (int j = 0; j <= mapSize; j++) {
                MossyLand mossyLand = new MossyLand();
                mossyLand.setPosition(i * 128, j * 128);
                this.getRenderManager().setWorldObjectChunkMap(i, j, mossyLand, StaticRender.class);
            }
        }
    }
}
