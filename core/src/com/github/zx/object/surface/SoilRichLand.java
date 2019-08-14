package com.github.zx.object.surface;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.PolygonRegion;
import com.badlogic.gdx.graphics.g2d.PolygonSprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.github.zx.object.PolygonSpriteAbstract;
import com.github.zx.utils.AssetsNameSpace;

/**
 * @Author: zx
 * @Date: 2019/8/9 14:04
 */
public class SoilRichLand extends PolygonSpriteAbstract {

    public static Texture texture = new Texture(Gdx.files.internal(AssetsNameSpace.core$assets$textures$surfaces$SoilRich$png));

    public SoilRichLand(float[] pointCoordinates){
        super(new PolygonSprite(new PolygonRegion(new TextureRegion(texture),pointCoordinates,new short[] {0,1,2})));
    }
    //new float[]{0,0,100,100,80,100,80,120,0,120,0,0}

    public SoilRichLand(String path){
        super(texture,path);
    }
}
