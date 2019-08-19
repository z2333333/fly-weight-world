package com.github.zx.object.surface;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.github.zx.object.PolygonSpriteAbstract;
import com.github.zx.utils.AssetsNameSpace;

/**
 * @Author: zx
 * @Date: 2019/8/16 9:37
 */
public class Water extends PolygonSpriteAbstract {
    public static Texture texture = new Texture(Gdx.files.internal(AssetsNameSpace.core$assets$water$png));

    public Water(float[] pointCoordinates) {
        super(texture, pointCoordinates);
    }

    public Water(String path) {
        super(texture, path);
    }
}
