package com.github.zx.object.plant;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.github.zx.object.SpriteAbstract;
import com.github.zx.utils.AssetsNameSpace;

/**
 * @Author: zx
 * @Date: 2019/8/27 9:48
 */
public class Berry extends SpriteAbstract {
    public static Texture texture = new Texture(Gdx.files.internal(AssetsNameSpace.core$assets$textures$things$plant$berry$BerryBushA$png));

    public Berry() {
        super(new Sprite(texture));
    }

    public Berry(Texture texture) {
        super(texture);
    }
}
