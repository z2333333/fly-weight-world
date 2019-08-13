package com.github.zx.object.surface;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.github.zx.object.SpriteAbstract;
import com.github.zx.utils.AssetsNameSpace;

/**
 * @Author: zx
 * @Date: 2019/8/9 14:06
 */
public class SoftSandLand extends SpriteAbstract {

    public static Texture texture = new Texture(Gdx.files.internal(AssetsNameSpace.core$assets$textures$things$pawn$animal$bear$Bear_east$png));

    public SoftSandLand(){
        super(new Sprite(texture));
    }
}
