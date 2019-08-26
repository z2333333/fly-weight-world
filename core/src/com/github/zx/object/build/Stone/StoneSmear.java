package com.github.zx.object.build.Stone;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.github.zx.object.PolygonSpriteAbstract;
import com.github.zx.utils.AssetsNameSpace;

/**
 * @Author: zx
 * @Date: 2019/8/22 9:45
 */
public class StoneSmear extends PolygonSpriteAbstract {
    public static Texture texture = new Texture(Gdx.files.internal(AssetsNameSpace.core$assets$textures$surfaces$StoneCover$png));

    public StoneSmear(float[] pointCoordinates) {
        super(texture, pointCoordinates);
    }

    public StoneSmear(String path) {
        super(texture, path);
    }
}
