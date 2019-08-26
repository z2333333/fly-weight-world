package com.github.zx.object.plant;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.github.zx.object.SpriteAbstract;
import com.github.zx.utils.AssetsNameSpace;

/**
 * @Author: zx
 * @Date: 2019/8/26 14:04
 */
public class Grass extends SpriteAbstract {
    public static Texture texture = new Texture(Gdx.files.internal(AssetsNameSpace.core$assets$textures$things$plant$glass$GrassA$png));

    public Grass() {
        super(new Sprite(texture));
    }

    public Grass(Texture texture) {
        super(texture);
    }
}
