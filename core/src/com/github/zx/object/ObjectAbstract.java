package com.github.zx.object;

import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * @Author: zx
 * @Date: 2019/8/2 16:02
 */
public class ObjectAbstract implements ISprite{

    private Sprite sprite;

    public ObjectAbstract(Sprite sprite){
        this.sprite = sprite;
    }


    public void setPosition(float x, float y){
        sprite.setPosition(x,y);
    }

    public Sprite getSprite(){
        return sprite;
    }
    //创建:策略
}
