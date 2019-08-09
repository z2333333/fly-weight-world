package com.github.zx.prepare;

import com.badlogic.gdx.Gdx;
import com.github.zx.design.template.WorldBuilderTemplate;
import com.github.zx.object.surface.SoilLand;
import com.github.zx.object.surface.SoilRichLand;
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
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        int mapSize = 128;

//        MossyLand mossyLand = new MossyLand();
//        mossyLand.setPosition(0, 0);
//        mossyLand.getSprite().setSize(w,h);
//        mossyLand.getSprite().setAlpha(0.6f);
//        this.getRenderManager().setWorldObjectChunkMap(0,0, mossyLand, StaticRender.class);

        SoilLand soilLand = new SoilLand();
        soilLand.getSprite().setPosition(0,0);
        soilLand.getSprite().setSize(w,h);
        this.getRenderManager().setWorldObjectChunkMap(0,0, soilLand, StaticRender.class);

        SoilRichLand soilRichLand = new SoilRichLand();
        soilRichLand.getSprite().setPosition(w/2,h/2);
        soilRichLand.getSprite().setSize(w,h);
        this.getRenderManager().setWorldObjectChunkMap(0,0, soilRichLand, StaticRender.class);
//        for (int i = 0; i <= mapSize; i++) {
//            for (int j = 0; j <= mapSize; j++) {
//                MossyLand mossyLand = new MossyLand();
//                mossyLand.setPosition(i * 128, j * 128);
//                this.getRenderManager().setWorldObjectChunkMap(i, j, mossyLand, StaticRender.class);
//            }
//        }
    }
}
