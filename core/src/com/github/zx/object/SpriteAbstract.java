package com.github.zx.object;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * @Author: zx
 * @Date: 2019/8/2 16:02
 */
public abstract class SpriteAbstract implements ISprite {

    /**
     * Sprite和PolygonSprite未实现相同接口
     */
    private Sprite sprite;

    public SpriteAbstract(Sprite sprite) {
        this.sprite = sprite;
    }

    public SpriteAbstract(Texture texture) {
        this.sprite = new Sprite(texture);
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public Sprite getSprite() {
        return sprite;
    }
    //创建:策略

    public void draw(Batch batch) {
        sprite.draw(batch);
    }

    public SpriteAbstract setPosition(float x, float y){
        this.sprite.setPosition(x,y);
        return this;
    }

    public SpriteAbstract setSize(float width, float height){
        this.sprite.setSize(width,height);
        return this;
    }
}
