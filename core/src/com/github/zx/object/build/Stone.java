package com.github.zx.object.build;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.github.zx.object.MultipleRegionsSpriteAbstract;
import com.github.zx.utils.AssetsNameSpace;

/**
 * @Author: zx
 * @Date: 2019/8/19 15:57
 */
public class Stone extends MultipleRegionsSpriteAbstract {
    public static Texture texture = new Texture(Gdx.files.internal(AssetsNameSpace.core$assets$textures$buliding$linked$Rock_Atlas$png));

    public Stone(Texture texture, int cellWeight, int cellHeight, String[][] enumName) throws Exception {
        super(texture, cellWeight, cellHeight, enumName);
    }
}
