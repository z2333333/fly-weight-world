package com.github.zx.prepare;

import com.badlogic.gdx.Gdx;
import com.github.zx.design.template.WorldBuilderTemplate;
import com.github.zx.object.surface.SoilLand;
import com.github.zx.object.surface.SoilRichLand;
import com.github.zx.object.surface.Water;
import com.github.zx.render.RenderManager;
import com.github.zx.render.StaticRender;
import com.github.zx.utils.AssetsNameSpace;
import com.github.zx.utils.WorldConstant;

/**
 * @Author: zx
 * @Date: 2019/8/2 16:58
 */
public class WorldBuilder extends WorldBuilderTemplate {

    public WorldBuilder(RenderManager renderManager) {
        super(renderManager);
    }
    float w = Gdx.graphics.getWidth();
    float h = Gdx.graphics.getHeight();

    @Override
    public void builderLand() {
        //new object 存入对应render
        int baseImgZoomRatio = 2;
        int mapSideLength = WorldConstant.basicUnitOfSize * WorldConstant.mapSize;
        //底图,basicUnitOfSize,mapSize三者都为2的幂以保证除尽
        int imgRatioSize = SoilLand.texture.getHeight()*baseImgZoomRatio;
        int imgSpliceNum = mapSideLength/imgRatioSize;
        //System.out.println(imgSpliceNum);

        for (int i = 0; i <= imgSpliceNum; i++) {
            for (int j = 0; j <= imgSpliceNum; j++) {
                SoilLand soilLand = new SoilLand();
                soilLand.getSprite().setPosition(i*imgRatioSize,j*imgRatioSize);
                soilLand.getSprite().setSize(imgRatioSize,imgRatioSize);
                this.getRenderManager().setWorldObjectChunkMap(-1,-1, soilLand, StaticRender.class);
            }
        }

        SoilRichLand soilRichLand = new SoilRichLand(AssetsNameSpace.core$assets$pshs$SoilRich1$psh);
        soilRichLand.getSprite().setPosition(w/2,h/2);
        soilRichLand.getSprite().setSize(w,h);
        this.getRenderManager().setWorldObjectChunkMap(0,0, soilRichLand, StaticRender.class);
    }

    @Override
    public void builderWater() {
        Water water = new Water(new float[]{});
        water.getSprite().setPosition(w / 2+WorldConstant.basicUnitOfSize*100, h / 2+WorldConstant.basicUnitOfSize*100);
        this.getRenderManager().setWorldObjectChunkMap(0,0,water,StaticRender.class);
    }

    @Override
    public void builderStone() {

    }


}
