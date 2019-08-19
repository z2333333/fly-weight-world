package com.github.zx.object.surface;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.github.zx.object.PolygonSpriteAbstract;
import com.github.zx.utils.AssetsNameSpace;

/**
 * @Author: zx
 * @Date: 2019/8/9 14:04
 */
public class SoilRichLand extends PolygonSpriteAbstract {

    public static Texture texture = new Texture(Gdx.files.internal(AssetsNameSpace.core$assets$textures$surfaces$SoilRich$png));

    public SoilRichLand(float[] pointCoordinates) {
        super(texture, pointCoordinates);
    }

    public SoilRichLand(String path) {
        super(texture, path);
    }

    //new float[]{0,0,100,100,80,100,80,120,0,120,0,0}
}
