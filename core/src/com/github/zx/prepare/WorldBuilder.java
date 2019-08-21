package com.github.zx.prepare;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.github.zx.design.template.WorldBuilderTemplate;
import com.github.zx.object.build.ConnectorEnum;
import com.github.zx.object.build.ConnectorFactory;
import com.github.zx.object.build.Stone.Stone;
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
        Gdx.app.log("runtime", "生成地表");
        int baseImgZoomRatio = 2;
        int mapSideLength = WorldConstant.basicUnitOfSize * WorldConstant.mapSize;
        //底图,basicUnitOfSize,mapSize三者都为2的幂以保证除尽
        int imgRatioSize = SoilLand.texture.getHeight() * baseImgZoomRatio;
        int imgSpliceNum = mapSideLength / imgRatioSize;

        for (int i = 0; i <= imgSpliceNum; i++) {
            for (int j = 0; j <= imgSpliceNum; j++) {
                SoilLand soilLand = new SoilLand();
                soilLand.setPosition(i * imgRatioSize, j * imgRatioSize)
                        .setSize(imgRatioSize, imgRatioSize);
                this.getRenderManager().setWorldObjectChunkMap(-1, -1, soilLand, StaticRender.class);
            }
        }

        SoilRichLand soilRichLand = new SoilRichLand(AssetsNameSpace.core$assets$pshs$SoilRich1$psh);
        soilRichLand.setPosition(WorldConstant.basicUnitOfSize * 45, WorldConstant.basicUnitOfSize * 62).setSize(w, h);
        this.getRenderManager().setWorldObjectChunkMap(0, 0, soilRichLand, StaticRender.class);
    }

    @Override
    public void builderWater() {
        Gdx.app.log("runtime", "生成水面");
        Water water = new Water(new float[]{});
        water.setPosition(WorldConstant.basicUnitOfSize * 15, WorldConstant.basicUnitOfSize * 10);
        this.getRenderManager().setWorldObjectChunkMap(0, 0, water, StaticRender.class);
    }

    @Override
    public void builderStone() {
        float baseX = WorldConstant.basicUnitOfSize * 150;
        float baseY = WorldConstant.basicUnitOfSize * 30;

        Gdx.app.log("runtime", "生成岩石");
        Stone downRightStone = new Stone(new Sprite(ConnectorFactory.getRockConnector(ConnectorEnum.DOWN_RIGHT).getTextureRegion()));
        downRightStone.setPosition(baseX, baseY);
        this.getRenderManager().setWorldObjectChunkMap(0, 0, downRightStone, StaticRender.class);

        for (int i = 0; i <= 15; i++) {
            baseX += downRightStone.getSprite().getWidth();
            Stone ExLeftRightStone = new Stone(new Sprite(ConnectorFactory.getRockConnector(ConnectorEnum.EX_LEFT_RIGHT).getTextureRegion()));
            ExLeftRightStone.setPosition(baseX, baseY);
            this.getRenderManager().setWorldObjectChunkMap(0, 0, ExLeftRightStone, StaticRender.class);
        }

        baseX += downRightStone.getSprite().getWidth();
        Stone leftDownStone = new Stone(new Sprite(ConnectorFactory.getRockConnector(ConnectorEnum.LEFT_DOWN).getTextureRegion()));
        leftDownStone.setPosition(baseX, baseY);
        this.getRenderManager().setWorldObjectChunkMap(0, 0, leftDownStone, StaticRender.class);

        for (int i = 0; i <= 2; i++) {
            baseY -= downRightStone.getSprite().getHeight();
            Stone upRightStone = new Stone(new Sprite(ConnectorFactory.getRockConnector(ConnectorEnum.UP_RIGHT).getTextureRegion()));
            upRightStone.setPosition(baseX, baseY);
            this.getRenderManager().setWorldObjectChunkMap(0, 0, upRightStone, StaticRender.class);

            baseX += downRightStone.getSprite().getWidth();
            Stone leftDownStone1 = new Stone(new Sprite(ConnectorFactory.getRockConnector(ConnectorEnum.LEFT_DOWN).getTextureRegion()));
            leftDownStone1.setPosition(baseX, baseY);
            this.getRenderManager().setWorldObjectChunkMap(0, 0, leftDownStone1, StaticRender.class);
        }

    }


}
