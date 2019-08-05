package com.github.zx.render;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @Author: zx
 * @Date: 2019/8/1 18:35
 */
public class RenderFactory {

    public static Render CreateStaticRender(SpriteBatch spriteBatch){
        return new StaticRender(spriteBatch);
    }

}
