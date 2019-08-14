package com.github.zx.object;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;

/**
 * @Author: zx
 * @Date: 2019/8/9 17:32
 */
public abstract class PolygonSpriteAbstract implements ISprite{

    private PolygonSprite polygonSprite;
    private PolygonRegion polygonRegion;

    public PolygonSpriteAbstract(PolygonSprite polygonSprite){
        this.polygonSprite = polygonSprite;
    }

    public PolygonSpriteAbstract(Texture texture,String path){
        PolygonRegionLoader loader = new PolygonRegionLoader();
        PolygonRegion polygonRegion = loader.load(new TextureRegion(texture), Gdx.files.internal(path));
        this.polygonRegion = polygonRegion;
        this.polygonSprite = new PolygonSprite(this.polygonRegion);
    }

    public void setSprite(PolygonSprite sprite) {
        this.polygonSprite = sprite;
    }

    public PolygonSprite getSprite(){
        return polygonSprite;
    }

    public void draw(Batch batch) {
        polygonSprite.draw((PolygonSpriteBatch) batch);
    }
}
