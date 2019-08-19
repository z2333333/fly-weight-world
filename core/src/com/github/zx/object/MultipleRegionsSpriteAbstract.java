package com.github.zx.object;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zx
 * @Date: 2019/8/19 16:09
 */
public abstract class MultipleRegionsSpriteAbstract implements ISprite{
    private TextureRegion[][] regions;
    private Map <String,Sprite> spriteMap = new HashMap<String, Sprite>();

    public MultipleRegionsSpriteAbstract(Texture texture, int cellWeight, int cellHeight,String[][] enumName) throws Exception {
        this.regions = TextureRegion.split(texture, cellWeight, cellHeight);
        if (regions.length != enumName.length) {
            throw new Exception("名称与切割数组个数不匹配");
        }

        for(int x=0; x<enumName.length; x++) {
            for(int y=0; y<enumName[x].length; y++) {
                spriteMap.put(enumName[x][y], new Sprite(regions[x][y]));
            }
        }
    }

    public Sprite getSprite(String name) {
        return spriteMap.get(name);
    }

    public Map <String,Sprite> getSprite() {
        return spriteMap;
    }

    public void draw(Batch batch) {
        //sprite.draw(batch);
    }
}
