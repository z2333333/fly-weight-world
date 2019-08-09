package com.github.zx.render;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.github.zx.object.ISprite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zx
 * @Date: 2019/8/1 17:43
 */
public abstract class RenderAbstract implements Render{

    //世界地图的容器和单个render的容器划分
    private List<ISprite> renderObjectList = new ArrayList<ISprite>();
    private Batch spriteBatch;

    public RenderAbstract(Batch spriteBatch){
        this.spriteBatch = spriteBatch;
    }

    //draw方法
    public void draw(){
        for (ISprite sprite:renderObjectList) {
            //sprite.getSprite().draw(spriteBatch);
            sprite.draw(spriteBatch);
        }
    }
    public void setSpriteBatch(Batch spriteBatch){
        this.spriteBatch = spriteBatch;
    }
    public Batch getRenderSpriteBatch(){
        return this.spriteBatch;
    }
    public List<ISprite> getRenderObjectList(){
        return this.renderObjectList;
    }
    public boolean addObject(ISprite sprite){
        return renderObjectList.add(sprite);
    }
}
