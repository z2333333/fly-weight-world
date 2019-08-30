package com.github.zx.prepare;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.github.zx.design.template.WorldBuilderTemplate;
import com.github.zx.object.animal.Human;
import com.github.zx.object.build.ConnectorEnum;
import com.github.zx.object.build.ConnectorFactory;
import com.github.zx.object.build.Stone.Stone;
import com.github.zx.object.build.Stone.StoneSmear;
import com.github.zx.object.plant.Berry;
import com.github.zx.object.plant.Grass;
import com.github.zx.object.plant.Poplar;
import com.github.zx.object.surface.SoilLand;
import com.github.zx.object.surface.SoilRichLand;
import com.github.zx.object.surface.Water;
import com.github.zx.render.RenderManager;
import com.github.zx.render.StaticRender;
import com.github.zx.utils.AssetsNameSpace;
import com.github.zx.utils.WorldConstant;

import java.util.Random;

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
        water.setSize(1440,720);
        this.getRenderManager().setWorldObjectChunkMap(0, 0, water, StaticRender.class);
    }

    @Override
    public void builderStone() {
        float baseX = WorldConstant.basicUnitOfSize * 150;
        float baseY = WorldConstant.basicUnitOfSize * 30;

        Gdx.app.log("runtime", "生成岩石");

        StoneSmear stoneSmear = new StoneSmear(new float[]{});
        stoneSmear.setPosition(baseX + 50, baseY - 970);
        stoneSmear.setSize(80 * 17, 80 * 13);
        this.getRenderManager().setWorldObjectChunkMap(0, 0, stoneSmear, StaticRender.class);

        Stone downRightStone = new Stone(new Sprite(ConnectorFactory.getRockConnector(ConnectorEnum.DOWN_RIGHT).getTextureRegion()));
        downRightStone.setPosition(baseX, baseY);
        this.getRenderManager().setWorldObjectChunkMap(0, 0, downRightStone, StaticRender.class);

        float baseY1 = baseY;
        for (int i = 0; i <= 11; i++) {
            baseY1 -= downRightStone.getSprite().getWidth();
            Stone exUpDownStone = new Stone(new Sprite(ConnectorFactory.getRockConnector(ConnectorEnum.EX_UP_DOWN).getTextureRegion()));
            exUpDownStone.setPosition(baseX, baseY1);
            this.getRenderManager().setWorldObjectChunkMap(0, 0, exUpDownStone, StaticRender.class);
        }

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

        for (int i = 0; i <= 11; i++) {
            baseY -= downRightStone.getSprite().getWidth();
            Stone exUpDownStone = new Stone(new Sprite(ConnectorFactory.getRockConnector(ConnectorEnum.EX_UP_DOWN).getTextureRegion()));
            exUpDownStone.setPosition(baseX, baseY);
            this.getRenderManager().setWorldObjectChunkMap(0, 0, exUpDownStone, StaticRender.class);
        }
    }

    @Override
    public void builderPlant() {
        Gdx.app.log("runtime", "生成植物");
        int limitX = WorldConstant.basicUnitOfSize * WorldConstant.mapSize + 2000;
        int limitY = WorldConstant.basicUnitOfSize * WorldConstant.mapSize;

        for (int i = 0; i <= 600; i++) {
            Grass grass = new Grass();
            getOutShyAwayArea(limitX);
            grass.setPosition(areaX,areaY);
            this.getRenderManager().setWorldObjectChunkMap(0, 0, grass, StaticRender.class);
        }

        for (int i = 0; i <= 10; i++) {
            Berry berry = new Berry();
            getOutShyAwayArea(limitX);
            berry.setPosition(areaX,areaY);
            this.getRenderManager().setWorldObjectChunkMap(0, 0, berry, StaticRender.class);
        }

        for (int i = 0; i <= 60; i++) {
            Poplar poplar = new Poplar();
            getOutShyAwayArea(limitX);
            poplar.setPosition(areaX, areaY);
            this.getRenderManager().setWorldObjectChunkMap(0, 0, poplar, StaticRender.class);
        }
    }

    @Override
    public void builderAnimal() {
        Human human = new Human();
        human.setPosition(3500,3000);
        this.getRenderManager().setWorldObjectChunkMap(0, 0,human, StaticRender.class);
    }

    private static int areaX;
    private static int areaY;
    private static void getOutShyAwayArea(int limitX){

        Random random = new Random();
        areaX = random.nextInt(limitX);
        areaY = random.nextInt(limitX);

        //水面
        int x1_start = WorldConstant.basicUnitOfSize * 12;
        int x1_end = x1_start + 1500;
        int y1_start = WorldConstant.basicUnitOfSize * 8;
        int y1_end = y1_start + 800;

        int x2_start = WorldConstant.basicUnitOfSize * 140;
        int x2_end = x2_start + 2000;
        int y2_start = 0;
        int y2_end = WorldConstant.basicUnitOfSize * 32 + 80*10;

        if (areaX >= x1_start && areaX<=x1_end) {
            if (areaY >= y1_start && areaY<=y1_end) {
                getOutShyAwayArea(limitX);
            }
        }

        if (areaX > x2_start && areaX<x2_end) {
            if (areaY > y2_start && areaY<y2_end) {
                getOutShyAwayArea(limitX);
            }
        }
    }

}
