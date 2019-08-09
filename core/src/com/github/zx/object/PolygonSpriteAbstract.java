package com.github.zx.object;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.PolygonSprite;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;

/**
 * @Author: zx
 * @Date: 2019/8/9 17:32
 */
public abstract class PolygonSpriteAbstract implements ISprite{

    private PolygonSprite polygonSprite;

    public PolygonSpriteAbstract(PolygonSprite polygonSprite){
        this.polygonSprite = polygonSprite;
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
