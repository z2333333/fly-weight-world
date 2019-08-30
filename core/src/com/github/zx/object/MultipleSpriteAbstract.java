package com.github.zx.object;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.*;

/**
 * @Author: zx
 * @Date: 2019/8/28 11:09
 */
public abstract class MultipleSpriteAbstract implements ISprite{
    private Map<String,Sprite> spriteMap;
    private Map<String,Config> configMap;

    public MultipleSpriteAbstract() {
        this.spriteMap = new LinkedHashMap<String, Sprite>();
        this.configMap = new HashMap<String, Config>();
    }

    public MultipleSpriteAbstract addSprite(String name,Sprite sprite){
        spriteMap.put(name,sprite);
        return this;
    }

    public MultipleSpriteAbstract addSprite(String name,Sprite sprite,float x, float y){
        if (configMap.containsKey(name)) {
            configMap.get(name).setOffset(x,y);
        }else {
            Config config = new Config(x,y);
            configMap.put(name, config);
        }
        sprite.setPosition(x,y);

        spriteMap.put(name,sprite);
        return this;
    }

    public MultipleSpriteAbstract setPosition(float x, float y){
        for(Map.Entry<String, Sprite> entry:spriteMap.entrySet()){
            if (configMap.containsKey(entry.getKey())) {
                entry.getValue().setPosition(configMap.get(entry.getKey()).getOffsetX()+x,configMap.get(entry.getKey()).getOffsetY()+y);
            }else {
                entry.getValue().setPosition(x, y);
            }
        }
        return this;
    }

    public MultipleSpriteAbstract setSize(float width, float height){
        for(Map.Entry<String, Sprite> entry:spriteMap.entrySet()){
            entry.getValue().setSize(width,height);
        }
        return this;
    }

    public void draw(Batch batch) {
        for(Map.Entry<String, Sprite> entry:spriteMap.entrySet()){
//            if (configMap.containsKey(entry.getKey())) {
//                entry.getValue().setX(entry.getValue().getX()+configMap.get(entry.getKey()).getOffsetX());
//                entry.getValue().setY(entry.getValue().getY()+configMap.get(entry.getKey()).getOffsetY());
//            }
            entry.getValue().draw(batch);
        }
    }

    private class Config{
        float offsetX,offsetY;
        public Config(float offsetX,float offsetY){
            this.offsetX=offsetX;
            this.offsetY=offsetY;
        }
        public float getOffsetX(){
            return offsetX;
        }
        public float getOffsetY(){
            return offsetY;
        }
        public void setOffset(float offsetX,float offsetY){
            this.offsetX=offsetX;
            this.offsetY=offsetY;
        }
    }
}
