package com.github.zx.object.surface;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.github.zx.object.SpriteAbstract;
import com.github.zx.utils.AssetsNameSpace;

/**
 * @Author: zx
 * @Date: 2019/8/9 14:02
 */
public class SoilLand extends SpriteAbstract {

    public static Texture texture = new Texture(Gdx.files.internal(AssetsNameSpace.core$assets$textures$surfaces$Soil$png));

    public SoilLand(){
        super(new Sprite(texture));
    }
}
