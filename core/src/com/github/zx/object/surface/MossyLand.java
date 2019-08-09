package com.github.zx.object.surface;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.github.zx.object.SpriteAbstract;
import com.github.zx.utils.AssetsNameSpace;

/**
 * @Author: zx
 * @Date: 2019/8/2 14:12
 */
public class MossyLand extends SpriteAbstract {

    public static Texture texture = new Texture(Gdx.files.internal(AssetsNameSpace.core$assets$Mossy$png));

    public MossyLand(){
        super(new Sprite(texture));
    }
}
